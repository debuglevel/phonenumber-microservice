package de.debuglevel.phonenumber.geocode

data class GeocodeResponseDTO(
    val phonenumber: String,
    val location: String? = null,
    val error: String? = null
)