package com.jackmeng.halcyon.malimbica.getter

import com.jackmeng.halcyon.malimbica.Getter
import com.jackmeng.halcyon.malimbica.Lexer
import java.util.HashMap

class VersionGetter(lexer: Lexer?) : Getter {
    private val myMap: HashMap<Any, Any>

    init {
        assert(lexer != null)
        myMap = lexer!!.meta?.get(Lexer.VERSION_MAP)!!
    }

    override fun get(key: Any?): Any? {
        assert(key === VERSION_KEY_NUM || key === VERSION_KEY_PRETTY || key === ITERATION_KEY_NUM || key === ITERATION_KEY_PRETTY)
        return myMap[key]!!
    }

    companion object {
        const val VERSION_KEY_PRETTY = "halcyon_version_pretty"
        const val VERSION_KEY_NUM = "halcyon_version_numeral"
        const val ITERATION_KEY_PRETTY = "halcyon_iteration_pretty"
        const val ITERATION_KEY_NUM = "halcyon_iteration_numeral"
    }
}