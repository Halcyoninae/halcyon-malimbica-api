package com.jackmeng.halcyon.malimbica

import java.util.*

class Lexer(objects: String) {
    private val content: Map<String, ByteArray>?

    init {
        content = init(objects)
    }

    @Throws(LexingException::class)
    private fun identify(obj: String) {
        if (obj[0] != LEXER_FORMAT) {
            throw LexingException(
                """
    Incorrect format spotted for this lexer!!
    Got: ${obj[0]}
    Mine: $LEXER_FORMAT
    """.trimIndent()
            )
        }
    }

    private fun is_tag(obj: String): Boolean {
        return obj.endsWith(LexerDictionary.TAG_CHAR) && (obj.startsWith(LexerDictionary.TAG_CHAR) || obj.startsWith(
            LexerDictionary.END_TAG_CHAR
        ))
    }

    @Throws(LexingException::class)
    private fun Stringtag(un: String): Boolean {
        if (is_tag(un)) {
            return true
        }
        throw LexingException("Tag: $un\nIs not a tag!")
    }

    @Throws(LexingException::class)
    private fun init(obj: String): Map<String, ByteArray>? {
        identify(obj)
        val st = StringTokenizer(obj.substring(2, obj.length))
        val args: Map<String, ByteArray> = HashMap()
        while (st.hasMoreTokens()) {
            val curr = st.nextToken()
            if (is_tag(curr)) {
            }
        }
        return null
    }

    interface LexerDictionary {
        companion object {
            const val TAG_CHAR = "__"
            const val END_TAG_CHAR = "!_"
        }
    }

    class StupidToken(private val armor: StupidMethod, private vararg val container: Byte) {
        fun armor(armor_override: StupidMethod?): Array<Any?> {
            if (armor_override != null) {
                println("> STUPID_LEXER: Overriding the armor.\n\t-Overridden by third-party means")
            }
            if (armor_override == StupidMethod.CHARABLE) {
                val bd = StringBuilder()
                for (b in container) {
                    bd.append(b.toInt())
                }
            }
            return arrayOfNulls(0)
        }

        enum class StupidMethod {
            NUMERICAL, CHARABLE, BIN, ENC_SHA_256, ENC_SHIFT_64
        }
    }

    companion object {
        const val LEXER_FORMAT = '1'
    }
}