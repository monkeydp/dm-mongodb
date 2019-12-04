package com.monkeydp.daios.dm.mongodb.test

import com.monkeydp.daios.dm.mongodb.MongodbApp
import com.monkeydp.daios.dm.mongodb.MongodbVersion
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.conn.Conn
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.daios.dms.sdk.dm.DmTestdataRegistry
import com.monkeydp.daios.dms.sdk.request.RequestContext
import com.monkeydp.tools.ext.enableDebugMode
import com.monkeydp.tools.ext.isDebugMode
import com.monkeydp.tools.ext.notNullSingleton
import org.junit.After
import org.junit.Before
import org.kodein.di.generic.instance
import org.kodein.di.generic.instanceOrNull
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
            MongodbApp(DmConfig.mock())
        }
    }
    
    private val _connApi: ConnApi? by kodein.instanceOrNull()
    private val connApi by lazy { _connApi!! }
    private var conn by Delegates.notNullSingleton<Conn<*>>()
    
    @Before
    fun before() {
        if (_connApi == null && isDebugMode()) return
        conn = connApi.getConn(MongodbCpMocker.cp)
        RequestContext.init(conn = conn)
    }
    
    @After
    fun after() {
        if (_connApi == null && isDebugMode()) return
        conn.close()
    }
    
    protected inline fun <reified A : Any> findApi(): A {
        val api by kodein.instance<A>()
        return api
    }
}