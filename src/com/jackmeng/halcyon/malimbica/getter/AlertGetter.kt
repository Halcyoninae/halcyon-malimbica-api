package com.jackmeng.halcyon.malimbica.getter

import com.jackmeng.halcyon.malimbica.Getter
import com.jackmeng.halcyon.malimbica.Lexer
import com.jackmeng.halcyon.malimbica.constants.Keys.Companion.keys
import java.util.HashMap
import com.jackmeng.halcyon.malimbica.constants.Keys

class AlertGetter(lexer: Lexer?) : Getter {
    private val myLexer: Lexer?

    init {
        assert(lexer != null)
        myLexer = lexer
    }

    override fun get(key: Any?): Any? {
        assert(key == ALERT_KEY_MAIN || key == ALERT_KEY_SUB || key == ALERT_KEY_TER)
        return getContentMap()?.get(key)
    }

    override fun getContentMap(): HashMap<Any, Any>? {
        return myLexer!!.meta?.get(keys[Keys.KEY_ANNOUNCEMENT])
    }

    companion object {
        const val ALERT_KEY_MAIN = "akm"
        const val ALERT_KEY_SUB = "aks"
        const val ALERT_KEY_TER = "akt"
    }
}