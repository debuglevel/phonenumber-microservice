package de.debuglevel.phonenumber

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber

object PhonenumberUtils {
    private val phonenumberUtil = PhoneNumberUtil.getInstance()

    fun parseToValidPhonenumber(phonenumber: String, defaultRegion: String): Phonenumber.PhoneNumber {
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
}