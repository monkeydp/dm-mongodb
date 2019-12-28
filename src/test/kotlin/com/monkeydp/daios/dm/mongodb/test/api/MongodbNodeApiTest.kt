package com.monkeydp.daios.dm.mongodb.test.api

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbNodeMocker.connNodePath
import com.monkeydp.daios.dms.sdk.api.NodeApi
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/12/27
 */
internal class MongodbNodeApiTest : MongodbAbstractApiTest() {
    
    private val api: NodeApi by kodein.instance()
    
    @Test
    fun loadDbsTest() {
        val nodes = api.loadSubNodes(connNodePath)
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assertions.assertEquals(GlobalTarget.DB, it.target) }
    }
}