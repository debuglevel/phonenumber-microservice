package de.debuglevel.phonenumber.format

import io.micronaut.core.annotation.Introspected

@Introspected
data class FormatResponseDTO(
    val phonenumber: String,
    val formattedPhonenumber: String? = null,
    val error: String? = null
)