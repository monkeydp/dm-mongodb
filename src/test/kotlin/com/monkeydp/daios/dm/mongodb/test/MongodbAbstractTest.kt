package com.monkeydp.daios.dm.mongodb.test

import com.monkeydp.daios.dm.mongodb.MongodbApp
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.tools.config.enableDebugMode

/**
 * @author iPotato
 * @date 2019/10/27
 */
internal abstract class MongodbAbstractTest {
    
    companion object {
        init {
            enableDebugMode()
            MongodbApp(DmConfig.mock())
        }
    }
}