package com.jackmeng.halcyon.malimbica

interface Getter {
    operator fun get(key: Any?): Any?
    fun getContentMap(): java.util.HashMap<Any, Any>?
}