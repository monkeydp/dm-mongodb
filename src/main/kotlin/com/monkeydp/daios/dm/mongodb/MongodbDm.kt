package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.AbstractDm
import com.monkeydp.daios.dm.mongodb.config.MongodbDirpath
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker
import com.monkeydp.daios.dms.sdk.dm.DmOpenConfig
import com.monkeydp.daios.dms.sdk.dm.DmTestdata
import com.monkeydp.tools.ext.notNullSingleton
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/8
 */
class MongodbDm(config: DmOpenConfig) : AbstractDm(config) {
    
    companion object {
        @Volatile
        private var isInitialized = false
        var INSTANCE by Delegates.notNullSingleton<MongodbDm>()
            private set
    }
    
    override val dsDefs = MongodbDefs.toSet()
    override val testdata = object : DmTestdata {
        override val cps = MongodbCpMocker.cps
    }
    
    init {
        if (!isInitialized) {
            synchronized(MongodbDm::class) {
                if (!isInitialized) {
                    initialize()
                    INSTANCE = this
                }
            }
        }
    }
    
    override fun updateOpenConfig(config: DmOpenConfig) {
        MongodbDirpath.dist = config.deployDir.path
    }
}