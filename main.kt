import java.util.ArrayList

fun main() {
    val ville1 = Ville("Marrakech", arrayListOf(Attraction.MEDINA, Attraction.MONTAGNE, Attraction.SAHARA))
    val ville2 = Ville("Khouribga", arrayListOf(Attraction.MEDINA, Attraction.MONTAGNE))

    val circuit1 = Circuit(1, "Circuit au Maroc", 7500.0, arrayListOf(ville1, ville2))
    val circuit2 = Circuit(2, "Circuit au Maroc Plus", 9000.0, arrayListOf(ville1, ville2))

    if (circuit1.ajouterCircuit(ville1))
        println("ville1 bien ajoutée au Circuit 1")
    else
        println("ville1 existe déjà dans le Circuit 1")

    val lstCircuit = arrayListOf(circuit1, circuit2)

    println("Le prix max est: " + lstCircuit.maxOf { it.prix })

    println("Circuits avec un prix > 8000 Dhs:")
    lstCircuit.filter { it.prix > 8000 }.forEach { it.afficherCircuit() }
}
