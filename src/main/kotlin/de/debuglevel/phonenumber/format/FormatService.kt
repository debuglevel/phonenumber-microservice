package de.debuglevel.phonenumber.format

import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import de.debuglevel.phonenumber.InvalidPhonenumberException
import io.micronaut.context.annotation.Value
import mu.KotlinLogging
import javax.inject.Singleton

@Singleton
class FormatService(
    @Value("\${app.default-region:DE}") private val defaultRegion: String = ""
) {
    private val logger = KotlinLogging.logger {}

    private val phonenumberUtil = PhoneNumberUtil.getInstance()

    /**
     * Formats a given phone number according to the current (i.e. they might change) formatting rules.
     *
     * A phone number like `0951/12345-678` gets formatted to `+49 (951) 12345678`.
     *
     * @param phonenumber a (valid) phone number, formatted in any way
     * @throws InvalidPhonenumberException thrown if the given phone number is invalid
     * @return the formatted phone number
     */
    @Throws(InvalidPhonenumberException::class)
    fun format(phonenumber: String): FormattedPhonenumber {
        logger.debug { "Formatting '$phonenumber'..." }

        val validPhonenumber = try {
            val parsedPhonenumber = phonenumberUtil.parse(phonenumber, defaultRegion)

            if (!phonenumberUtil.isValidNumber(parsedPhonenumber)) {
                throw InvalidPhonenumberException(phonenumber)
            }

            parsedPhonenumber
        } catch (e: NumberParseException) {
            throw InvalidPhonenumberException(phonenumber, e)
        }

        val formattedNumber = FormattedPhonenumber(
            phonenumberUtil.format(
                validPhonenumber,
                PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL
            )
        )
        val bracketNumber = addBrackets(formattedNumber)

        logger.debug { "Formatted '$phonenumber': '$bracketNumber'..." }

        return bracketNumber
    }

    /**
     * Adds brackets around the city prefix of a phone number.
     *
     * A number like `+49 951 12345678` gets formatted to `+49 (951) 12345678`.
     *
     * @param formattedPhonenumber an already formatted phone number
     * @return the phone number with brackets around the city prefix
     */
    private fun addBrackets(formattedPhonenumber: FormattedPhonenumber): FormattedPhonenumber {
        logger.debug { "Adding brackets to number '$formattedPhonenumber'..." }

        val parts = formattedPhonenumber.formattedPhonenumber.split(' ')
        val numberWithBrackets =
            ("${parts[0]} (${parts[1]}) " +
                    parts.subList(2, parts.size).joinToString(" "))
                .trim()

        val formattedNumberWithBrackets = FormattedPhonenumber(numberWithBrackets)

        logger.debug { "Added brackets to number '$formattedPhonenumber': '$formattedNumberWithBrackets'" }

        return formattedNumberWithBrackets
    }

    /**
     * A valid and formatted phone number
     */
    data class FormattedPhonenumber(val formattedPhonenumber: String)
}