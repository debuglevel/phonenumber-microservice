package de.debuglevel.phonenumber.format

data class FormatResponse(
    val phonenumber: String,
    val formattedPhonenumber: String? = null,
    val error: String? = null
)