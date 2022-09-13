package com.rocketteam.d3vs.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "t_aluno",
//    foreignKeys = [ForeignKey(
//        entity = Usuario::class,
//        parentColumns = ["id_user"],
//        childColumns = ["t_user_id_user"]
//    )]
)
data class Aluno(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "t_user_id_user") var Id: Int = 0)