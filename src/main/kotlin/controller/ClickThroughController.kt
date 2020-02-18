package edu.colostate.csedu.controller

import edu.colostate.csedu.DB
import org.slf4j.LoggerFactory


private val logger = LoggerFactory.getLogger(ClickThroughController.javaClass)


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
object ClickThroughController {

    fun redirectRoute(courseId : String, clientId : String, resourceId : String) : String {
//Test line: http://localhost:8080/cs150Fall19/client/1/resource/geeks-for-geeks-variables-lv1
/*
        val resource = DB.getResource(resourceId)

        val student = DB.getStudent(courseId, clientId)

        student.addClick(resource)

        return resource.url
*/
        return ""
    }


}