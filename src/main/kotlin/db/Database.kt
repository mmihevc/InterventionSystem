package edu.colostate.csedu.db

import edu.colostate.csedu.db.entity.Assessment
import edu.colostate.csedu.db.entity.Click
import edu.colostate.csedu.db.entity.Resource
import edu.colostate.csedu.db.entity.Student


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
interface Database {

    fun getResource(id:String) : Resource
    fun getAllResources() : List<Resource>

    fun getStudent(courseId:String, studentId:String) : Student
    fun getAllStudents(courseId: String) : List<Student>
    fun addClickToStudent(student: Student, click: Click) : String
    fun addStudent(courseId: String, student: Student)


    fun getAssessment(student: Student, assessmentId: String) : Assessment
    fun addAssessment(student: Student, assessment: Assessment)

}