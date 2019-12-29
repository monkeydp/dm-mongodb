package com.monkeydp.daios.dm.mongodb.test.api

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker.cp
import com.monkeydp.daios.dms.sdk.api.ConnApi
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/12/27
 */
internal class MongodbConnApiTest : MongodbAbstractApiTest() {
    
    private val api: ConnApi by kodein.instance()
    
    @Test
    fun connTest() {
        val conn = api.getConn(cp)
        assertTrue(conn.isValid())
        assertFalse(conn.isClosed())
        
        conn.close()
        assertFalse(conn.isValid())
        assertTrue(conn.isClosed())
    }
}