package com.jackmeng.halcyon.malimbica.getter

import com.jackmeng.halcyon.malimbica.Getter
import com.jackmeng.halcyon.malimbica.Lexer
import com.jackmeng.halcyon.malimbica.constants.Keys

/**
 * A specific getter that parses
 * only version data.
 *
 * @author Jack Meng
 * @since 1.0
 */
class VersionGetter(lexer: Lexer?) : Getter {
    private val myLexer: Lexer?

    init {
        assert(lexer != null)
        myLexer = lexer
    }

    override fun get(key: Any?): Any {
        assert(key === VERSION_KEY_NUM || key === VERSION_KEY_PRETTY || key === ITERATION_KEY_NUM || key === ITERATION_KEY_PRETTY)
        return myLexer?.meta?.get(key)?.get(key)!!
    }

    override fun getContentMap(): HashMap<Any, Any>? {
        return myLexer?.meta?.get(Keys.keys[Keys.KEY_VERSION])
    }

    companion object {
        const val VERSION_KEY_PRETTY = "halcyon_version_pretty"
        const val VERSION_KEY_NUM = "halcyon_version_numeral"
        const val ITERATION_KEY_PRETTY = "halcyon_iteration_pretty"
        const val ITERATION_KEY_NUM = "halcyon_iteration_numeral"
    }
}