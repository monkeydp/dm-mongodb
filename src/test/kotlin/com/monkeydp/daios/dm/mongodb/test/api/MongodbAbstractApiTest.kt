package com.monkeydp.daios.dm.mongodb.test.api

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker
import com.monkeydp.daios.dm.mongodb.test.MongodbAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.daios.dms.sdk.share.request.RequestContext
import com.monkeydp.tools.exception.inner.PropertyUninitializedException
import org.junit.After
import org.junit.Before
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/12/14
 */
internal abstract class MongodbAbstractApiTest : MongodbAbstractTest() {
    
    private val ctx: RequestContext by kodein.instance()
    private val connApi: ConnApi by kodein.instance()
    
    @Before
    @IgnoreException(Kodein.NotFoundException::class)
    fun before() {
        ctx.setRequestAttributes {
            cp = MongodbCpMocker.cp
            conn = connApi.getConn(cp)
        }
    }
    
    @After
    @IgnoreException(PropertyUninitializedException::class)
    fun after() {
        ctx.requestAttributes.conn.close()
    }
}