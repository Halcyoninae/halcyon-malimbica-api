package com.jackmeng.halcyon.test

import com.jackmeng.halcyon.malimbica.Lexer
import com.jackmeng.halcyon.malimbica.Malimbica.asString
import kotlin.Throws
import kotlin.jvm.JvmStatic
import com.jackmeng.halcyon.malimbica.Malimbica
import java.lang.Exception

object PingTest {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println(asString)
        val l = Lexer(asString)
    }
}