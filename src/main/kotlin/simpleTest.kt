package edu.colostate.csedu

import edu.colostate.csedu.cmdUtilities.SheetsReader


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

fun main(array: Array<String>) {

    val reader = SheetsReader()
    val list = reader.getStudents(reader.getCanvasMap())
    print(list)


}