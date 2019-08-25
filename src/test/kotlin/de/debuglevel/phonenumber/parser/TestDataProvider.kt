package de.debuglevel.phonenumber.parser

import java.util.stream.Stream

object TestDataProvider {
    fun validPhonenumberProvider() = Stream.of(
        PhonenumberTestData(
            value = "(09 51) 2 08 50-11",
            expectedCountryCode = 49,
            expectedNationalNumber = 9512085011
        ),
        PhonenumberTestData(value = "0951 2085011", expectedCountryCode = 49, expectedNationalNumber = 9512085011),
        PhonenumberTestData(value = "0951/2085011", expectedCountryCode = 49, expectedNationalNumber = 9512085011),
        PhonenumberTestData(value = "0951 / 2085011", expectedCountryCode = 49, expectedNationalNumber = 9512085011),
        PhonenumberTestData(value = "00499512085011", expectedCountryCode = 49, expectedNationalNumber = 9512085011),
        PhonenumberTestData(value = "+499512085011", expectedCountryCode = 49, expectedNationalNumber = 9512085011),
        PhonenumberTestData(value = "0951/20850-11", expectedCountryCode = 49, expectedNationalNumber = 9512085011),
        PhonenumberTestData(value = "+49742512345", expectedCountryCode = 49, expectedNationalNumber = 742512345),
        PhonenumberTestData(value = "0742512345", expectedCountryCode = 49, expectedNationalNumber = 742512345),
        PhonenumberTestData(value = "07425/12345", expectedCountryCode = 49, expectedNationalNumber = 742512345),
        PhonenumberTestData(value = "07425-12345", expectedCountryCode = 49, expectedNationalNumber = 742512345),

        PhonenumberTestData(
            value = "+49 (9133) 7684800",
            expectedCountryCode = 49,
            expectedNationalNumber = 91337684800
        ),
        PhonenumberTestData(value = "+49 (170) 9046050", expectedCountryCode = 49, expectedNationalNumber = 1709046050),
        PhonenumberTestData(
            value = "+49 (176) 43308420",
            expectedCountryCode = 49,
            expectedNationalNumber = 17643308420
        ),
        PhonenumberTestData(value = "+49 (961) 4707030", expectedCountryCode = 49, expectedNationalNumber = 9614707030),
        PhonenumberTestData(
            value = "+49 (176) 32777370",
            expectedCountryCode = 49,
            expectedNationalNumber = 17632777370
        ),
        PhonenumberTestData(value = "+49 (941) 7000520", expectedCountryCode = 49, expectedNationalNumber = 9417000520),
        PhonenumberTestData(
            value = "+49 (1577) 3838050",
            expectedCountryCode = 49,
            expectedNationalNumber = 15773838050
        ),
        PhonenumberTestData(
            value = "+43 (699) 19496870",
            expectedCountryCode = 43,
            expectedNationalNumber = 69919496870
        ),
        PhonenumberTestData(value = "+49 (89) 98295710", expectedCountryCode = 49, expectedNationalNumber = 8998295710),
        PhonenumberTestData(value = "+49 (172) 8591990", expectedCountryCode = 49, expectedNationalNumber = 1728591990),
        PhonenumberTestData(
            value = "+49 (851) 75681330",
            expectedCountryCode = 49,
            expectedNationalNumber = 85175681330
        ),
        PhonenumberTestData(value = "+49 (9701) 907830", expectedCountryCode = 49, expectedNationalNumber = 9701907830),
        PhonenumberTestData(value = "+49 (174) 7492500", expectedCountryCode = 49, expectedNationalNumber = 1747492500),
        PhonenumberTestData(
            value = "+49 (1525) 3012250",
            expectedCountryCode = 49,
            expectedNationalNumber = 15253012250
        ),
        PhonenumberTestData(
            value = "+49 (1516) 1116120",
            expectedCountryCode = 49,
            expectedNationalNumber = 15161116120
        ),
        PhonenumberTestData(
            value = "+49 (1573) 0093850",
            expectedCountryCode = 49,
            expectedNationalNumber = 15730093850
        ),
        PhonenumberTestData(value = "+49 (6402) 508420", expectedCountryCode = 49, expectedNationalNumber = 6402508420),
        PhonenumberTestData(
            value = "+49 (176) 55447770",
            expectedCountryCode = 49,
            expectedNationalNumber = 17655447770
        ),
        PhonenumberTestData(
            value = "+49 (176) 66836960",
            expectedCountryCode = 49,
            expectedNationalNumber = 17666836960
        ),
        PhonenumberTestData(value = "+49 (89) 99735659", expectedCountryCode = 49, expectedNationalNumber = 8999735659),
        PhonenumberTestData(
            value = "+49 (9131) 7532300",
            expectedCountryCode = 49,
            expectedNationalNumber = 91317532300
        ),
        PhonenumberTestData(
            value = "+49 (8158) 2433009",
            expectedCountryCode = 49,
            expectedNationalNumber = 81582433009
        ),
        PhonenumberTestData(value = "+49 (7525) 932730", expectedCountryCode = 49, expectedNationalNumber = 7525932730),
        PhonenumberTestData(value = "+49 (179) 2182320", expectedCountryCode = 49, expectedNationalNumber = 1792182320),
        PhonenumberTestData(value = "+49 (9197) 627260", expectedCountryCode = 49, expectedNationalNumber = 9197627260),
        PhonenumberTestData(
            value = "+49 (176) 27054530",
            expectedCountryCode = 49,
            expectedNationalNumber = 17627054530
        ),
        PhonenumberTestData(value = "+49 (911) 5984910", expectedCountryCode = 49, expectedNationalNumber = 9115984910),
        PhonenumberTestData(
            value = "+49 (176) 54212490",
            expectedCountryCode = 49,
            expectedNationalNumber = 17654212490
        ),
        PhonenumberTestData(value = "+49 (89) 55988120", expectedCountryCode = 49, expectedNationalNumber = 8955988120),
        PhonenumberTestData(value = "+49 (89) 5806910", expectedCountryCode = 49, expectedNationalNumber = 895806910),
        PhonenumberTestData(value = "+49 (55) 13965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "+49 (171) 6190520", expectedCountryCode = 49, expectedNationalNumber = 1716190520),
        PhonenumberTestData(value = "+49 (160) 3190050", expectedCountryCode = 49, expectedNationalNumber = 1603190050),
        PhonenumberTestData(
            value = "+43 (699) 13018809",
            expectedCountryCode = 43,
            expectedNationalNumber = 69913018809
        ),
        PhonenumberTestData(
            value = "+49 (176) 78159310",
            expectedCountryCode = 49,
            expectedNationalNumber = 17678159310
        ),
        PhonenumberTestData(value = "+49 (174) 8028690", expectedCountryCode = 49, expectedNationalNumber = 1748028690),
        PhonenumberTestData(value = "+49 (621) 1812100", expectedCountryCode = 49, expectedNationalNumber = 6211812100),
        PhonenumberTestData(
            value = "+49 (1520) 8679760",
            expectedCountryCode = 49,
            expectedNationalNumber = 15208679760
        ),
        PhonenumberTestData(value = "+49 (931) 4652080", expectedCountryCode = 49, expectedNationalNumber = 9314652080),
        PhonenumberTestData(
            value = "+49 (176) 99816390",
            expectedCountryCode = 49,
            expectedNationalNumber = 17699816390
        ),
        PhonenumberTestData(value = "+49 (172) 9480139", expectedCountryCode = 49, expectedNationalNumber = 1729480139),
        PhonenumberTestData(
            value = "+49 (176) 55391450",
            expectedCountryCode = 49,
            expectedNationalNumber = 17655391450
        ),
        PhonenumberTestData(value = "+49 (162) 2456460", expectedCountryCode = 49, expectedNationalNumber = 1622456460),
        PhonenumberTestData(value = "+49 (174) 3028760", expectedCountryCode = 49, expectedNationalNumber = 1743028760),
        PhonenumberTestData(value = "+49 (8131) 1060", expectedCountryCode = 49, expectedNationalNumber = 81311060),

        PhonenumberTestData(value = "+49 (55) 13965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "+495513965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "+49(55) 13965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "+49 (55)13965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "+49(55)13965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "+49-55-13965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "00495513965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551 3965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551/3965270", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551/39652-70", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "+49 0551/39652-70", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551 /39652-70", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551/ 39652-70", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551 / 39652-70", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551 / 39652 -70", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(value = "0551 / 39652 - 70", expectedCountryCode = 49, expectedNationalNumber = 5513965270),
        PhonenumberTestData(
            value = "0551 / 396 52 - 70",
            expectedCountryCode = 49,
            expectedNationalNumber = 5513965270
        ),

        // T-Mobile
        PhonenumberTestData(value = "+49 1510 3028709", expectedCountryCode = 49, expectedNationalNumber = 15103028709),
        PhonenumberTestData(value = "+49 1511 3028709", expectedCountryCode = 49, expectedNationalNumber = 15113028709),
        PhonenumberTestData(value = "+49 1512 3028709", expectedCountryCode = 49, expectedNationalNumber = 15123028709),
        PhonenumberTestData(value = "+49 1513 3028709", expectedCountryCode = 49, expectedNationalNumber = 15133028709),
        PhonenumberTestData(value = "+49 1514 3028709", expectedCountryCode = 49, expectedNationalNumber = 15143028709),
        PhonenumberTestData(value = "+49 1515 3028709", expectedCountryCode = 49, expectedNationalNumber = 15153028709),
        PhonenumberTestData(value = "+49 1516 3028709", expectedCountryCode = 49, expectedNationalNumber = 15163028709),
        PhonenumberTestData(value = "+49 1517 3028709", expectedCountryCode = 49, expectedNationalNumber = 15173028709),
        PhonenumberTestData(value = "+49 1518 3028709", expectedCountryCode = 49, expectedNationalNumber = 15183028709),
        PhonenumberTestData(value = "+49 1519 3028709", expectedCountryCode = 49, expectedNationalNumber = 15193028709),
        PhonenumberTestData(value = "+49 160 3028760", expectedCountryCode = 49, expectedNationalNumber = 1603028760),
        PhonenumberTestData(value = "+49 170 3028760", expectedCountryCode = 49, expectedNationalNumber = 1703028760),
        PhonenumberTestData(value = "+49 171 3028760", expectedCountryCode = 49, expectedNationalNumber = 1713028760),
        PhonenumberTestData(value = "+49 175 3028760", expectedCountryCode = 49, expectedNationalNumber = 1753028760),

        // Vodafone
        PhonenumberTestData(value = "+49 1520 3028760", expectedCountryCode = 49, expectedNationalNumber = 15203028760),
        PhonenumberTestData(value = "+49 1521 3028760", expectedCountryCode = 49, expectedNationalNumber = 15213028760),
        PhonenumberTestData(value = "+49 1522 3028760", expectedCountryCode = 49, expectedNationalNumber = 15223028760),
        PhonenumberTestData(value = "+49 1523 3028760", expectedCountryCode = 49, expectedNationalNumber = 15233028760),
        PhonenumberTestData(value = "+49 1524 3028760", expectedCountryCode = 49, expectedNationalNumber = 15243028760),
        PhonenumberTestData(value = "+49 1525 3028760", expectedCountryCode = 49, expectedNationalNumber = 15253028760),
        PhonenumberTestData(value = "+49 1526 3028760", expectedCountryCode = 49, expectedNationalNumber = 15263028760),
        PhonenumberTestData(value = "+49 1527 3028760", expectedCountryCode = 49, expectedNationalNumber = 15273028760),
        PhonenumberTestData(value = "+49 1528 3028760", expectedCountryCode = 49, expectedNationalNumber = 15283028760),
        PhonenumberTestData(value = "+49 1529 3028760", expectedCountryCode = 49, expectedNationalNumber = 15293028760),

        // E-Plus
        PhonenumberTestData(value = "+49 1570 3028760", expectedCountryCode = 49, expectedNationalNumber = 15703028760),
        PhonenumberTestData(value = "+49 1571 3028760", expectedCountryCode = 49, expectedNationalNumber = 15713028760),
        PhonenumberTestData(value = "+49 1572 3028760", expectedCountryCode = 49, expectedNationalNumber = 15723028760),
        PhonenumberTestData(value = "+49 1573 3028760", expectedCountryCode = 49, expectedNationalNumber = 15733028760),
        PhonenumberTestData(value = "+49 1574 3028760", expectedCountryCode = 49, expectedNationalNumber = 15743028760),
        PhonenumberTestData(value = "+49 1575 3028760", expectedCountryCode = 49, expectedNationalNumber = 15753028760),
        PhonenumberTestData(value = "+49 1576 3028760", expectedCountryCode = 49, expectedNationalNumber = 15763028760),
        PhonenumberTestData(value = "+49 1577 3028760", expectedCountryCode = 49, expectedNationalNumber = 15773028760),
        PhonenumberTestData(value = "+49 1578 3028760", expectedCountryCode = 49, expectedNationalNumber = 15783028760),
        PhonenumberTestData(value = "+49 1579 3028760", expectedCountryCode = 49, expectedNationalNumber = 15793028760),
        PhonenumberTestData(value = "+49 163 3028760", expectedCountryCode = 49, expectedNationalNumber = 1633028760),
        PhonenumberTestData(value = "+49 177 3028760", expectedCountryCode = 49, expectedNationalNumber = 1773028760),
        PhonenumberTestData(value = "+49 178 3028760", expectedCountryCode = 49, expectedNationalNumber = 1783028760),

        // O2
        PhonenumberTestData(value = "+49 1590 3028760", expectedCountryCode = 49, expectedNationalNumber = 15903028760),
        PhonenumberTestData(value = "+49 176 3028760", expectedCountryCode = 49, expectedNationalNumber = 1763028760),
        PhonenumberTestData(value = "+49 179 3028760", expectedCountryCode = 49, expectedNationalNumber = 1793028760),

        // produces more groups than german numbers
        PhonenumberTestData(value = "+41 44 668 18 00", expectedCountryCode = 41, expectedNationalNumber = 446681800),
        PhonenumberTestData(value = "+41 446681800", expectedCountryCode = 41, expectedNationalNumber = 446681800)
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
        val expectedCountryCode: Int? = null,
        val expectedNationalNumber: Long? = null
    )
}