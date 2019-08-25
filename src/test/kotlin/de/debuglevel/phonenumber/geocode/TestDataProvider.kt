package de.debuglevel.phonenumber.geocode

import java.util.stream.Stream

object TestDataProvider {
    fun validPhonenumberProvider() = Stream.of(
        PhonenumberTestData(value = "(09 51) 1234567", expected = "Bamberg"),
        PhonenumberTestData(value = "0721 1234567", expected = "Karlsruhe"),
        PhonenumberTestData(value = "+4974251234567", expected = "Trossingen"),
        PhonenumberTestData(value = "+49301234567", expected = "Berlin"),
        PhonenumberTestData(value = "+43 1 534899", expected = "Wien"),
        PhonenumberTestData(value = "+41 441 234567", expected = "Zürich"),
        PhonenumberTestData(value = "+49 176 1234567", expected = "Deutschland")
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
        val expected: String? = null
    )
}