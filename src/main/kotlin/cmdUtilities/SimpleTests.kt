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

    val resources = DB.resources.getAll()

    println(resources)




}