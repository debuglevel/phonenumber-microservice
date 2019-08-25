package de.debuglevel.phonenumber.format

import java.util.stream.Stream

object TestDataProvider {
    fun validPhonenumberProvider() = Stream.of(
        PhonenumberTestData(value = "(09 51) 2 08 50-11", expected = "+49 (951) 2085011"),
        PhonenumberTestData(value = "0951 2085011", expected = "+49 (951) 2085011"),
        PhonenumberTestData(value = "0951/2085011", expected = "+49 (951) 2085011"),
        PhonenumberTestData(value = "0951 / 2085011", expected = "+49 (951) 2085011"),
        PhonenumberTestData(value = "00499512085011", expected = "+49 (951) 2085011"),
        PhonenumberTestData(value = "+499512085011", expected = "+49 (951) 2085011"),
        PhonenumberTestData(value = "0951/20850-11", expected = "+49 (951) 2085011"),
        PhonenumberTestData(value = "+49742512345", expected = "+49 (7425) 12345"),
        PhonenumberTestData(value = "0742512345", expected = "+49 (7425) 12345"),
        PhonenumberTestData(value = "07425/12345", expected = "+49 (7425) 12345"),
        PhonenumberTestData(value = "07425-12345", expected = "+49 (7425) 12345"),

        PhonenumberTestData(value = "+49 (9133) 7684800", expected = "+49 (9133) 7684800"),
        PhonenumberTestData(value = "+49 (170) 9046050", expected = "+49 (170) 9046050"),
        PhonenumberTestData(value = "+49 (176) 43308420", expected = "+49 (176) 43308420"),
        PhonenumberTestData(value = "+49 (961) 4707030", expected = "+49 (961) 4707030"),
        PhonenumberTestData(value = "+49 (176) 32777370", expected = "+49 (176) 32777370"),
        PhonenumberTestData(value = "+49 (941) 7000520", expected = "+49 (941) 7000520"),
        PhonenumberTestData(value = "+49 (1577) 3838050", expected = "+49 (1577) 3838050"),
        PhonenumberTestData(value = "+43 (699) 19496870", expected = "+43 (699) 19496870"),
        PhonenumberTestData(value = "+49 (89) 98295710", expected = "+49 (89) 98295710"),
        PhonenumberTestData(value = "+49 (172) 8591990", expected = "+49 (172) 8591990"),
        PhonenumberTestData(value = "+49 (851) 75681330", expected = "+49 (851) 75681330"),
        PhonenumberTestData(value = "+49 (9701) 907830", expected = "+49 (9701) 907830"),
        PhonenumberTestData(value = "+49 (174) 7492500", expected = "+49 (174) 7492500"),
        PhonenumberTestData(value = "+49 (1525) 3012250", expected = "+49 (1525) 3012250"),
        PhonenumberTestData(value = "+49 (1516) 1116120", expected = "+49 (1516) 1116120"),
        PhonenumberTestData(value = "+49 (1573) 0093850", expected = "+49 (1573) 0093850"),
        PhonenumberTestData(value = "+49 (6402) 508420", expected = "+49 (6402) 508420"),
        PhonenumberTestData(value = "+49 (176) 55447770", expected = "+49 (176) 55447770"),
        PhonenumberTestData(value = "+49 (176) 66836960", expected = "+49 (176) 66836960"),
        PhonenumberTestData(value = "+49 (89) 99735659", expected = "+49 (89) 99735659"),
        PhonenumberTestData(value = "+49 (9131) 7532300", expected = "+49 (9131) 7532300"),
        PhonenumberTestData(value = "+49 (8158) 2433009", expected = "+49 (8158) 2433009"),
        PhonenumberTestData(value = "+49 (7525) 932730", expected = "+49 (7525) 932730"),
        PhonenumberTestData(value = "+49 (179) 2182320", expected = "+49 (179) 2182320"),
        PhonenumberTestData(value = "+49 (9197) 627260", expected = "+49 (9197) 627260"),
        PhonenumberTestData(value = "+49 (176) 27054530", expected = "+49 (176) 27054530"),
        PhonenumberTestData(value = "+49 (911) 5984910", expected = "+49 (911) 5984910"),
        PhonenumberTestData(value = "+49 (176) 54212490", expected = "+49 (176) 54212490"),
        PhonenumberTestData(value = "+49 (89) 55988120", expected = "+49 (89) 55988120"),
        PhonenumberTestData(value = "+49 (89) 5806910", expected = "+49 (89) 5806910"),
        PhonenumberTestData(value = "+49 (55) 13965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "+49 (171) 6190520", expected = "+49 (171) 6190520"),
        PhonenumberTestData(value = "+49 (160) 3190050", expected = "+49 (160) 3190050"),
        PhonenumberTestData(value = "+43 (699) 13018809", expected = "+43 (699) 13018809"),
        PhonenumberTestData(value = "+49 (176) 78159310", expected = "+49 (176) 78159310"),
        PhonenumberTestData(value = "+49 (174) 8028690", expected = "+49 (174) 8028690"),
        PhonenumberTestData(value = "+49 (621) 1812100", expected = "+49 (621) 1812100"),
        PhonenumberTestData(value = "+49 (1520) 8679760", expected = "+49 (1520) 8679760"),
        PhonenumberTestData(value = "+49 (931) 4652080", expected = "+49 (931) 4652080"),
        PhonenumberTestData(value = "+49 (176) 99816390", expected = "+49 (176) 99816390"),
        PhonenumberTestData(value = "+49 (172) 9480139", expected = "+49 (172) 9480139"),
        PhonenumberTestData(value = "+49 (176) 55391450", expected = "+49 (176) 55391450"),
        PhonenumberTestData(value = "+49 (162) 2456460", expected = "+49 (162) 2456460"),
        PhonenumberTestData(value = "+49 (174) 3028760", expected = "+49 (174) 3028760"),
        PhonenumberTestData(value = "+49 (8131) 1060", expected = "+49 (8131) 1060"),

        PhonenumberTestData(value = "+49 (55) 13965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "+495513965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "+49(55) 13965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "+49 (55)13965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "+49(55)13965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "+49-55-13965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "00495513965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551 3965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551/3965270", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551/39652-70", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "+49 0551/39652-70", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551 /39652-70", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551/ 39652-70", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551 / 39652-70", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551 / 39652 -70", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551 / 39652 - 70", expected = "+49 (551) 3965270"),
        PhonenumberTestData(value = "0551 / 396 52 - 70", expected = "+49 (551) 3965270"),

        // T-Mobile
        PhonenumberTestData(value = "+49 1510 3028709", expected = "+49 (1510) 3028709"),
        PhonenumberTestData(value = "+49 1511 3028709", expected = "+49 (1511) 3028709"),
        PhonenumberTestData(value = "+49 1512 3028709", expected = "+49 (1512) 3028709"),
        PhonenumberTestData(value = "+49 1513 3028709", expected = "+49 (1513) 3028709"),
        PhonenumberTestData(value = "+49 1514 3028709", expected = "+49 (1514) 3028709"),
        PhonenumberTestData(value = "+49 1515 3028709", expected = "+49 (1515) 3028709"),
        PhonenumberTestData(value = "+49 1516 3028709", expected = "+49 (1516) 3028709"),
        PhonenumberTestData(value = "+49 1517 3028709", expected = "+49 (1517) 3028709"),
        PhonenumberTestData(value = "+49 1518 3028709", expected = "+49 (1518) 3028709"),
        PhonenumberTestData(value = "+49 1519 3028709", expected = "+49 (1519) 3028709"),
        PhonenumberTestData(value = "+49 160 3028760", expected = "+49 (160) 3028760"),
        PhonenumberTestData(value = "+49 170 3028760", expected = "+49 (170) 3028760"),
        PhonenumberTestData(value = "+49 171 3028760", expected = "+49 (171) 3028760"),
        PhonenumberTestData(value = "+49 175 3028760", expected = "+49 (175) 3028760"),

        // Vodafone
        PhonenumberTestData(value = "+49 1520 3028760", expected = "+49 (1520) 3028760"),
        PhonenumberTestData(value = "+49 1521 3028760", expected = "+49 (1521) 3028760"),
        PhonenumberTestData(value = "+49 1522 3028760", expected = "+49 (1522) 3028760"),
        PhonenumberTestData(value = "+49 1523 3028760", expected = "+49 (1523) 3028760"),
        PhonenumberTestData(value = "+49 1524 3028760", expected = "+49 (1524) 3028760"),
        PhonenumberTestData(value = "+49 1525 3028760", expected = "+49 (1525) 3028760"),
        PhonenumberTestData(value = "+49 1526 3028760", expected = "+49 (1526) 3028760"),
        PhonenumberTestData(value = "+49 1527 3028760", expected = "+49 (1527) 3028760"),
        PhonenumberTestData(value = "+49 1528 3028760", expected = "+49 (1528) 3028760"),
        PhonenumberTestData(value = "+49 1529 3028760", expected = "+49 (1529) 3028760"),

        // E-Plus
        PhonenumberTestData(value = "+49 1570 3028760", expected = "+49 (1570) 3028760"),
        PhonenumberTestData(value = "+49 1571 3028760", expected = "+49 (1571) 3028760"),
        PhonenumberTestData(value = "+49 1572 3028760", expected = "+49 (1572) 3028760"),
        PhonenumberTestData(value = "+49 1573 3028760", expected = "+49 (1573) 3028760"),
        PhonenumberTestData(value = "+49 1574 3028760", expected = "+49 (1574) 3028760"),
        PhonenumberTestData(value = "+49 1575 3028760", expected = "+49 (1575) 3028760"),
        PhonenumberTestData(value = "+49 1576 3028760", expected = "+49 (1576) 3028760"),
        PhonenumberTestData(value = "+49 1577 3028760", expected = "+49 (1577) 3028760"),
        PhonenumberTestData(value = "+49 1578 3028760", expected = "+49 (1578) 3028760"),
        PhonenumberTestData(value = "+49 1579 3028760", expected = "+49 (1579) 3028760"),
        PhonenumberTestData(value = "+49 163 3028760", expected = "+49 (163) 3028760"),
        PhonenumberTestData(value = "+49 177 3028760", expected = "+49 (177) 3028760"),
        PhonenumberTestData(value = "+49 178 3028760", expected = "+49 (178) 3028760"),

        // O2
        PhonenumberTestData(value = "+49 1590 3028760", expected = "+49 (1590) 3028760"),
        PhonenumberTestData(value = "+49 176 3028760", expected = "+49 (176) 3028760"),
        PhonenumberTestData(value = "+49 179 3028760", expected = "+49 (179) 3028760"),

        // produces more groups than german numbers
        PhonenumberTestData(value = "+41 44 668 18 00", expected = "+41 (44) 668 18 00"),
        PhonenumberTestData(value = "+41 446681800", expected = "+41 (44) 668 18 00")
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