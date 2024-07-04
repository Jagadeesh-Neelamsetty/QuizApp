package com.example.quizapp

class QuestionModel {
var question:String? = null
    var opt1:String? = null
    var opt2:String? = null
    var opt3:String? = null
    var opt4:String? = null
    var answer:String? = null

    constructor()
    constructor(
        question: String?,
        opt1: String?,
        opt2: String?,
        opt3: String?,
        opt4: String?,
        answer: String?
    ) {
        this.question = question
        this.opt1 = opt1
        this.opt2 = opt2
        this.opt3 = opt3
        this.opt4 = opt4
        this.answer = answer
    }
}