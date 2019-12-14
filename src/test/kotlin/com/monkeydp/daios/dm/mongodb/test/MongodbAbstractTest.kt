package com.monkeydp.daios.dm.mongodb.test

import com.monkeydp.daios.dm.mongodb.MongodbApp
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.conn.Conn
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.daios.dms.sdk.request.RequestContext
import com.monkeydp.tools.config.enableDebugMode
import com.monkeydp.tools.exception.inner.PropertyUninitializedException
import com.monkeydp.tools.ext.kotlin.notNullSingleton
import org.junit.After
import org.junit.Before
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import kotlin.properties.Delegates

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