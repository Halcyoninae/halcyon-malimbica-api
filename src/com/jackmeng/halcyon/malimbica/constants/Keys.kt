package com.jackmeng.halcyon.malimbica.constants

/**
 * Holds value for all the required
 * keys within a serialized data format.
 *
 * @author Jack Meng
 * @since 1.0
 */
interface Keys {
    companion object {
        val keys = arrayOf("vmap", "annc")
        const val KEY_VERSION = 0
        const val KEY_ANNOUNCEMENT = 1
    }
}