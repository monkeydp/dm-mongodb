package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MONGODB
import com.monkeydp.daios.dms.sdk.dm.AbstractDmApp
import com.monkeydp.daios.dms.sdk.dm.SdkDmApp

/**
 * @author iPotato
 * @date 2019/12/5
 */
@SdkDmApp(MONGODB)
object MongodbApp : AbstractDmApp(kodein)