package com.rocketteam.d3vs.db

import androidx.room.*
import com.rocketteam.d3vs.db.entities.*

@Dao
abstract class TutorDAO {

    @Transaction
    open fun insert(Tutor: Tutor, Usuario: Usuario, Qualificacoes: Array<Qualificacoes>) {
        val id = insert(Usuario);

        Tutor.Id = id.toInt();
        insert(Tutor);

        Qualificacoes.forEach {
            it.IdTutor = id.toInt();
        }
        insert(Qualificacoes);
    }

    @Insert
    abstract fun insert(Tutor: Tutor): Long

    @Insert
    abstract fun insert(Usuario: Usuario): Long

    @Insert
    abstract fun insert(Qualificacoes: Array<Qualificacoes>): Array<Long>

    @Delete
    abstract fun delete(Tutor: Tutor)

    @Transaction
    @Query("delete from t_prof where t_user_id_user = :Id")
    abstract fun delete(Id: Int)

    @Update
    abstract fun update(Tutor: Tutor)

    @Update
    abstract fun updateUsuario(Usuario: Usuario)

    @Query("select * from t_user, t_prof where id_user = :Id")
    abstract fun findById(Id: Int) : UsuarioTutor

    @Query("select * from t_user, t_prof")
    abstract fun listAll(): List<UsuarioTutor>

}

@Dao
abstract class AlunoDAO {

    @Transaction
    open fun insert(Aluno: Aluno, Usuario: Usuario, Interesses: Interesses){

    }

    @Transaction
    @Delete
    abstract fun delete(Aluno: Aluno)

    @Transaction
    @Query("delete from t_aluno where t_user_id_user = :Id")
    abstract fun delete(Id: Int)

    @Update
    abstract fun update(Aluno: Aluno)

    @Update
    abstract fun updateUsuario(Usuario: Usuario)

    @Transaction
    @Query("select * from t_user, t_aluno where id_user = :Id")
    abstract fun findById(Id: Int): UsuarioAluno

    @Transaction
    @Query("select * from t_user, t_aluno")
    abstract fun listAll(): Array<UsuarioAluno>?

}