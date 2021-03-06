package com.monkeydp.daios.dm.mongodb.ui.menu

import com.monkeydp.daios.dms.sdk.ui.menu.AbstractMdStruct
import com.monkeydp.daios.dms.sdk.ui.menu.SdkMdStruct
import com.monkeydp.tools.ext.kotlin.toPropValuesX

/**
 * @author iPotato
 * @date 2019/12/23
 */
@SdkMdStruct
internal object MongodbMdStruct : AbstractMdStruct(
        MongodbMenuDefs.toPropValuesX()
)