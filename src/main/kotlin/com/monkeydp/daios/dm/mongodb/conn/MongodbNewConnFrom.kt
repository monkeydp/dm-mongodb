package com.monkeydp.daios.dm.mongodb.conn

import com.monkeydp.daios.dm.base.conn.AbstractNewConnForm

/**
 * @author iPotato
 * @date 2019/10/20
 */
//@KodeinComponent(MongodbNewConnFrom.KodeinBuilderConfig::class)
class MongodbNewConnFrom : AbstractNewConnForm {
    constructor(
            connName: String = "Mongodb Conn",
            host: String = "127.0.0.1",
            port: String = "27017",
            username: String = "root",
            password: String = "root"
    ) : super(connName, host, port, username, password)
    
//    class KodeinBuilderConfig : AbstractKodeinBuilderConfig() {
//        override fun Kodein.Builder.config() {
//            bind<KClass<out NewConnForm>>() with singleton { MongodbNewConnFrom::class }
//            bind<KClass<out ReceivedForm>>(tag = NewConn::class) with singleton { MongodbNewConnFrom::class }
//        }
//    }
}