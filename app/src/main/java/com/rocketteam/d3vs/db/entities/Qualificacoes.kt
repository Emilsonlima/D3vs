package com.rocketteam.d3vs.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "t_qualificacoes",
//    foreignKeys = [ForeignKey(
//        entity = Tutor::class,
//        parentColumns = ["t_user_id_user"],
//        childColumns = ["t_prof_t_user_id_user"]
//    )]
)
data class Qualificacoes(@PrimaryKey(autoGenerate = true)
                         @ColumnInfo(name = "id_qualificacoes") var Id: Int = 0,
                         @ColumnInfo(name = "t_prof_t_user_id_user") var IdTutor: Int = 0,
                         @ColumnInfo(name = "ds_linguagem") var Linguagem: String)