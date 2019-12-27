package com.monkeydp.daios.dm.mongodb.api

import com.mongodb.MongoClient
import com.monkeydp.daios.dm.base.api.AbstractConnApi
import com.monkeydp.daios.dm.mongodb.conn.MongodbConn
import com.monkeydp.daios.dms.sdk.api.annot.SdkConnApi
import com.monkeydp.daios.dms.sdk.conn.Conn
import com.monkeydp.daios.dms.sdk.conn.ConnProfile

/**
 * @author iPotato
 * @date 2019/12/27
 */
@SdkConnApi
object MongodbConnApi : AbstractConnApi() {
    override fun getConn(cp: ConnProfile): Conn<*> {
        val form = cp.form
        val mongoClient = MongoClient(form.host, form.port.toInt())
        return MongodbConn(cp.id, mongoClient)
    }
}