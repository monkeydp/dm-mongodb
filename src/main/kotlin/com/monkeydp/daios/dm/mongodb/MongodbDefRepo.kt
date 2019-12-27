package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.AbstractDsDefRepo
import com.monkeydp.daios.dm.mongodb.MongodbVersion.MONGODB_4_0
import com.monkeydp.daios.dms.sdk.datasource.SdkDsDef

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MongodbDefRepo : AbstractDsDefRepo<MongodbDef>() {
    
    @SdkDsDef
    val mongodb40def = MongodbDef(MONGODB_4_0)
}