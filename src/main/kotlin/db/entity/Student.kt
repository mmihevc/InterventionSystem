package edu.colostate.csedu.db.entity

import edu.colostate.csedu.DB
import kotlinx.serialization.Serializable



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
@Serializable
data class Student(var id: String ="", var canvasId:String = "", var csuid:String = "",
                   var email:String="", var fname: String="", var lname:String="") {

    @Transient
    var courseId : String = ""

    private val clicks = mutableListOf<Click>()

    val assessments: MutableList<Assessment> = mutableListOf()

    /**
     * Adds a clickThrough counter to the student in the database. Automatically saves
     */
    fun addClick(resource: Resource) {
        val click = Click(resource)
        DB.addClickToStudent(this, click)
        clicks += click
    }

    /**
     * Doing tomap as I couldn't get the json stringify working with assessments
     */
    fun toMap(includeAssessment : Boolean = false): Map<String, Any> {
        val map = mutableMapOf<String, Any>(
                "fname" to fname,
                "lname" to lname,
                "canvasId" to canvasId,
                "id" to id,
                "email" to email,
                "csuid" to csuid)
        if(courseId.isNotEmpty()) { map["courseId"] = courseId }
        if(includeAssessment) {
            val asMap = mutableListOf<Map<String, Any>>()
            for (assessment in assessments) {
                asMap += assessment.toMap()
            }
            map["assessments"] = asMap
        }
        return map

    }
}

@Serializable
data class Click(var resource: Resource) {
    fun toMap() : Map<String, Any> {
        return resource.toMap()
    }

}