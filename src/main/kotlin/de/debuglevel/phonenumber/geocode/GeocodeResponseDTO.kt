package de.debuglevel.phonenumber.geocode

class GeocodeResponseDTO(
    val phonenumber: String,
    val location: String? = null,
    val error: String? = null
)