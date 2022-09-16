package com.rocketteam.d3vs.db

import androidx.room.*
import com.rocketteam.d3vs.db.entities.*

@Dao
abstract class TutorDAO {

    @Transaction
    open fun insert(Tutor: Tutor, Usuario: Usuario, Qualificacoes: Array<Qualificacoes>) {
        Usuario.Discriminacao = "prof"
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

    @Query("select * from t_user, t_prof where id_user = :Id and discriminacao = 'prof'")
    abstract fun findById(Id: Int) : UsuarioTutor

    @Query("select * " +
            "from t_user u inner join t_prof a on (a.t_user_id_user = u.id_user) " +
            "where ds_email = :Email and discriminacao = 'prof'")
    abstract fun findByEmail(Email: String): UsuarioTutor?

    @Query("select * from t_user, t_prof where discriminacao = 'prof'")
    abstract fun listAll(): List<UsuarioTutor>

}

@Dao
abstract class AlunoDAO {

    @Transaction
    open fun insert(Aluno: Aluno, Usuario: Usuario, Interesses: Array<Interesses>) {
        Usuario.Discriminacao = "aluno"
        val id = insert(Usuario);

        Aluno.Id = id.toInt();
        insert(Aluno);

        Interesses.forEach {
            it.IdAluno = id.toInt();
        }
        insert(Interesses);
    }

    @Insert
    abstract fun insert(Aluno: Aluno): Long

    @Insert
    abstract fun insert(Usuario: Usuario): Long

    @Insert
    abstract fun insert(Interesses: Array<Interesses>): Array<Long>

    @Delete
    abstract fun delete(Aluno: Aluno)

    @Transaction
    @Query("delete from t_aluno where t_user_id_user = :Id")
    abstract fun delete(Id: Int)

    @Update
    abstract fun update(Aluno: Aluno)

    @Update
    abstract fun updateUsuario(Usuario: Usuario)

    @Query("select * from t_user, t_aluno where id_user = :Id")
    abstract fun findById(Id: Int) : UsuarioAluno

    @Query("select * " +
            "from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) " +
            "where ds_email = :Email and discriminacao = 'aluno'")
    abstract fun findByEmail(Email: String): UsuarioAluno?

    @Query("select * from t_user, t_aluno")
    abstract fun listAll(): List<UsuarioAluno>

    @Query("select count(*) " +
            "from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) " +
            "where ds_email = :Email and ds_senha = :Senha and discriminacao = 'aluno'")
    abstract fun autenticar(Email: String, Senha: String): Boolean

    @Query("select count(*) " +
            "from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) " +
            "where googleauth = :GoogleAuth and discriminacao = 'aluno'")
    abstract fun autenticar(GoogleAuth: String): Boolean

}