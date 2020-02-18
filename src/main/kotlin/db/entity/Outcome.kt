package edu.colostate.csedu.db.entity

import kotlinx.serialization.Serializable

@Serializable
data class Outcome(var description: String="", var friendlyName: String = "", var id: String = "")

@Serializable
data class OutcomeResult(var outcomeId: String = "", var score:  Double = 0.0,  var mastery: Double = 0.0,
                         var links : MutableMap<String, String> = mutableMapOf())  // links include paths in DB