package de.debuglevel.phonenumber.geocode

import de.debuglevel.phonenumber.InvalidPhonenumberException
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import mu.KotlinLogging

@Controller("/geocode")
class GeocodeController(private val geocodeService: GeocodeService) {
    private val logger = KotlinLogging.logger {}

    /**
     * Geocode a phone number
     * @param geocodeRequest original phone number
     * @return Geocode
     */
    @Post("/")
    fun postOne(geocodeRequest: GeocodeRequest): HttpResponse<GeocodeResponse> {
        logger.debug("Called postOne($geocodeRequest)")

        val geocode = try {
            geocodeService.geocode(geocodeRequest.phonenumber)
        } catch (e: InvalidPhonenumberException) {
            val errorResponse = GeocodeResponse(
                geocodeRequest.phonenumber,
                error = "the phone number is invalid"
            )
            return HttpResponse.badRequest(errorResponse)
        }

        val formatResponse = GeocodeResponse(
            geocodeRequest.phonenumber,
            geocode.location,
            geocode.regionCode,
        )

        return HttpResponse.ok(formatResponse)
    }
}