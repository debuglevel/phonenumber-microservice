package de.debuglevel.phonenumber.information

import com.google.i18n.phonenumbers.PhoneNumberUtil
import java.util.stream.Stream

object TestDataProvider {
    fun validPhonenumberProvider() = Stream.of(
        PhonenumberTestData(
            value = "(09 51) 1234567",
            expectedLocation = "Bamberg",
            expectedFormat = "+49 (951) 1234567",
            expectedRegionCode = "DE",
            expectedType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE.name
        ),
        PhonenumberTestData(
            value = "0721 1234567",
            expectedLocation = "Karlsruhe",
            expectedFormat = "+49 (721) 1234567",
            expectedRegionCode = "DE",
            expectedType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE.name
        ),
        PhonenumberTestData(
            value = "+4974251234567",
            expectedLocation = "Trossingen",
            expectedFormat = "+49 (7425) 1234567",
            expectedRegionCode = "DE",
            expectedType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE.name
        ),
        PhonenumberTestData(
            value = "+49301234567",
            expectedLocation = "Berlin",
            expectedFormat = "+49 (30) 1234567",
            expectedRegionCode = "DE",
            expectedType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE.name
        ),
        PhonenumberTestData(
            value = "+43 1 534899",
            expectedLocation = "Wien",
            expectedFormat = "+43 (1) 534899",
            expectedRegionCode = "AT",
            expectedType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE.name
        ),
        PhonenumberTestData(
            value = "+41 441 234567",
            expectedLocation = "Zürich",
            expectedFormat = "+41 (44) 123 45 67",
            expectedRegionCode = "CH",
            expectedType = PhoneNumberUtil.PhoneNumberType.FIXED_LINE.name
        ),
        PhonenumberTestData(
            value = "+49 176 1234567",
            expectedLocation = "Deutschland",
            expectedFormat = "+49 (176) 1234567",
            expectedRegionCode = "DE",
            expectedType = PhoneNumberUtil.PhoneNumberType.MOBILE.name
        )
    )

    fun invalidPhonenumberProvider() = Stream.of(
        PhonenumberTestData(value = "1"),
        PhonenumberTestData(value = "+12"),
        PhonenumberTestData(value = "1/2"),
        PhonenumberTestData(value = "+1 2"),
        PhonenumberTestData(value = "foo"),

        // internal numbers
        PhonenumberTestData(value = "123"),
        PhonenumberTestData(value = "111"),
        PhonenumberTestData(value = "333"),
        PhonenumberTestData(value = "21"),
        PhonenumberTestData(value = "09"),

        // invalid numbers
        PhonenumberTestData(value = "+49(151)23299"),
        PhonenumberTestData(value = "015123299")
    )

    data class PhonenumberTestData(
        val value: String,
        val expectedLocation: String? = null,
        val expectedRegionCode: String? = null,
        val expectedFormat: String? = null,
        val expectedType: String? = null,
    )
}