fun mergeMaps(m1: Map<String, Any?>, m2: Map<String, Any?>): Map<String, Any?> {
    val acc: MutableMap<String, Any?> = m1.toMutableMap()
    m2.forEach { (k, v) ->
        acc[k] = when {
            acc.containsKey(k) -> mergeEntries(acc[k], v)
            else -> v
        }
    }
    return acc
}

fun mergeMapsFold(m1: Map<String, Any?>, m2: Map<String, Any?>) =
    m2.entries.fold(m1) { acc, it ->
        acc.map { (k, v) ->
            k to when (it.key) {
                in acc.keys -> mergeEntries(v, it.value)
                else -> it.value
            }
        }.toMap()
    }


fun mergeEntries(e1: Any?, e2: Any?): Any? {
    if (e1 == null) return e2
    if (e2 == null) return e1
    val result = when (e1) {
        is Map<*, *> -> mergeMapsFold(e1 as Map<String, Any?>, e2 as Map<String, Any?>)
        is Array<*> -> e1
        else -> e1
    }
    return result
}


fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}