package com.rocketteam.d3vs.db.entities

import androidx.room.Embedded
import androidx.room.Relation

data class UsuarioTutor (@Embedded var Tutor: Tutor,
                         @Relation(
                             parentColumn = "t_user_id_user",
                             entityColumn = "id_user"
                         )
                         var Usuario: Usuario,
                         @Relation(
                            parentColumn = "t_user_id_user",
                            entityColumn = "t_prof_t_user_id_user"
                         )
                         var Qualificacoes: List<Qualificacoes>)

data class UsuarioAluno (@Embedded var Aluno: Aluno,
                         @Relation(
                             parentColumn = "t_user_id_user",
                             entityColumn = "id_user"
                         )
                         var Usuario: Usuario,
                         @Relation(
                             parentColumn = "t_user_id_user",
                             entityColumn = "t_aluno_t_user_id_user"
                         )
                         var Interesses: List<Interesses>)