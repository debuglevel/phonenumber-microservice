package de.debuglevel.phonenumber.format

class FormatResponseDTO(
    val phonenumber: String,
    val formattedPhonenumber: String? = null,
    val error: String? = null
)