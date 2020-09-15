package de.debuglevel.phonenumber.format

data class FormatResponseDTO(
    val phonenumber: String,
    val formattedPhonenumber: String? = null,
    val error: String? = null
)