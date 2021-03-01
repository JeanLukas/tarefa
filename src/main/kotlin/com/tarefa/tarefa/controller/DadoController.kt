package com.tarefa.tarefa.controller


import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

class DadoController {

    class Dado {
        var tipo: String = ""
        var id: Int = 0
        var codigo: Long = 0L
        var preco: Double = 0.00
        var lugar: String = ""
        var numero: Int = 0

    }
    //teste 03
    @GetMapping("/inter/gols")
    fun helloListaPessoa1(): ResponseEntity<Any> {
        val lista = Dado()
        lista.tipo = "comida"
        lista.id = 32
        lista.codigo = 232454353534534L
        lista.preco = 12.0
        lista.lugar = "açogue"
        lista.numero = 2
        val lista1 = Dado()
        lista1.tipo = "acessórios"
        lista1.id = 2
        lista1.codigo = 455665776L
        lista1.preco = 67.0
        lista1.lugar = "loja"
        lista1.numero = 10
        val lista2 = Dado()
        lista2.tipo = "aparelhos"
        lista2.id = 9
        lista2.codigo = 999999L
        lista2.preco = 122.0
        lista2.lugar = "Apple"
        lista2.numero = 10
        val lista3 = Dado()
        lista3.tipo = "roupa"
        lista3.id = 90
        lista3.codigo = 88L
        lista3.preco = 1666.0
        lista3.lugar = "SpaLojas"
        lista3.numero = 87
        val lista4 = Dado()
        lista4.tipo = "comida"
        lista4.id = 56
        lista4.codigo = 66L
        lista4.preco = 90.0
        lista4.lugar = "padaria"
        lista4.numero = 9
        val lista5 = Dado()
        lista5.tipo = "PC"
        lista5.id = 65
        lista5.codigo = 344L
        lista5.preco = 400.66
        lista5.lugar = "Pichau"
        lista5.numero = 34
        val lista6 = Dado()
        lista6.tipo = "Pessoas"
        lista6.id = 10
        lista6.codigo = 999988L
        lista6.preco = 90000.999
        lista6.lugar = "praça"
        lista6.numero = 100
        val lista7 = Dado()
        lista7.tipo = "aglomeração"
        lista7.id = 666
        lista7.codigo = 404L
        lista7.preco = 99.80
        lista7.lugar = "festa"
        lista7.numero = 23
        val lista8 = Dado()
        lista8.tipo = "comida"
        lista8.id = 45
        lista8.codigo = 543455212L
        lista8.preco = 70.90
        lista8.lugar = "doceria"
        lista8.numero = 29



        val listaLista = arrayListOf(lista, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8)

        val testeFor = listaLista.forEach{
            println(it.tipo + it.id + it.codigo + it.preco + it.lugar + it.numero)
        }
        return ResponseEntity.ok(testeFor)
    }

@GetMapping("/testeDados")
fun testeDados() : ResponseEntity<Any>{
    val listaaaaa = mutableListOf<Dado>()
    val j = "Brinquedos"
    var i = 1
    val ind = 123
    val c = 11223
    val p = 30.00
    val l = "Loja de brinquedos"
    val n = 10
    while (i <= 40){
        val d = Dado()
        d.tipo = j
        d.id = ind
        d.codigo = c.toLong()
        d.preco = p
        d.lugar = l
        d.numero = n
        listaaaaa.add(d)
        println("passou $i")
        i++
    }

    return ResponseEntity.ok(listaaaaa)
}
    //teste 03
    @PostMapping("/inter/novo/gol")
    fun interGols(@RequestBody dado: Dado): ResponseEntity<Any> {
        return ResponseEntity.ok(dado)
    }


    //teste 05
    @PutMapping("/teste4")
    fun testeF(@RequestBody dado: Dado): ResponseEntity<Any> {

        return ResponseEntity.ok(dado)
    }
}