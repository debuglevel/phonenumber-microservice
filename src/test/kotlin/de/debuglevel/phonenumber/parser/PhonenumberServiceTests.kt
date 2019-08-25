package de.debuglevel.phonenumber.parser


import de.debuglevel.phonenumber.InvalidPhonenumberException
import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import javax.inject.Inject

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PhonenumberServiceTests {

    @Inject
    lateinit var phonenumberService: PhonenumberService

    fun validPhonenumberProvider() = TestDataProvider.validPhonenumberProvider()
    fun invalidPhonenumberProvider() = TestDataProvider.invalidPhonenumberProvider()

    @ParameterizedTest
    @MethodSource("validPhonenumberProvider")
    fun `format valid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange

        // Act
        val phonenumber = phonenumberService.parseAndValidate(testData.value)

        // Assert
        assertThat(phonenumber.countryCode).isEqualTo(testData.expectedCountryCode)
        assertThat(phonenumber.nationalNumber).isEqualTo(testData.expectedNationalNumber)
    }

    @ParameterizedTest
    @MethodSource("invalidPhonenumberProvider")
    fun `format invalid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange

        // Act

        // Assert
        assertThatExceptionOfType(InvalidPhonenumberException::class.java).isThrownBy {
            phonenumberService.parseAndValidate(testData.value)
        }
    }
}