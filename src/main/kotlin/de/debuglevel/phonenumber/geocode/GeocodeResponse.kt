package de.debuglevel.phonenumber.geocode

data class GeocodeResponse(
    val phonenumber: String,
    val location: String? = null,
    val error: String? = null
)