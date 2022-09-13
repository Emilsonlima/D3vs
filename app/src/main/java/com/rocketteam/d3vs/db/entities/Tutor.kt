package com.rocketteam.d3vs.db.entities

import androidx.room.*

@Entity(
    tableName = "t_prof",
//    foreignKeys = [ForeignKey(
//        entity = Usuario::class,
//        parentColumns = ["id_user"],
//        childColumns = ["t_user_id_user"]
//    )]
)
data class Tutor(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name="t_user_id_user") var Id: Int = 0,
                 @ColumnInfo(name="ds_prof") var Descricao: String? = null)