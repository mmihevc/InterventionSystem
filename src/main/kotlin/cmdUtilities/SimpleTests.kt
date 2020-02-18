package edu.colostate.csedu.cmdUtilities

import edu.colostate.csedu.DB

/**
 * Simple test method as I rework the student tables
 */
fun main(args: Array<String>) {
    val list = DB.students.getAll()
    println(list)

    val outcomes = DB.outcomes.getAll()
    println(outcomes)


}