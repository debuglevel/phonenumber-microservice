package de.debuglevel.phonenumber.parser

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import de.debuglevel.phonenumber.InvalidPhonenumberException
import io.micronaut.context.annotation.Value
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class PhonenumberService(
    @Value("\${app.default-region:DE}") private val defaultRegion: String = ""
) {
    private val logger = KotlinLogging.logger {}

    private val phonenumberUtil = PhoneNumberUtil.getInstance()

    fun parseAndValidate(phonenumber: String): Phonenumber.PhoneNumber {
        return try {
            val parsedPhonenumber = phonenumberUtil.parse(phonenumber, defaultRegion)

            if (!phonenumberUtil.isValidNumber(parsedPhonenumber)) {
                throw InvalidPhonenumberException(phonenumber)
            }

            parsedPhonenumber
        } catch (e: NumberParseException) {
            throw InvalidPhonenumberException(phonenumber, e)
        }
    }

    fun getRegionCode(phonenumber: Phonenumber.PhoneNumber): String {
        return phonenumberUtil.getRegionCodeForNumber(phonenumber)
    }

    fun getNumberType(phonenumber: Phonenumber.PhoneNumber): PhoneNumberUtil.PhoneNumberType {
        return phonenumberUtil.getNumberType(phonenumber)
    }
}