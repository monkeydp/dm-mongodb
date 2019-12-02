package com.monkeydp.daios.dm.mongodb.mocker

import com.monkeydp.daios.dm.mongodb.MongodbDefs.mongodb40dsDef
import com.monkeydp.daios.dm.mongodb.conn.MongodbNewConnFrom
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MONGODB
import com.monkeydp.tools.ext.convertTo

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MongodbCpMocker {
    
    private val mongodb40cp = ConnProfile(
            datasource = MONGODB,
            dsVersionId = mongodb40dsDef.version.id,
            userInput = MongodbNewConnFrom(connName = "MongoDb 4.0 Conn").convertTo()
    )
    
    val cp = mongodb40cp
    val cps = listOf(mongodb40cp)
}