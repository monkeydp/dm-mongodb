package com.monkeydp.daios.dm.mongodb

/**
 * @author iPotato
 * @date 2019/12/28
 */
enum class MongodbDefaultDb {
    
    ADMIN, CONFIG, LOCAL, TEST;
    
    val dbName: String = name.toLowerCase()
}