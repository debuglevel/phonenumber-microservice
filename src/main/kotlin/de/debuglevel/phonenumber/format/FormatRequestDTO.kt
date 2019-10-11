package de.debuglevel.phonenumber.format

import io.micronaut.core.annotation.Introspected

@Introspected
data class FormatRequestDTO(val phonenumber: String)