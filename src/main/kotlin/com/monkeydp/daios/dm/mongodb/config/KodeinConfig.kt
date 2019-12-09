package com.monkeydp.daios.dm.mongodb.config

import com.monkeydp.tools.ext.notNullSingleton
import org.kodein.di.Kodein
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal var kodein: Kodein by Delegates.notNullSingleton()

internal fun initKodein(vararg modules: Kodein.Module) {
    kodein = Kodein {
        importAll(*modules)
    }
}