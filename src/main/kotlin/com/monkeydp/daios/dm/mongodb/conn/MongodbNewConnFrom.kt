package com.monkeydp.daios.dm.mongodb.conn

import com.monkeydp.daios.dm.base.conn.AbstractNewConnForm
import com.monkeydp.daios.dms.sdk.received.form.annot.SdkNewConnForm

/**
 * @author iPotato
 * @date 2019/10/20
 */
@SdkNewConnForm
class MongodbNewConnFrom(
        connName: String = "Mongodb Conn",
        host: String = "127.0.0.1",
        port: String = "27017",
        username: String = "root",
        password: String = "root"
) : AbstractNewConnForm(connName, host, port, username, password)