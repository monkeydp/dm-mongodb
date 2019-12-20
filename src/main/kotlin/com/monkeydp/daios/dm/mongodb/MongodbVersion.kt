package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dms.sdk.datasource.Datasource
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MONGODB
import com.monkeydp.daios.dms.sdk.datasource.DsVersion
import com.monkeydp.daios.dms.sdk.datasource.SdkDsVersion

/**
 * @author iPotato
 * @date 2019/10/27
 */
@SdkDsVersion
enum class MongodbVersion(
        override val id: String,
        override val description: String,
        override val datasource: Datasource = MONGODB
) : DsVersion<MongodbVersion> {
    MONGODB_4_0("4.0", "Mongodb 4.0");
}