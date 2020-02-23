package edu.colostate.csedu.db.firestore

import edu.colostate.csedu.db.Students
import edu.colostate.csedu.db.entity.Course
import edu.colostate.csedu.db.entity.Student

class StudentsFb(var db: Firebase) : Students {
    override fun get(studentId: String): Student? {
        val document = db.getDocument(STUDENTS_TABLE_NAME, studentId)
        document?.let {
            val student = document.toObject(Student::class.java)
            student?.id = document.id
            return student
        }
        return null
    }


    override fun getAll(): List<Student> {
        val collection = db.getCollection(STUDENTS_TABLE_NAME)
        val list = mutableListOf<Student>()
        for (document in collection ) {
            list += document.toObject(Student::class.java)
            list.last().id = document.id // actually matches canvasId, but just in case it doesn't
        }
        return list
    }

    override fun set(id: String, student: Student) {
        db.setDocument(STUDENTS_TABLE_NAME, id, student.toMap())
    }


    companion object {
        private const val STUDENTS_TABLE_NAME = "students"

    }
}