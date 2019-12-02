package com.monkeydp.daios.dm.mongodb.test

import com.monkeydp.daios.dm.mongodb.MongodbDm
import com.monkeydp.daios.dm.mongodb.MongodbVersion
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker
import com.monkeydp.daios.dms.sdk.conn.Conn
import com.monkeydp.daios.dms.sdk.dm.DmOpenConfig
import com.monkeydp.daios.dms.sdk.dm.DmTestdataRegistry
import com.monkeydp.daios.dms.sdk.request.RequestContext
import com.monkeydp.tools.exception.inner.PropertyUninitializedException
import com.monkeydp.tools.ext.enableDebugMode
import com.monkeydp.tools.ext.isDebugMode
import com.monkeydp.tools.ext.notNullSingleton
import org.junit.After
import org.junit.Before
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/27
 */
abstract class AbstractTest {
    
    companion object {
        init {
            enableDebugMode()
            DmTestdataRegistry.testDsVersion = MongodbVersion.MONGODB_4_0
            MongodbDm(DmOpenConfig.mock())
        }
    }
    
    private val dm = MongodbDm.INSTANCE
    protected val apis = dm.impl.apis
    private var conn by Delegates.notNullSingleton<Conn<*>>()
    
    @Before
    fun before() {
        try {
            val connApi = apis.connApi
            conn = connApi.getConn(MongodbCpMocker.cp)
            RequestContext.init(conn = conn)
        } catch (e: PropertyUninitializedException) {
            if (isDebugMode()) return
            throw e
        }
    }
    
    @After
    fun after() {
        try {
            conn.close()
        } catch (e: PropertyUninitializedException) {
            if (isDebugMode()) return
            throw e
        }
    }
}