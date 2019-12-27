package com.monkeydp.daios.dm.mongodb.ext.mongodb

import com.mongodb.Mongo
import com.mongodb.client.internal.MongoClientDelegate
import com.monkeydp.tools.util.FieldUtil

/**
 * @author iPotato
 * @date 2019/12/28
 */
fun Mongo.isClosed(): Boolean {
    val delegate = FieldUtil.getValue<MongoClientDelegate>(this, "delegate", forceAccess = true)
    return delegate.cluster.isClosed
}

fun Mongo.isValid(): Boolean = !isClosed()