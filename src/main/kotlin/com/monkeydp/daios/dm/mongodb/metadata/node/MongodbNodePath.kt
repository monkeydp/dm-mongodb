package com.monkeydp.daios.dm.mongodb.metadata.node

import com.monkeydp.daios.dms.sdk.metadata.node.NodePath


/**
 * @author iPotato
 * @date 2019/10/28
 */
class MongodbNodePath : NodePath() {
    
    private val dbNode get() = this[1]
    val dbName get() = dbNode.name
    
    private val collNode get() = this[3]
    val collName get() = collNode.name
    
    private val viewNode get() = this[3]
    val viewName get() = viewNode.name
}