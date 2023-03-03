import kotlin.test.Test
import kotlin.test.assertEquals

class MergeTest {

    private val m1 = mapOf(
        "field1" to "value",
        "field2" to mapOf("field_internal" to 5),
        "field3" to listOf(1, 3, 4),
        "field4" to null,
        "field5" to listOf(2)
    )

    private val m2 = mapOf(
        "field2" to mapOf("field_internal" to 4),
        "field4" to mapOf("field_internal2" to 5),
        "field5" to listOf(1, 3, 4),
        "field6" to null,
        "field7" to true
    )

    private val expected12 = mapOf(
        "field1" to "value",
        "field2" to mapOf("field_internal" to 5),
        "field3" to listOf(1, 3, 4),
        "field4" to mapOf("field_internal2" to 5),
        "field5" to listOf(2),
        "field6" to null,
        "field7" to true
    )




    @Test
    fun `should give empty for an empty JSON`() {
        val result = mergeMaps(m1, m2)
        result.forEach { (k, v) -> println("$k -> $v") }
        assertEquals(expected12, result)
    }

}