package de.debuglevel.phonenumber.format

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
    fun postOne(formatRequestDTO: FormatRequestDTO): FormatResponseDTO {
        logger.debug("Called postOne($formatRequestDTO)")
        val formattedPhonenumber = formatService.format(formatRequestDTO.phonenumber)

        return FormatResponseDTO(
            formatRequestDTO.phonenumber,
            formattedPhonenumber.formattedPhonenumber
        )
    }
}