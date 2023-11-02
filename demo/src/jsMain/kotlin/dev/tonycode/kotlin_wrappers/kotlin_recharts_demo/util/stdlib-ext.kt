package dev.tonycode.kotlin_wrappers.kotlin_recharts_demo.util


/**
 * more explicit way for `?.let`
 */
inline fun <T : Any, R> T?.ifNotNull(f: (T) -> R): R? = this?.let(f)
