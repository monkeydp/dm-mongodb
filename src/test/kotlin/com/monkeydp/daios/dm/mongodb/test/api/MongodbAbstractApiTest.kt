package com.monkeydp.daios.dm.mongodb.test.api

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker.cp
import com.monkeydp.daios.dm.mongodb.test.MongodbAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.daios.dms.sdk.share.conn.ConnContext
import com.monkeydp.daios.dms.sdk.share.request.RequestContextHolder
import com.monkeydp.tools.ext.kotlin.PropertyUninitializedException
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/12/14
 */
internal abstract class MongodbAbstractApiTest : MongodbAbstractTest() {
    
    private val connApi: ConnApi by kodein.instance()
    private val connContext: ConnContext by kodein.instance()
    
    @BeforeAll
    @IgnoreException(Kodein.NotFoundException::class)
    fun beforeAll() {
        RequestContextHolder.setRequestAttributes(
                ConnContext(cp) {
                    conn = connApi.getConn(cp)
                }
        )
    }
    
    @AfterAll
    @IgnoreException(PropertyUninitializedException::class)
    fun afterAll() {
        connContext.conn.close()
    }
}