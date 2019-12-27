package com.monkeydp.daios.dm.mongodb.test.api

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker.cp
import com.monkeydp.daios.dms.sdk.api.ConnApi
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
        api.getConn(cp)
    }
}