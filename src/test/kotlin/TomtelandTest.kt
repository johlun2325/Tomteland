import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class TomtelandTest {
    var tl: Tomteland = Tomteland()
    val listOfAll = tl.getAllTomtar()

    //correct lists to compare with
    var uTomten: List<String> = mutableListOf("Butter", "Glader", "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Blyger", "Tröger",
        "Trötter", "Skumtomten", "Gråsuggan", "Myran", "Dammråttan", "Bladlusen"
    )

    var uGlader: List<String> = mutableListOf("Blyger", "Tröger", "Trötter", "Skumtomten", "Dammråttan")

    var uButter: List<String> = mutableListOf(
        "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran",
        "Bladlusen"
    )
    var uTrötter: List<String> = mutableListOf("Skumtomten","Dammråttan")
    var uSkumtomten: List<String> = mutableListOf("Dammråttan")
    var uRäven: List<String> = mutableListOf("Gråsuggan", "Myran", "Bladlusen")
    var uMyran: List<String> = mutableListOf("Bladlusen")

    @Test
    fun getBladlusenTest() {
        val actualSize = tl.getUnderlings("Bladlusen", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getGrasugganTest() {
        val actualSize = tl.getUnderlings("Gråsuggan", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getHarenTest() {
        val actualSize = tl.getUnderlings("Haren", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getNyckelpiganTest() {
        val actualSize = tl.getUnderlings("Nyckelpigan", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getRadjuretTest() {
        val actualSize = tl.getUnderlings("Rådjuret", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getBlygerTest() {
        val actualSize = tl.getUnderlings("Blyger", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getDammrattanTest() {
        val actualSize = tl.getUnderlings("Dammråttan", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getTrogerTest() {
        val actualSize = tl.getUnderlings("Tröger", listOfAll).size
        val expectedSize = 0

        assertEquals(expectedSize, actualSize)
    }

    @Test
    fun getMyranTest() {
        val actualSize = tl.getUnderlings("Myran", listOfAll).size
        val actualValues = tl.getUnderlings("Myran", listOfAll).toList()
        val expectedSize = 1

        assertEquals(expectedSize, actualSize)
        assertEquals(uMyran, actualValues)
    }

    @Test
    fun getRavenTest() {
        val actualSize = tl.getUnderlings("Räven", listOfAll).size
        val actualValues = tl.getUnderlings("Räven", listOfAll).toList()
        val expectedSize = 3

        assertEquals(expectedSize, actualSize)
        assertEquals(uRäven, actualValues)
    }

    @Test
    fun getButterTest() {
        val actualSize = tl.getUnderlings("Butter", listOfAll).size
        val actualValues = tl.getUnderlings("Butter", listOfAll).toList()
        val expectedSize = 7

        assertEquals(expectedSize, actualSize)
        assertEquals(uButter, actualValues)
    }

    @Test
    fun getGladerTest() {
        val actualSize = tl.getUnderlings("Glader", listOfAll).size
        val actualValues = tl.getUnderlings("Glader", listOfAll).toList()
        val expectedSize = 5

        assertEquals(expectedSize, actualSize)
        assertEquals(uGlader, actualValues)
    }


    @Test
    fun getTrotterTest() {
        val actualSize = tl.getUnderlings("Trötter", listOfAll).size
        val actualValues = tl.getUnderlings("Trötter", listOfAll).toList()
        val expectedSize = 2

        assertEquals(expectedSize, actualSize)
        assertEquals(uTrötter, actualValues)
    }

    @Test
    fun getSkumtomtenTest() {
        val actualSize = tl.getUnderlings("Skumtomten", listOfAll).size
        val actualValues = tl.getUnderlings("Skumtomten", listOfAll).toList()
        val expectedSize = 1

        assertEquals(expectedSize, actualSize)
        assertEquals(uSkumtomten, actualValues)
    }

    @Test
    fun getTomtenTest() {
        val actualSize = tl.getUnderlings("Tomten", listOfAll).size
        val actualValues = tl.getUnderlings("Tomten", listOfAll).toList()
        val expectedSize = 14

        assertEquals(expectedSize, actualSize)
        assertEquals(uTomten, actualValues)
    }

}