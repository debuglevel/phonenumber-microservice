package de.debuglevel.phonenumber.information

import de.debuglevel.phonenumber.InvalidPhonenumberException
import de.debuglevel.phonenumber.format.FormatService
import de.debuglevel.phonenumber.geocode.GeocodeService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import mu.KotlinLogging

@Controller("/information")
class InformationController(
    private val geocodeService: GeocodeService,
    private val formatService: FormatService,
) {
    private val logger = KotlinLogging.logger {}

    @Post("/")
    fun postOne(informationRequest: InformationRequest): HttpResponse<InformationResponse> {
        logger.debug("Called postOne($informationRequest)")

        val geocode = try {
            geocodeService.geocode(informationRequest.phonenumber)
        } catch (e: InvalidPhonenumberException) {
            val errorResponse = InformationResponse(
                informationRequest.phonenumber,
                error = "the phone number is invalid"
            )
            return HttpResponse.badRequest(errorResponse)
        }

        val formattedPhonenumber = try {
            formatService.format(informationRequest.phonenumber)
        } catch (e: InvalidPhonenumberException) {
            val errorResponse = InformationResponse(
                informationRequest.phonenumber,
                error = "the phone number is invalid"
            )
            return HttpResponse.badRequest(errorResponse)
        }

        val formatResponse = InformationResponse(
            phonenumber = informationRequest.phonenumber,
            formattedPhonenumber = formattedPhonenumber.formattedPhonenumber,
            location = geocode.location
        )

        return HttpResponse.ok(formatResponse)
    }
}