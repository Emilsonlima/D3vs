package com.rocketteam.d3vs.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName="t_user")
data class Usuario(@PrimaryKey(autoGenerate=true)
                   @ColumnInfo(name="id_user") var Id: Int = 0,
                   @ColumnInfo(name="discriminacao") var Discriminacao: String,
                   @ColumnInfo(name="nm_usuario") var Nome: String,
                   @ColumnInfo(name="dt_nascimento") var DtNasc: LocalDate? = null,
                   @ColumnInfo(name="nr_cpf") var Cpf: String? = null,
                   @ColumnInfo(name="ds_email") var Email: String,
                   @ColumnInfo(name="ds_senha") var Senha: String,
                   @ColumnInfo(name="googleauth") var GoogleAuth: String? = null)