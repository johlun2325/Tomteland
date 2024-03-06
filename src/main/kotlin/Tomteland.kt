/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"

Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)

Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"

För att bli godkänd på uppgiften måste du använda rekursion.

 */

class Tomteland {

    //under skumtomten
    val dammråttan = Tomte("Dammråttan", listOf())

    //under trötter
    val skumtomten = Tomte("Skumtomten", listOf(dammråttan))

    //under glader
    val blyger = Tomte("Blyger", listOf())
    val tröger = Tomte("Tröger", listOf())
    val trötter = Tomte("Trötter", listOf(skumtomten))

    //under myran
    val bladlusen = Tomte("Bladlusen", listOf())

    //under räven
    val gråsuggan = Tomte("Gråsuggan", listOf())
    val myran = Tomte("Myran", listOf(bladlusen))

    //under butter
    val rådjuret = Tomte("Rådjuret", listOf())
    val nyckelpigan = Tomte("Nyckelpigan", listOf())
    val haren = Tomte("Haren", listOf())
    val räven = Tomte("Räven", listOf(gråsuggan, myran))

    //under tomten
    val butter = Tomte("Butter", listOf(rådjuret, nyckelpigan, haren, räven))
    val glader = Tomte("Glader", listOf(blyger, tröger, trötter))

    val tomten = Tomte("Tomten", listOf(butter, glader))


    val listOfAllTomtar = listOf(
        tomten, butter, glader, blyger, tröger, trötter,
        skumtomten, dammråttan, rådjuret, nyckelpigan,
        haren, räven, gråsuggan, myran, bladlusen
    )

    fun getAllTomtar() = listOfAllTomtar


    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande


    fun getUnderlings(currentName: String, tomtar: List<Tomte>): Set<String> {
        val emptyList = mutableSetOf<String>()

        fun collectUnderlings(
            underlingNames: Set<String>,
            underlingsToSearchFor: List<String>
        ): Set<String> {
            if (underlingsToSearchFor.isEmpty()) return underlingNames.toSet()

            val filteredUnderlings =
                tomtar.filter { e -> e.name in underlingsToSearchFor } //tomtelista, bara de so skickades in
            val underlingHasUnderlings =
                filteredUnderlings.flatMap { tomte -> tomte.underlings.map { it.name } }
                    .toList() //alla tomtarnas underlingar, från filtered
            val allCollectedUnderlings = underlingNames.toMutableList().apply { addAll(underlingHasUnderlings) }.toSet()
            return collectUnderlings(allCollectedUnderlings, underlingHasUnderlings)

        }

        return collectUnderlings(emptyList, listOf(currentName))
    }

}


fun main(args: Array<String>) {
    val tomteland = Tomteland()
    val tomtar = tomteland.getAllTomtar()

    while (true) {
        println("Vilken tomte vill du söka på?\n")
        val namn = readln()

        val result = tomteland.getUnderlings(namn, tomtar)

        if (result.isNotEmpty())
            println("Underordnade: $result \n")
        else
            println("Denna tomte har inga underordnade.\n")
    }

}

