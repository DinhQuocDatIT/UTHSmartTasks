package com.example.uthsmarttasks.data.model

class Introduce(var titleIntroduce:String, var contentIntroduce:String,var imageIntroduce:Int)  {
    private  var _title:String = titleIntroduce
    private  var _content:String = contentIntroduce
    private  var _image:Int =imageIntroduce

    public  var image : Int
        get() = _image
        set(value) {_image =value}

    public var title: String
        get() = _title
        set(value)  {_title = value}

    public  var content : String
        get() = _content
        set(value) {_content = value}
}