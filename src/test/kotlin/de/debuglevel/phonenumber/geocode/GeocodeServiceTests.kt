package de.debuglevel.phonenumber.geocode


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
class GeocodeServiceTests {

    @Inject
    lateinit var geocodeService: GeocodeService

    fun validPhonenumberProvider() = TestDataProvider.validPhonenumberProvider()
    fun invalidPhonenumberProvider() = TestDataProvider.invalidPhonenumberProvider()

    @ParameterizedTest
    @MethodSource("validPhonenumberProvider")
    fun `geocode valid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange

        // Act
        val geocode = geocodeService.geocode(testData.value)

        // Assert
        assertThat(geocode.location).isEqualTo(testData.expectedLocation)
        assertThat(geocode.regionCode).isEqualTo(testData.expectedRegionCode)
        assertThat(geocode.type.name).isEqualTo(testData.expectedType)
    }

    @ParameterizedTest
    @MethodSource("invalidPhonenumberProvider")
    fun `format invalid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange

        // Act

        // Assert
        assertThatExceptionOfType(InvalidPhonenumberException::class.java).isThrownBy {
            geocodeService.geocode(testData.value)
        }
    }
}