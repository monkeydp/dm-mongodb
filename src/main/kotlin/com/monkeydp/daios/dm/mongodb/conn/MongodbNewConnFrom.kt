package com.monkeydp.daios.dm.mongodb.conn

import com.monkeydp.daios.dm.base.conn.AbstractNewConnForm
import com.monkeydp.daios.dm.base.instruction.NewConn
import com.monkeydp.daios.dms.sdk.main.SdkForm

/**
 * @author iPotato
 * @date 2019/10/20
 */
@SdkForm(instrClass = NewConn::class)
class MongodbNewConnFrom : AbstractNewConnForm {
    constructor(
            connName: String = "Mongodb Conn",
            host: String = "127.0.0.1",
            port: String = "27017",
            username: String = "root",
            password: String = "root"
    ) : super(connName, host, port, username, password)
}