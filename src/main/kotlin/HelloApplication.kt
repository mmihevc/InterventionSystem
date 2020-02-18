/**
 *
 *
 *
 * @author Albert Lionelle <br>
 *         lionelle@colostate.edu <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 1.0
 */
package edu.colostate.csedu

import edu.colostate.csedu.controller.ClickThroughController
import edu.colostate.csedu.controller.InterventionController
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.*
import kotlinx.html.*

// Entry Point of the application as defined in resources/application.conf.
// @see https://ktor.io/servers/configuration.html#hocon-file
fun Application.main() {
    // This adds Date and Server headers to each response, and allows custom additional headers
    install(DefaultHeaders)
    // This uses use the logger to log every call (request/response)
   // install(CallLogging)



    // Registers routes
    routing {
        // Here we use a DSL for building HTML on the route "/"
        // @see https://github.com/Kotlin/kotlinx.html
        get("/") {
            call.respondHtml {
                head {
                    title { +"You should not be here" }
                }
                body {
                    p {
                        +"You should not be here"
                    }
                }
            }
        }

        get("/{cid}/client/{id}/resource/{rid}") {
            val client = call.parameters["id"] ?: ""
            val resource = call.parameters["rid"] ?: ""
            val courseId = call.parameters["cid"] ?: ""
            val redirectUrl = ClickThroughController.redirectRoute(courseId, client, resource)
            call.respondRedirect(redirectUrl, permanent = false)
        }

        //http://localhost:8080/cs150Fall19/test-unit/email/unit1EmailBody
        get("/{cid}/{assessmentId}/email/{tid}") {
            val assessmentId = call.parameters["assessmentId"] ?: ""
            val courseId = call.parameters["cid"] ?: ""
            val templateId = call.parameters["tid"] ?: ""
            val response = if (assessmentId.isEmpty() || courseId.isEmpty() || templateId.isEmpty()) {
                "Invalid Info"
            } else {
       //         InterventionController.massEmail(courseId, assessmentId, templateId)
                "hello"
            }
            call.respondText(response, contentType = ContentType.Application.Json)
        }


    }
}