package edu.colostate.csedu.cmdUtilities

import edu.colostate.csedu.DB
import edu.colostate.csedu.db.entity.StudentOutcome

/**
 * Simple test method as I rework the student tables
 */
fun main(args: Array<String>) {
    val list = DB.students.getAll()
    println(list)

    val outcomes = DB.outcomes.getAll()
    println(outcomes)




    for(student in list) {
        for(outcome in outcomes) {
            student.outcomeMapping[outcome.id] = StudentOutcome(mastery = outcome.mastery)
            DB.students.set(student.id, student)
        }

        print(student)
    }


}