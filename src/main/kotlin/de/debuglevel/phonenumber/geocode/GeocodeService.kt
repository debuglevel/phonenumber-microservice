package de.debuglevel.phonenumber.geocode

import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder
import de.debuglevel.phonenumber.InvalidPhonenumberException
import de.debuglevel.phonenumber.parser.PhonenumberService
import mu.KotlinLogging
import java.util.*
import javax.inject.Singleton

@Singleton
class GeocodeService(
    private val phonenumberService: PhonenumberService
) {
    private val logger = KotlinLogging.logger {}

    private val geocoder = PhoneNumberOfflineGeocoder.getInstance()

    /**
     * Geocodes a phone number.
     *
     * For a phone number like `+49 951 12345678`, `Bamberg` is returned.
     *
     * @param phonenumber a valid phone number
     * @throws InvalidPhonenumberException thrown if the given phone number is invalid
     * @return geo-coded location of a phone number
     */
    @Throws(InvalidPhonenumberException::class)
    fun geocode(phonenumber: String): Geocode {
        logger.debug { "Geocoding '$phonenumber'..." }

        val validPhonenumber = phonenumberService.parseAndValidate(phonenumber)

        val geocode = Geocode(geocoder.getDescriptionForNumber(validPhonenumber, Locale.GERMAN))

        logger.debug { "Geocoded '$phonenumber': '$geocode'" }

        return geocode
    }

    /**
     * A valid and formatted phone number
     */
    data class Geocode(val location: String)
}