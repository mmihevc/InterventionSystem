package edu.colostate.csedu.db.firestore

import edu.colostate.csedu.db.Resources
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
class ResourcesFb(val db: Firebase) : Resources {
    override fun getAll(): List<Resource> {
        val collection = db.getCollection(RESOURCES_TABLE_NAME)
        val list = mutableListOf<Resource>()
        for (document in collection) {
            list += document.toObject(Resource::class.java)
            list.last().id = document.id // actually matches canvasId, but just in case it doesn't
        }
        return list
    }

    override fun set(id: String, resource: Resource) {
        db.setDocument(RESOURCES_TABLE_NAME, id, resource.toMap())
    }


    companion object {
        private const val RESOURCES_TABLE_NAME = "resources"

    }
}