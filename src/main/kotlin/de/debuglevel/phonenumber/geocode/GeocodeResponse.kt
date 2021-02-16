package de.debuglevel.phonenumber.geocode

data class GeocodeResponse(
    val phonenumber: String,
    val location: String? = null,
    val regionCode: String? = null,
    val type: String? = null,
    val error: String? = null
)