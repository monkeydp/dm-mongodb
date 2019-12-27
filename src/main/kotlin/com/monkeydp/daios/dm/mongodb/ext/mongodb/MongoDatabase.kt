package com.monkeydp.daios.dm.mongodb.ext.mongodb

import com.mongodb.client.MongoDatabase
import org.bson.Document

/**
 * @author iPotato
 * @date 2019/12/28
 */
fun MongoDatabase.runCommand(vararg pairs: Pair<String, Any>) =
        runCommand(Document(mapOf(*pairs)))