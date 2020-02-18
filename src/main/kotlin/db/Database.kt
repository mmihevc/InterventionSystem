package edu.colostate.csedu.db

import edu.colostate.csedu.db.entity.Outcome
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
    var students  : Students
    var resources : Resources
    var outcomes  : Outcomes
    var courses : Courses


}

interface Mapable {
    fun toMap(): Map<String, Any>
}

interface Courses {
    fun getStudents(courseId:String) : List<Student>
    fun addStudents(ids:List<String>)

    //fun getResources(courseId:String) : List<Resource>
    fun addResources(ids:List<String>)

}

interface Students {
    fun get(studentId:String) : Student
    fun add()
    fun getAll() : List<Student>
    fun set(id:String, student:Student)

}



interface Resources {
   // fun getResource(id:String) : Resource
 //   fun getAllResources() : List<Resource>
}

interface Outcomes {
    fun getAll() : List<Outcome>

}