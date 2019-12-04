package com.monkeydp.daios.dm.mongodb

import com.monkeydp.daios.dm.base.AbstractDmTestdata
import com.monkeydp.daios.dm.mongodb.mocker.MongodbCpMocker

/**
 * @author iPotato
 * @date 2019/12/5
 */
object MongodbTestdata : AbstractDmTestdata() {
    override val cps = MongodbCpMocker.cps
}