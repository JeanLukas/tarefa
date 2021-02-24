package com.tarefa.tarefa.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

import org.springframework.web.bind.annotation.PathVariable

import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.websocket.server.PathParam
import kotlin.reflect.jvm.internal.ReflectProperties


@RestController
@CrossOrigin
class PessoasController {

    companion object {
        const val ENDPOINT_PESSOA = "/api/pessoaController"
        const val ENDPOINT_JSON = "/lista"

    }

    //teste 01
    @GetMapping("${ENDPOINT_PESSOA}/pessoa")
    fun helloPessoa(): ResponseEntity<Any> {
        var pessoa = Pessoa()
        pessoa.nome = "Douglas"
        pessoa.id = 22L
        pessoa.endereco = "Rua Joao Pessoa"
        return ResponseEntity.ok(pessoa)
        val listaPessoas = arrayListOf(pessoa)
    }

    //teste 03
    @GetMapping("${ENDPOINT_JSON}")
    fun helloListaPessoa(): ResponseEntity<Any> {
        var pessoa1 = Pessoa()
        pessoa1.nome = "Livia"
        pessoa1.id = 33L
        pessoa1.endereco = "Avenida Salgado filho"
        var pessoa2 = Pessoa()
        pessoa2.nome = "Luciano"
        pessoa2.id = 87L
        pessoa2.endereco = "Avenida flores"
        var pessoa3 = Pessoa()
        pessoa3.nome = "Flavio"
        pessoa3.id = 99L
        pessoa3.endereco = "Beira do Rio"
        var pessoa4 = Pessoa()
        pessoa4.nome = "Edmar"
        pessoa4.id = 89L
        pessoa4.endereco = "Beira do Rio1"
        val listaPessoas = arrayListOf(pessoa1, pessoa2, pessoa3, pessoa4)
        return ResponseEntity.ok(listaPessoas)
    }

    //teste 03
    @GetMapping("/inter/gols")
    fun helloListaPessoa1(): ResponseEntity<Any> {
        var lista = Dado()
        lista.tipo = "comida"
        lista.id = 32
        lista.codigo = 232454353534534L
        lista.preco = 12.0
        lista.lugar = "açogue"
        lista.numero = 2
        var lista1 = Dado()
        lista1.tipo = "acessórios"
        lista1.id = 2
        lista1.codigo = 455665776L
        lista1.preco = 67.0
        lista1.lugar = "loja"
        lista1.numero = 10
        var lista2 = Dado()
        lista2.tipo = "aparelhos"
        lista2.id = 9
        lista2.codigo = 999999L
        lista2.preco = 122.0
        lista2.lugar = "Apple"
        lista2.numero = 10
        var lista3 = Dado()
        lista3.tipo = "roupa"
        lista3.id = 90
        lista3.codigo = 88L
        lista3.preco = 1666.0
        lista3.lugar = "SpaLojas"
        lista3.numero = 87
        var lista4 = Dado()
        lista4.tipo = "comida"
        lista4.id = 56
        lista4.codigo = 66L
        lista4.preco = 90.0
        lista4.lugar = "padaria"
        lista4.numero = 9
        var lista5 = Dado()
        lista5.tipo = "PC"
        lista5.id = 65
        lista5.codigo = 344L
        lista5.preco = 400.66
        lista5.lugar = "Pichau"
        lista5.numero = 34
        var lista6 = Dado()
        lista6.tipo = "Pessoas"
        lista6.id = 10
        lista6.codigo = 999988L
        lista6.preco = 90000.999
        lista6.lugar = "praça"
        lista6.numero = 100
        var lista7 = Dado()
        lista7.tipo = "aglomeração"
        lista7.id = 666
        lista7.codigo = 404L
        lista7.preco = 99.80
        lista7.lugar = "festa"
        lista7.numero = 23
        var lista8 = Dado()
        lista8.tipo = "comida"
        lista8.id = 45
        lista8.codigo = 543455212L
        lista8.preco = 70.90
        lista8.lugar = "doceria"
        lista8.numero = 29


        val listaLista = arrayListOf(lista, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8)
        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(listaLista)

        return ResponseEntity.ok(listaLista)
    }

    //teste 03
    @PostMapping("/inter/novo/gol")
    fun interGols(@RequestBody dado : Dado): ResponseEntity<Any> {
        return ResponseEntity.ok(dado)
    }

    //teste 03
    @PostMapping("/test")
    fun testOne( @RequestBody pessoa: Pessoa): ResponseEntity<Any> {
        return ResponseEntity.ok(pessoa)

    }


    //teste 04
    @PutMapping("/teste5")
    fun testeFi(@RequestBody pessoa : Pessoa): ResponseEntity<Any> {

        return ResponseEntity.ok(pessoa)
    }

    //teste 05
    @PutMapping("/teste4")
    fun testeF(@RequestBody dado : Dado): ResponseEntity<Any> {

        return ResponseEntity.ok(dado)
    }

    //teste 06
    @GetMapping("/teste02")
    fun testT(@RequestParam("nome", defaultValue = "Anderson") nome : String,
                @RequestParam("sobrenome", defaultValue = "Silva") sobrenome : String): ResponseEntity<Any> {

        return ResponseEntity.ok(nome + sobrenome)
    }

    //teste07
    @GetMapping("/teste/{id}")
    fun opaName(@PathVariable("id") id: Long): ResponseEntity<Any> {
        var name = "Cristina"
        var test = "Opa ${name}, tudo certo?"
        return ResponseEntity.ok(test)
    }

    //teste 08
    @DeleteMapping("/teste/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return ResponseEntity.ok("deletado")
    }

    //teste 09
    @DeleteMapping("/del")
    fun deletee(@RequestParam("id", defaultValue = 12.toString()) id: Int,
                @RequestParam("preco", defaultValue = 90.99.toString()) preco : Double): ResponseEntity<Any> {
        return ResponseEntity.ok("Deletado!!!!!")
    }

    //teste 10
    @DeleteMapping("/testando/{id}")
    fun remove(@PathParam("id") id: Long?): ResponseEntity<String> {

        return ResponseEntity.ok("Deletado!!!${id}")
    }
}

class Pessoa{
    var nome : String = ""
    var id  = 0L
    var endereco : String = ""
}
class Dado {
    var tipo : String = ""
    var id : Int = 0
    var codigo : Long = 0L
    var preco : Double = 0.00
    var lugar : String = ""
    var numero : Int = 0

}