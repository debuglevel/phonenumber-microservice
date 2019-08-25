package de.debuglevel.phonenumber.geocode

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder
import de.debuglevel.phonenumber.InvalidPhonenumberException
import io.micronaut.context.annotation.Value
import mu.KotlinLogging
import java.util.*
import javax.inject.Singleton

@Singleton
class GeocodeService(
    @Value("\${app.default-region:DE}") private val defaultRegion: String = ""
) {
    private val logger = KotlinLogging.logger {}

    private val geocoder = PhoneNumberOfflineGeocoder.getInstance()
    private val phonenumberUtil = PhoneNumberUtil.getInstance()

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

        val validPhonenumber = try {
            val parsedPhonenumber = phonenumberUtil.parse(phonenumber, defaultRegion)

            if (!phonenumberUtil.isValidNumber(parsedPhonenumber)) {
                throw InvalidPhonenumberException(phonenumber)
            }

            parsedPhonenumber
        } catch (e: NumberParseException) {
            throw InvalidPhonenumberException(phonenumber, e)
        }

        val geocode = Geocode(geocoder.getDescriptionForNumber(validPhonenumber, Locale.GERMAN))

        logger.debug { "Geocoded '$phonenumber': '$geocode'" }

        return geocode
    }

    /**
     * A valid and formatted phone number
     */
    data class Geocode(val location: String)
}