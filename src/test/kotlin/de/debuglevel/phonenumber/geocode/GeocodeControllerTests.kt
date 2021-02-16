package de.debuglevel.phonenumber.geocode

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
class GeocodeControllerTests {
    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    @field:Client("/geocode")
    lateinit var httpClient: HttpClient

    fun validPhonenumberProvider() = TestDataProvider.validPhonenumberProvider()
    fun invalidPhonenumberProvider() = TestDataProvider.invalidPhonenumberProvider()

    @ParameterizedTest
    @MethodSource("validPhonenumberProvider")
    fun `geocode valid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange
        val geocodeRequest = GeocodeRequest(testData.value)

        // Act
        val uri = UriBuilder.of("/").build()
        val geocodeResponse = httpClient.toBlocking()
            .retrieve(HttpRequest.POST(uri, geocodeRequest), GeocodeResponse::class.java)

        // Assert
        Assertions.assertThat(geocodeResponse.location).isEqualTo(testData.expectedLocation)
        Assertions.assertThat(geocodeResponse.regionCode).isEqualTo(testData.expectedRegionCode)
        Assertions.assertThat(geocodeResponse.type).isEqualTo(testData.expectedType)
    }

    @ParameterizedTest
    @MethodSource("invalidPhonenumberProvider")
    fun `geocode invalid phone numbers`(testData: TestDataProvider.PhonenumberTestData) {
        // Arrange
        val formatRequest = GeocodeRequest(testData.value)

        // Act
        val uri = UriBuilder.of("/").build()
        val thrown = catchThrowable {
            httpClient.toBlocking()
                .retrieve(HttpRequest.POST(uri, formatRequest), GeocodeResponse::class.java)
        }

        // Assert
        Assertions.assertThat(thrown)
            .isInstanceOf(HttpClientResponseException::class.java)
            .hasMessageContaining("Bad Request")
    }
}