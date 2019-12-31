package com.monkeydp.daios.dm.mongodb.test.api

import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbNodeMocker.collsNodePath
import com.monkeydp.daios.dm.mongodb.mocker.MongodbNodeMocker.connNodePath
import com.monkeydp.daios.dm.mongodb.mocker.MongodbNodeMocker.dbNodePath
import com.monkeydp.daios.dms.sdk.api.NodeApi
import com.monkeydp.daios.dms.sdk.context.ContextRepoHolder
import com.monkeydp.daios.dms.sdk.context.NodeContext
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.*
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
    fun loadDbNodesTest() {
        ContextRepoHolder.updateContextRepo {
            nodeContext = NodeContext(connNodePath)
        }
        val nodes = api.loadSubNodes()
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assertions.assertEquals(DB, it.target) }
    }
    
    @Test
    fun loadCollNodesTest() {
        ContextRepoHolder.updateContextRepo {
            nodeContext = NodeContext(collsNodePath)
        }
        val nodes = api.loadSubNodes()
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assertions.assertEquals(COLL, it.target) }
    }
    
    @Test
    fun loadGroupNodesTest() {
        ContextRepoHolder.updateContextRepo {
            nodeContext = NodeContext(dbNodePath)
        }
        val nodes = api.loadSubNodes()
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assertions.assertEquals(GROUP, it.target) }
    }
}