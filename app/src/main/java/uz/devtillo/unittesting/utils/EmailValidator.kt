package uz.devtillo.unittesting.utils

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class EmailValidator() : TextWatcher {
    var isValid = false
        private set

    override fun afterTextChanged(editableText: Editable) {
        isValid = isValidEmail(editableText)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { /*No-op*/
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) { /*No-op*/
    }

    companion object {

        fun isValidEmail(email: CharSequence?): Boolean {
            val EMAIL_PATTERN = email?.isNotEmpty()!! && Pattern.compile(
                "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
                        ")+"
            ).matcher(email).matches()
            return EMAIL_PATTERN
        }
    }
}