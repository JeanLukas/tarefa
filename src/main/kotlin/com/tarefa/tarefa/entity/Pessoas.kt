package com.tarefa.tarefa.entity.pessoas

import javax.persistence.*

@Entity
@Table(name = "db_pessoa")
class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_pessoa")
    @SequenceGenerator(name = "db_pessoa", sequenceName = "db_pessoa", allocationSize = 1)
    var id: Long? = null

    @Column(name = "pessoa_name")
    var name: String = ""

    @Column(name = "pessoa_endereco")
    var endereco: String = ""

}

