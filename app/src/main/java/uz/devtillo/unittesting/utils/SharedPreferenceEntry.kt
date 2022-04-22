package uz.devtillo.unittesting.utils

import java.util.*

class SharedPreferenceEntry(
    val name: String,
    var dateOfBirth: Calendar, // Date of Birth of the user.
    val email: String?    // Email address of the user.
)