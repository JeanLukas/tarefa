package com.tarefa.tarefa.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.websocket.server.PathParam



@RestController
@CrossOrigin
class PessoasController {

    companion object {
        const val ENDPOINT_PESSOA = "/api/pessoaController"
    }


    //teste 01
    @GetMapping("${ENDPOINT_PESSOA}/pessoa")
    fun helloPessoa(): ResponseEntity<Any> {
        val pessoa = Pessoa()
        pessoa.nome = "Douglas"
        pessoa.id = 22L
        pessoa.endereco = "Rua Joao Pessoa"
        return ResponseEntity.ok(pessoa)
    }

    //teste 03
    @GetMapping("/teste003")
    fun helloListaPessoa(): ResponseEntity<Any> {
        val pessoa1 = Pessoa()
        pessoa1.nome = "Livia"
        pessoa1.id = 33L
        pessoa1.endereco = "Avenida Salgado filho"
        val pessoa2 = Pessoa()
        pessoa2.nome = "Luciano"
        pessoa2.id = 87L
        pessoa2.endereco = "Avenida flores"
        val pessoa3 = Pessoa()
        pessoa3.nome = "Flavio"
        pessoa3.id = 99L
        pessoa3.endereco = "Beira do Rio"
        val pessoa4 = Pessoa()
        pessoa4.nome = "Edmar"
        pessoa4.id = 89L
        pessoa4.endereco = "Beira do Rio1"
        val listaPessoas = arrayListOf(pessoa1, pessoa2, pessoa3, pessoa4)
            val tf = listaPessoas.forEach {
            println(it.nome +
                    it.id +
                    it.endereco)
        }

        return ResponseEntity.ok(tf)
    }

    @GetMapping("/testando")
    fun tryingFors() : ResponseEntity<Any>{
        val listando = mutableListOf<Pessoa>()
        var lon = 1
        val i =  40L
        val j = " e Joao"
        val name = "Cleison"
        val ender = "rua posto ipiranga"
        while (lon <= 30){
            val p = Pessoa()
            p.id = i
            p.nome = name + j
            p.endereco = ender
            listando.add(p)
            lon++
            println("passou $lon")
        }
         val tt= listando.forEach {
             println(it.nome +
                     it.id +
                     it.endereco)
         }
        return ResponseEntity.ok(listando + tt)
    }




    @GetMapping("/teste004")
    fun test()  : ResponseEntity<Any> {
        val list = mutableListOf<Pessoa>()
        var i = 1L
        val j = "Cleber"
        while (i <= 10L) {
            println("Line $i")
            val pessoa = Pessoa()
            pessoa.id = i
            //pessoa.endereco = "Endereço $i"
            pessoa.nome = j
            list.add(pessoa)

            ++i
        }
        return ResponseEntity.ok(list)
    }

        //teste 03
        @PostMapping("/test")
        fun testOne(@RequestBody pessoa: Pessoa): ResponseEntity<Any> {
                    return ResponseEntity.ok(pessoa)
        }


        //teste 04
        @PutMapping("/teste5")
        fun testeFi(@RequestBody pessoa: Pessoa): ResponseEntity<Any> {
                return try{
                    throw IllegalArgumentException("erro")
                    ResponseEntity.ok(pessoa)
                }catch (e: Exception){
                    e.printStackTrace()
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body("Erro")
                }

        }



        //teste 06
        @GetMapping("/teste02")
        fun testT(
            @RequestParam("nome", defaultValue = "Anderson") nome: String,
            @RequestParam("sobrenome", defaultValue = "Silva") sobrenome: String
        ): ResponseEntity<Any> {
            return ResponseEntity.ok(nome + sobrenome)
        }

        //teste07
        @GetMapping("/teste/{id}")
        fun opaName(@PathVariable("id") id: Long): ResponseEntity<Any> {
            val name = "Cristina"
            val test = "Opa ${name}, tudo certo?"

            return try {
                println("rolou")
                return ResponseEntity.ok(test)
            }catch (e: Exception){
                e.printStackTrace()
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body("id nulo")
            }
        }

        //teste 08
        @DeleteMapping("/teste/{id}")
        fun delete(@PathVariable("id") id: Long): ResponseEntity<Any> {
            return ResponseEntity.ok("deletado")
        }

        //teste 09
        @DeleteMapping("/del")
        fun deletee(
            @RequestParam("id", defaultValue = 12.toString()) id: Int,
            @RequestParam("preco", defaultValue = 90.99.toString()) preco: Double
        ): ResponseEntity<Any> {
            return ResponseEntity.ok("Deletado!!!!!")
        }

        //teste 10
        @DeleteMapping("/testando/{id}")
        fun remove(@PathParam("id") id: Long?): ResponseEntity<String> {

            return ResponseEntity.ok("Deletado!!!${id}")
        }

    }

    class Pessoa {
        var nome: String = ""
        var id = 0L
        var endereco: String = ""
    }


