package com.jackmeng.halcyon.malimbica

import java.io.*
import kotlin.jvm.JvmOverloads
import java.util.HashMap
import java.lang.StringBuilder
import java.lang.ClassNotFoundException
import java.net.URL

class Lexer @JvmOverloads constructor(override_url: String = "https://halcyoninae.github.io/halcyon-malimbica/schema/version.txt") {
    private val resourceLink: String
    var meta: HashMap<String, HashMap<Any, Any>>? = null
        private set

    init {
        assert(override_url.startsWith("http"))
        resourceLink = override_url
        __init()
    }

    private fun __init() {
        meta = HashMap()
        // first part init version id
        try {
            val url = URL(resourceLink)
            val stream = BufferedReader(InputStreamReader(url.openStream()))
            val sb = StringBuilder()
            var temp: String?
            while (stream.readLine().also { temp = it } != null) {
                sb.append(temp)
            }
            val ser = sb.toString().toByteArray()
            val bai = ByteArrayInputStream(ser)
            val ois = ObjectInputStream(bai)
            meta!![VERSION_MAP] = ois.readObject() as HashMap<Any, Any>
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    companion object {
        const val VERSION_MAP = "vmap"
    }
}