package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mongodb.config.initKodein
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import org.kodein.di.Kodein
import org.kodein.di.LazyKodein

/**
 * @author iPotato
 * @date 2019/12/5
 */
class MongodbApp(config: DmConfig) : AbstractDmApp(config) {
    override fun initDmKodein(vararg modules: Kodein.Module): Kodein {
        kodein = LazyKodein { initKodein(*modules) }
        return kodein
    }
}