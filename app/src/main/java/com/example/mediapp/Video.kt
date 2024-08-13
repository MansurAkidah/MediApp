package com.example.mediapp

class Video {
    var path: String? = null
    var title: String? = null
    var thumbnailUri: String? = null

    constructor(path: String?, title: String?, thumbnailUri: String?) {
        this.path = path
        this.title = title
        this.thumbnailUri = thumbnailUri
    }

    fun getpath(): String? {
        return path
    }

    fun setpath(path: String?) {
        this.path = path
    }

    fun gettitle(): String? {
        return title
    }

    fun settitle(title: String?) {
        this.title = title
    }

    fun getthumbnailUri(): String? {
        return thumbnailUri
    }

    fun setthumbnailUri(thumbnailUri: String?) {
        this.thumbnailUri = thumbnailUri
    }
}
