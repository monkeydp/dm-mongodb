package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dms.sdk.SdkDmApp
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MONGODB

/**
 * @author iPotato
 * @date 2019/12/5
 */
@SdkDmApp(MONGODB)
object MongodbApp : AbstractDmApp(kodein)