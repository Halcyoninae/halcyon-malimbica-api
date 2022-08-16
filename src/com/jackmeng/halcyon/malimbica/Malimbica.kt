package com.jackmeng.halcyon.malimbica

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

object Malimbica {
    private const val DEFAULT_PING_API = "https://halcyoninae.github.io/halcyon-malimbica/"
    @JvmStatic
    val asString: String
        get() {
            val sb = StringBuilder()
            try {
                val url = URL(DEFAULT_PING_API)
                val `is` = url.openStream()
                val br = BufferedReader(InputStreamReader(`is`))
                var temp: String?
                while (br.readLine().also { temp = it } != null) {
                    sb.append(temp)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return sb.toString()
        }
}