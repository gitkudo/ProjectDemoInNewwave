package com.example.kudonavdrawerdemo.model

class Faq {
    var title = ""
    var content = ""
    var expandable = false

    constructor(title: String, content: String, expandable: Boolean) {
        this.title = title
        this.content = content
        this.expandable = expandable
    }
}