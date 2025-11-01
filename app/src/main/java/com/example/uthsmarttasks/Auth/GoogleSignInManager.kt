package com.example.uthsmarttasks.Auth

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class GoogleSignInManager(private val activity: Activity) {
    private val auth = FirebaseAuth.getInstance()
    private val oneTapClient: SignInClient = Identity.getSignInClient(activity)

    fun signIn(launcher: ActivityResultLauncher<IntentSenderRequest>) {
        val signInRequest = BeginSignInRequest.Builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId("497554399729-4u3v1ggmjier731jf0iqjcamfeuiuebp.apps.googleusercontent.com") // 🔥 Thay bằng Web client ID từ Firebase
                    .setFilterByAuthorizedAccounts(false)
                    .build()
            ).build()

        oneTapClient.beginSignIn(signInRequest)
            .addOnSuccessListener { result ->
                val intentSenderRequest =
                    IntentSenderRequest.Builder(result.pendingIntent.intentSender).build()
                launcher.launch(intentSenderRequest)
            }
            .addOnFailureListener {
                it.printStackTrace()
            }
    }

    fun handleSignInResult(data: Intent?, onResult: (Boolean, String?) -> Unit) {
        val credential = oneTapClient.getSignInCredentialFromIntent(data)
        val idToken = credential.googleIdToken

        if (idToken != null) {
            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(firebaseCredential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onResult(true, auth.currentUser?.displayName)
                    } else {
                        onResult(false, task.exception?.message)
                    }
                }
        } else {
            onResult(false, "Không lấy được ID token")
        }
    }
}