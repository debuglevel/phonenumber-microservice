package de.debuglevel.phonenumber.geocode

import io.micronaut.core.annotation.Introspected

@Introspected
data class GeocodeResponseDTO(
    val phonenumber: String,
    val location: String? = null,
    val error: String? = null
)