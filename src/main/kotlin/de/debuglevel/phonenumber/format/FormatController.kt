package de.debuglevel.phonenumber.format

import de.debuglevel.phonenumber.InvalidPhonenumberException
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import mu.KotlinLogging

@Controller("/format")
class FormatController(private val formatService: FormatService) {
    private val logger = KotlinLogging.logger {}

    /**
     * Format a phone number
     * @param formatRequest original phone number
     * @return phone number
     */
    @Post("/")
    fun postOne(formatRequest: FormatRequest): HttpResponse<FormatResponse> {
        logger.debug("Called postOne($formatRequest)")

        val formattedPhonenumber = try {
            formatService.format(formatRequest.phonenumber)
        } catch (e: InvalidPhonenumberException) {
            val errorResponse = FormatResponse(
                formatRequest.phonenumber,
                error = "the phone number is invalid"
            )
            return HttpResponse.badRequest(errorResponse)
        }

        val formatResponse = FormatResponse(
            formatRequest.phonenumber,
            formattedPhonenumber.formattedPhonenumber
        )

        return HttpResponse.ok(formatResponse)
    }
}