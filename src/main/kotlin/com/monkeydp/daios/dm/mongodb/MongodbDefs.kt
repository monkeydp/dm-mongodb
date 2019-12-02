package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.datasource.AbstractDsDefs
import com.monkeydp.daios.dm.base.datasource.dsDef
import com.monkeydp.daios.dm.mongodb.MongodbVersion.MONGODB_4_0

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MongodbDefs : AbstractDsDefs() {
    val mongodb40dsDef = dsDef {
        version = MONGODB_4_0
    }
}