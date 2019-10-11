package de.debuglevel.phonenumber.geocode

import io.micronaut.core.annotation.Introspected

@Introspected
data class GeocodeRequestDTO(val phonenumber: String)