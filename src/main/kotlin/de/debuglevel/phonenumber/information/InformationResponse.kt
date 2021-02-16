package de.debuglevel.phonenumber.information

data class InformationResponse(
    val phonenumber: String,
    val formattedPhonenumber: String? = null,
    val location: String? = null,
    val regionCode: String? = null,
    val type: String? = null,
    val error: String? = null
)