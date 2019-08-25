package de.debuglevel.phonenumber

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import mu.KotlinLogging

/**
 * Application entry point, which starts the Micronaut server.
 *
 * @param args parameters from the command line call
 */
@OpenAPIDefinition(
    info = Info(
        title = "Phonenumber Microservice",
        version = "0.0.1",
        description = "Microservice for formatting phone numbers",
        //license = License(name = "The Unlicense", url = ""),
        contact = Contact(url = "http://debuglevel.de", name = "Marc Kohaupt", email = "debuglevel at gmail.com")
    )
)
object Application {
    private val logger = KotlinLogging.logger {}

    lateinit var applicationContext: ApplicationContext

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info { "Starting up..." }
        applicationContext = Micronaut.run(Application.javaClass)

        // TODO: how to do API versioning? (or do it at all?)
    }
}


