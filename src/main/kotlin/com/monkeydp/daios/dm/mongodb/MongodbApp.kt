package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mongodb.config.MongodbKodeinCompConfig
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dms.sdk.annot.SdkDmApp
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MONGODB
import com.monkeydp.daios.dms.sdk.share.kodein.kodeinModules
import com.monkeydp.tools.ext.kodein.KodeinHelper
import org.kodein.di.Kodein

/**
 * @author iPotato
 * @date 2019/12/5
 */
@SdkDmApp(MONGODB)
object MongodbApp : AbstractDmApp() {
    override fun initDmKodein(): Kodein {
        kodein.baseKodein = KodeinHelper.initKodein(MongodbKodeinCompConfig, *kodeinModules)
        return kodein
    }
}