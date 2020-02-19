package edu.colostate.csedu.db.firestore

import edu.colostate.csedu.db.Outcomes
import edu.colostate.csedu.db.entity.Outcome
import edu.colostate.csedu.db.entity.Student

class OutcomesFb(var db: Firebase) : Outcomes{

    override fun set(outcome: Outcome) {
        db.setDocument(OUTCOMES_TABLE_NAME, outcome.id, outcome.toMap())
    }

    override fun getAll(): List<Outcome> {
        val collection = db.getCollection(OUTCOMES_TABLE_NAME)
        val list = mutableListOf<Outcome>()
        for (document in collection ) {
            list += document.toObject(Outcome::class.java)
            list.last().id = document.id
        }
        return list
    }


    companion object {
        private const val OUTCOMES_TABLE_NAME = "outcomes"


    }
}