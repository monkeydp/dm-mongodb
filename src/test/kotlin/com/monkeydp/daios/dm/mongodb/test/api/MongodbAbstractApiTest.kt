package com.monkeydp.daios.dm.mongodb.test.api

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker.cp
import com.monkeydp.daios.dm.mongodb.test.MongodbAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.context.ConnContext
import com.monkeydp.daios.dms.sdk.context.ContextRepoHolder
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.tools.ext.kodein.providerX
import com.monkeydp.tools.ext.kotlin.PropertyUninitializedException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/12/14
 */
internal abstract class MongodbAbstractApiTest : MongodbAbstractTest() {
    
    private val connApi: ConnApi by kodein.instance()
    private val connContext: ConnContext get() = kodein.providerX()
    
    @BeforeEach
    @IgnoreException(Kodein.NotFoundException::class)
    fun beforeEach() {
        ContextRepoHolder.setContextRepo(
                ConnContext(
                        cp,
                        conn = connApi.getConn(cp)
                )
        )
    }
    
    @AfterEach
    @IgnoreException(PropertyUninitializedException::class)
    fun afterEach() {
        connContext.conn.close()
        ContextRepoHolder.resetContextRepo()
    }
}