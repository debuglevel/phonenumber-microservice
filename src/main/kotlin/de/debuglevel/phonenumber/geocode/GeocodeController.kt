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
     * @param geocodeRequestDTO original phone number
     * @return Geocode
     */
    @Post("/")
    fun postOne(geocodeRequestDTO: GeocodeRequestDTO): HttpResponse<GeocodeResponseDTO> {
        logger.debug("Called postOne($geocodeRequestDTO)")

        val geocode = try {
            geocodeService.geocode(geocodeRequestDTO.phonenumber)
        } catch (e: InvalidPhonenumberException) {
            val errorResponse = GeocodeResponseDTO(
                geocodeRequestDTO.phonenumber,
                error = "the phone number is invalid"
            )
            return HttpResponse.badRequest(errorResponse)
        }

        val formatResponse = GeocodeResponseDTO(
            geocodeRequestDTO.phonenumber,
            geocode.location
        )

        return HttpResponse.ok(formatResponse)
    }
}