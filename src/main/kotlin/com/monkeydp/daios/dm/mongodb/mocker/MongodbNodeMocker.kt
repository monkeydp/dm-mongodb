package com.monkeydp.daios.dm.mongodb.mocker

import com.monkeydp.daios.dm.base.ui.node.def.CollsNd
import com.monkeydp.daios.dm.base.ui.node.def.ConnNd
import com.monkeydp.daios.dm.base.ui.node.def.DbNd
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker.cp
import com.monkeydp.daios.dm.mongodb.mocker.MongodbElementMocker.DB_NAME
import com.monkeydp.daios.dms.sdk.ui.node.NodeDefStruct
import com.monkeydp.daios.dms.sdk.ui.node.NodePath
import com.monkeydp.daios.dms.sdk.ui.node.find
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MongodbNodeMocker {
    private val ndStruct: NodeDefStruct by kodein.instance()
    
    val connNodePath = NodePath.of(ndStruct.find<ConnNd>().create(cp))
    val dbNodePath = NodePath.of(connNodePath, ndStruct.find<DbNd>().create(DB_NAME))
    val collsNodePath = NodePath.of(dbNodePath, ndStruct.find<CollsNd>().create())
}