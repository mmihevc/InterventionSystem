package edu.colostate.csedu.db.entity

import edu.colostate.csedu.db.Mapable
import kotlinx.serialization.Serializable

/**
 * Basic course object in the database
 * Mainly links to other data, but keeps tracks of campaigns (interventions to students based on course push)
 * Which student is in the course, and their status (active or not), outcomes assigned to the course
 * (eventually) and assessments.
 */
@Serializable
data class Course(val name:String = "", val term:String = "") {

    // keeps track of students taking the course, and allows for changing the status of the student

    private val studentsInCourse = mutableMapOf<String, StudentInCourse>()
    val campaigns = mutableSetOf<Campaign>()

    fun addStudent(studentId:String) {
        studentsInCourse[studentId] = StudentInCourse(studentId=studentId) // default to active
    }

    fun setStudentInactive(studentId: String) {
        studentsInCourse[studentId]?.status = StudentStates.INACTIVE
    }

    // things to add
    // letters / communication templates
    // resources for the course (so the resource list can grow, and courses can use a selected subset)
    // outcomes for the course (for tracking / data visualization purposes)
}

@Serializable
data class Campaign(val name:String = "", val date:String = "") {
    val  links = mutableListOf<String>() // matches the clickId, to query the database with

    // add templates used
    // add assessment used

}

@Serializable
enum class StudentStates {
    ACTIVE, INACTIVE
}

@Serializable
data class StudentInCourse(val studentId:String ="",
                           var status:StudentStates = StudentStates.ACTIVE) // not much for now, but room for later


/**
 * Basic click tracker
 *
 * campaignRef - path to campaign, example courses/Fall19/campaigns/OutcomesAtFourWeeks
 */
@Serializable
data class Click(val id:String = "", val resourceId:String ="", val studentId:String = "",
                 val campaignRef : String = "") : Mapable{
    private  val accessed = mutableListOf<String>()  //every time a click happens, we record the timestamp, counting time stamps count clicks

    fun addClick() {
        TODO("Not yet implemented")
    }

    override fun toMap(): Map<String, Any> = mapOf(
            "resourceId" to resourceId,
            "studenId" to studentId,
            "accessed" to accessed
            )
}