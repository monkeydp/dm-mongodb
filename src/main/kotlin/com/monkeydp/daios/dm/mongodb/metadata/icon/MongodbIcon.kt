package com.monkeydp.daios.dm.mongodb.metadata.icon

import com.monkeydp.daios.dms.sdk.metadata.icon.Icon

/**
 * @author iPotato
 * @date 2019/12/28
 */
enum class MongodbIcon(
        override val namex: String,
        override val color: String
) : Icon<MongodbIcon> {
    MONGODB_CONN_ICON("mongodb conn icon", "")
}