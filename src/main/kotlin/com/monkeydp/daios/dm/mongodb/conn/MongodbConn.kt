package com.monkeydp.daios.dm.mongodb.conn

import com.mongodb.MongoClient
import com.monkeydp.daios.dm.base.conn.AbstractConn
import com.monkeydp.daios.dm.mongodb.ext.mongodb.isClosed
import com.monkeydp.daios.dm.mongodb.ext.mongodb.isValid

/**
 * @author iPotato
 * @date 2019/12/27
 */
class MongodbConn(
        cpId: Long,
        rawConn: MongoClient
) : AbstractConn<MongoClient>(cpId, rawConn) {
    
    override fun isValid(timeout: Int): Boolean = rawConn.isValid()
    
    override fun close() {
        rawConn.close()
    }
    
    override fun isClosed(): Boolean = rawConn.isClosed()
}