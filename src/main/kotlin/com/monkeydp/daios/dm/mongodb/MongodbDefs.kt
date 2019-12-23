package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.mongodb.MongodbVersion.MONGODB_4_0
import com.monkeydp.daios.dms.sdk.datasource.DsDef
import com.monkeydp.daios.dms.sdk.datasource.SdkDsDef

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MongodbDefs {
    
    @SdkDsDef
    val mongodb40def = DsDef(MONGODB_4_0)
}