import kotlin.test.Test
import kotlin.test.assertEquals

class SimpleExtractorTest {

    private val m1 = mapOf(
        "field1" to 2,
        "field2" to 3
    )

    private val m2 = mapOf(
        "field2" to 4,
        "field3" to "hell"
    )

    private val expected12 = mapOf(
        "field1" to 2,
        "field2" to 3,
        "field3" to "hell",
    )




    @Test
    fun `should give empty for an empty JSON`() {
        val result = mergeMaps(m1, m2)
        result.forEach { (k, v) -> println("$k -> $v") }
        assertEquals(expected12, result)
    }

}