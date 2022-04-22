package uz.devtillo.unittesting.utils

import java.util.*

object Common {

    //isFirst Function
    fun doSomething(someDate: Date?): String {
        val date = Date()
        return if (date.after(someDate)) {
            "Tomorrow"
        } else if (date.before(someDate)) {
            "Yesterday"
        } else {
            "Equal"
        }
    }

    //is second Function
    fun doSomething(source: Date, someDate: Date?): String? {
        return if (source.after(someDate)) {
            "Tomorrow"
        } else if (source.before(someDate)) {
            "Yesterday"
        } else {
            "Equal"
        }
    }
}