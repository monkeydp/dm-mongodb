package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dms.sdk.annot.SdkEnum
import com.monkeydp.daios.dms.sdk.datasource.Datasource
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MONGODB
import com.monkeydp.daios.dms.sdk.datasource.DsVersion

/**
 * @author iPotato
 * @date 2019/10/27
 */
@SdkEnum
enum class MongodbVersion(
        override val id: String,
        override val description: String,
        override val datasource: Datasource = MONGODB
) : DsVersion<MongodbVersion> {
    MONGODB_4_0("4.0", "Mongodb 4.0"),
}