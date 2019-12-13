package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.datasource.AbstractDsDefs
import com.monkeydp.daios.dm.base.datasource.dsDef
import com.monkeydp.daios.dm.mongodb.MongodbVersion.MONGODB_4_0
import com.monkeydp.daios.dms.sdk.datasource.DsDef
import com.monkeydp.tools.ext.kotlin.toPropValueSetX

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MongodbDefs : AbstractDsDefs<DsDef>() {
    
    val mongodb40def = dsDef {
        version = MONGODB_4_0
    }
    
    override fun toSet() = toPropValueSetX<DsDef>()
}