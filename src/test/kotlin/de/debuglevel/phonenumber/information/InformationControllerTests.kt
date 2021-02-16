package de.debuglevel.phonenumber.information

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.uri.UriBuilder
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import javax.inject.Inject

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InformationControllerTests {
    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    @field:Client("/information")
    lateinit var httpClient: HttpClient

    fun validPhonenumberProvider() = TestDataProvider.validPhonenumberProvider()
    fun invalidPhonenumberProvider() = TestDataProvider.invalidPhonenumberProvider()

    @ParameterizedTest
    @MethodSource("validPhonenumberProvider")
    fun `get information for valid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange
        val informationRequest = InformationRequest(testData.value)

        // Act
        val uri = UriBuilder.of("/").build()
        val informationResponse = httpClient.toBlocking()
            .retrieve(HttpRequest.POST(uri, informationRequest), InformationResponse::class.java)

        // Assert
        Assertions.assertThat(informationResponse.location).isEqualTo(testData.expectedLocation)
        Assertions.assertThat(informationResponse.regionCode).isEqualTo(testData.expectedRegionCode)
        Assertions.assertThat(informationResponse.formattedPhonenumber).isEqualTo(testData.expectedFormat)
        Assertions.assertThat(informationResponse.type).isEqualTo(testData.expectedType)
    }

    @ParameterizedTest
    @MethodSource("invalidPhonenumberProvider")
    fun `get information for invalid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange
        val informationRequest = InformationRequest(testData.value)

        // Act
        val uri = UriBuilder.of("/").build()
        val thrown = catchThrowable {
            httpClient.toBlocking()
                .retrieve(HttpRequest.POST(uri, informationRequest), InformationResponse::class.java)
        }

        // Assert
        Assertions.assertThat(thrown)
            .isInstanceOf(HttpClientResponseException::class.java)
            .hasMessageContaining("Bad Request")
    }
}