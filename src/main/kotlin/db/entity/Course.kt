package edu.colostate.csedu.db.entity

import kotlinx.serialization.*

/**
 * Basic course object in the database
 * Mainly links to other data, but keeps tracks of campaigns (interventions to students based on course push)
 * Which student is in the course, and their status (active or not), outcomes assigned to the course
 * (eventually) and grades.
 */
@Serializable
data class Course(val name:String = "", val term:String = "",
                  val studentsInCourse:MutableMap<String, StudentInCourse> = mutableMapOf(),
                  val campaigns: MutableSet<Campaign> = mutableSetOf()) {


    fun addStudent(studentId:String) {
        studentsInCourse[studentId] = StudentInCourse(studentId=studentId) // default to active
    }

    fun setStudentInactive(studentId: String) {
        studentsInCourse[studentId]?.status = StudentStates.INACTIVE
    }

    // grade profiles/gradebooko (for comparing students across courses)
    // no need to track assessments - this isn't canvas

    // things to add
    // letters / communication templates
    // outcomes for the course (for tracking / data visualization purposes)
}

@Serializable
data class Campaign(val name:String = "", val date:String = "")

    //val  links = mutableListOf<String>() // matches the clickId, to query the database with

    // add templates used
    // add resources used?



object StudentStates {
    const val ACTIVE = "ACTIVE"
    const val INACTIVE = "INACTIVE"
}



@Serializable
data class StudentInCourse(val studentId:String ="", var status:String = StudentStates.ACTIVE) // not much for now, but room for later


/**
 * Basic click tracker
 *
 * campaignRef - path to campaign, example courses/Fall19/campaigns/OutcomesAtFourWeeks
 */
@Serializable
data class Click(val id:String = "", val resourceId:String ="", val studentId:String = "",
                 val campaignRef : String = "", val accessed:MutableList<String> = mutableListOf()) : Mappable() {

    fun addClick() {
        TODO("Not yet implemented")
    }
}