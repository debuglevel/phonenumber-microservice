package de.debuglevel.phonenumber.format


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
class FormatServiceTests {

    @Inject
    lateinit var formatService: FormatService

    fun validPhonenumberProvider() = TestDataProvider.validPhonenumberProvider()
    fun invalidPhonenumberProvider() = TestDataProvider.invalidPhonenumberProvider()

    @ParameterizedTest
    @MethodSource("validPhonenumberProvider")
    fun `format valid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange

        // Act
        val formattedPhonenumber = formatService.format(testData.value)

        // Assert
        assertThat(formattedPhonenumber.formattedPhonenumber).isEqualTo(testData.expected)
    }

    @ParameterizedTest
    @MethodSource("invalidPhonenumberProvider")
    fun `format invalid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange

        // Act

        // Assert
        assertThatExceptionOfType(InvalidPhonenumberException::class.java).isThrownBy {
            formatService.format(testData.value)
        }
    }
}