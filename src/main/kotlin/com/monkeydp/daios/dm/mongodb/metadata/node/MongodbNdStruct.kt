package com.monkeydp.daios.dm.mongodb.metadata.node

import com.monkeydp.daios.dm.base.metadata.node.def.*
import com.monkeydp.daios.dm.mongodb.metadata.icon.MongodbIcon.MONGODB_CONN_ICON
import com.monkeydp.daios.dms.sdk.metadata.node.AbstractNdStruct
import com.monkeydp.daios.dms.sdk.metadata.node.SdkNdStruct

/**
 * @author iPotato
 * @date 2019/12/28
 */
@SdkNdStruct
object MongodbNdStruct : AbstractNdStruct(
        ConnNd {
            icon = MONGODB_CONN_ICON
            +DbNd {
                +CollsNd { +CollNd {} }
                +ViewsNd { +ViewNd {} }
            }
        }
)