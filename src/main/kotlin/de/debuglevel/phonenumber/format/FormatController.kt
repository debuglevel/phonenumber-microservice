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
     * @param formatRequestDTO original phone number
     * @return phone number
     */
    @Post("/")
    fun postOne(formatRequestDTO: FormatRequestDTO): HttpResponse<FormatResponseDTO> {
        logger.debug("Called postOne($formatRequestDTO)")

        val formattedPhonenumber = try {
            formatService.format(formatRequestDTO.phonenumber)
        } catch (e: InvalidPhonenumberException) {
            val errorResponse = FormatResponseDTO(
                formatRequestDTO.phonenumber,
                error = "the phone number is invalid"
            )
            return HttpResponse.badRequest(errorResponse)
        }

        val formatResponse = FormatResponseDTO(
            formatRequestDTO.phonenumber,
            formattedPhonenumber.formattedPhonenumber
        )

        return HttpResponse.ok(formatResponse)
    }
}