package com.monkeydp.daios.dm.mongodb.ui.node

import com.monkeydp.daios.dm.base.ui.node.def.*
import com.monkeydp.daios.dm.mongodb.ui.icon.MongodbIcon.MONGODB_CONN_ICON
import com.monkeydp.daios.dms.sdk.ui.node.AbstractNdStruct
import com.monkeydp.daios.dms.sdk.ui.node.SdkNdStruct

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