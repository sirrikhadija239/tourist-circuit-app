enum class Attraction { MEDINA, KASBAH, SAHARA, MONTAGNE }

data class Ville(
    var nom: String,
    var listeAttractions: ArrayList<Attraction>
) {
    override fun toString(): String {
        var s = "$nom, Attractions: "
        for (i in listeAttractions) {
            s += "$i "
        }
        return s
    }
}

class Circuit(
    var numero: Int,
    var description: String,
    var prix: Double,
    var listeVilles: ArrayList<Ville>
) {
    fun getNbr() = listeVilles.size

    fun ajouterCircuit(ville: Ville): Boolean {
        try {
            if (listeVilles.contains(ville))
                throw VilleExisteException()
            listeVilles.add(ville)
            return true
        } catch (e: VilleExisteException) {
            println(e.message)
            return false
        }
    }

    fun afficherCircuit() {
        println(description)
        listeVilles.forEach { println(it.toString()) }
    }
}

class VilleExisteException(msg: String = "Cette ville existe déjà") : Exception(msg)
