package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.daios.dms.sdk.main.SdkDmApp
import org.kodein.di.Kodein
import com.monkeydp.daios.dm.mongodb.config.initKodein as initKodeinExt

/**
 * @author iPotato
 * @date 2019/12/5
 */
@SdkDmApp
class MongodbApp(config: DmConfig) : AbstractDmApp(config) {
    override fun initKodein(vararg modules: Kodein.Module): Kodein {
        initKodeinExt(*modules)
        return kodein
    }
}