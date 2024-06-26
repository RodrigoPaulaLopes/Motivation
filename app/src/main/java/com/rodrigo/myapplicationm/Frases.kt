package com.rodrigo.myapplicationm

import kotlin.random.Random

class Frases(val descricao: String, val id: Int)


class Data {

    private val sunny = Motivation.filter.SUNNY
    private val all = Motivation.filter.ALL
    private val infinite = Motivation.filter.INFINITE

    private val listFrases: List<Frases> = listOf(
        Frases("Não sabendo que era impossível, foi lá e fez.", infinite),
        Frases("Você não é derrotado quando perde, você é derrotado quando desiste!", infinite),
        Frases("Quando está mais escuro, vemos mais estrelas!", infinite),
        Frases(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            infinite
        ),
        Frases("Não pare quando estiver cansado, pare quando tiver terminado.", infinite),
        Frases(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            infinite
        ),
        Frases("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Frases("Você perde todas as chances que você não aproveita.", sunny),
        Frases("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Frases(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Frases("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Frases("Se você acredita, faz toda a diferença.", sunny),
        Frases("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    fun getRandomFrase(id: Int): String {

        var frase = ""
        if (id !== all) {
            val frasesFiltradas: List<Frases> = listFrases.filter {
                it.id == id
            }
            frase = frasesFiltradas[Random.nextInt(0, frasesFiltradas.size)].descricao
        }else {
            frase = listFrases[Random.nextInt(0, listFrases.size)].descricao
        }


        return frase
    }

}