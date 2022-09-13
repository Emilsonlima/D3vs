package com.rocketteam.d3vs.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "t_aula",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id_user"],
            childColumns = ["t_aluno_t_user_id_user"]
        ),
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id_user"],
            childColumns = ["t_prof_t_user_id_user"]
        )
    ]
)
data class Aula(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id_aula") var Id: Int = 0,
                @ColumnInfo(name = "t_aluno_t_user_id_user") var IdAluno: Int = 0,
                @ColumnInfo(name = "t_prof_t_user_id_user") var IdTutor: Int = 0
)