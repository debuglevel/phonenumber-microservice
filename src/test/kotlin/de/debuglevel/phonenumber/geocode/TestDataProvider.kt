package de.debuglevel.phonenumber.geocode

import java.util.stream.Stream

object TestDataProvider {
    fun validPhonenumberProvider() = Stream.of(
        PhonenumberTestData(value = "(09 51) 1234567", expectedLocation = "Bamberg", expectedRegionCode = "DE"),
        PhonenumberTestData(value = "0721 1234567", expectedLocation = "Karlsruhe", expectedRegionCode = "DE"),
        PhonenumberTestData(value = "+4974251234567", expectedLocation = "Trossingen", expectedRegionCode = "DE"),
        PhonenumberTestData(value = "+49301234567", expectedLocation = "Berlin", expectedRegionCode = "DE"),
        PhonenumberTestData(value = "+43 1 534899", expectedLocation = "Wien", expectedRegionCode = "AT"),
        PhonenumberTestData(value = "+41 441 234567", expectedLocation = "Zürich", expectedRegionCode = "CH"),
        PhonenumberTestData(value = "+49 176 1234567", expectedLocation = "Deutschland", expectedRegionCode = "DE")
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
        val expectedRegionCode: String? = null
    )
}