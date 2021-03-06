package com.monkeydp.daios.dm.mongodb.api

import com.mongodb.MongoClient
import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.ui.node.def.CollNd
import com.monkeydp.daios.dm.base.ui.node.def.DbNd
import com.monkeydp.daios.dm.base.ui.node.def.UnhandledNodeDefException
import com.monkeydp.daios.dm.mongodb.config.kodein
import com.monkeydp.daios.dm.mongodb.ui.node.MongodbNodePath
import com.monkeydp.daios.dms.sdk.api.annot.SdkNodeApi
import com.monkeydp.daios.dms.sdk.context.ConnContext
import com.monkeydp.daios.dms.sdk.ui.node.Node
import com.monkeydp.daios.dms.sdk.ui.node.NodeDef
import com.monkeydp.daios.dms.sdk.ui.node.NodePath
import com.monkeydp.tools.ext.kodein.providerX

/**
 * @author iPotato
 * @date 2019/12/28
 */
@SdkNodeApi
object MongodbNodeApi : AbstractNodeApi() {
    
    private val connContext: ConnContext get() = kodein.providerX()
    
    override fun loadNonGroupNodes(path: NodePath, def: NodeDef): List<Node> =
            loadNonGroupNodes(path.toSub(), def)
    
    private fun loadNonGroupNodes(path: MongodbNodePath, def: NodeDef): List<Node> =
            (connContext.conn.rawConn as MongoClient).let {
                when (def) {
                    is DbNd -> loadDbNodes(it, def)
                    is CollNd -> loadCollNodes(it, def, path.dbName)
                    else -> throw UnhandledNodeDefException(def)
                }
            }
    
    private fun loadDbNodes(client: MongoClient, def: DbNd): List<Node> =
            client.listDatabaseNames().map { def.create(it) }.toList()
    
    private fun loadCollNodes(client: MongoClient, def: CollNd, dbName: String): List<Node> =
            client.getDatabase(dbName).listCollectionNames().map { def.create(it) }.toList()
}