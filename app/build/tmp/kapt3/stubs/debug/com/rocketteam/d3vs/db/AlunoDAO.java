package com.rocketteam.d3vs.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\'J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0015\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011H\'\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\'\u00a8\u0006\u0015"}, d2 = {"Lcom/rocketteam/d3vs/db/AlunoDAO;", "", "()V", "delete", "", "Aluno", "Lcom/rocketteam/d3vs/db/entities/Aluno;", "Id", "", "findById", "Lcom/rocketteam/d3vs/db/entities/UsuarioAluno;", "insert", "Usuario", "Lcom/rocketteam/d3vs/db/entities/Usuario;", "Interesses", "Lcom/rocketteam/d3vs/db/entities/Interesses;", "listAll", "", "()[Lcom/rocketteam/d3vs/db/entities/UsuarioAluno;", "update", "updateUsuario", "app_debug"})
public abstract class AlunoDAO {
    
    public AlunoDAO() {
        super();
    }
    
    @androidx.room.Transaction()
    public void insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno Aluno, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Interesses Interesses) {
    }
    
    @androidx.room.Delete()
    @androidx.room.Transaction()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno Aluno);
    
    @androidx.room.Query(value = "delete from t_aluno where t_user_id_user = :Id")
    @androidx.room.Transaction()
    public abstract void delete(int Id);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno Aluno);
    
    @androidx.room.Update()
    public abstract void updateUsuario(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from t_user, t_aluno where id_user = :Id")
    @androidx.room.Transaction()
    public abstract com.rocketteam.d3vs.db.entities.UsuarioAluno findById(int Id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from t_user, t_aluno")
    @androidx.room.Transaction()
    public abstract com.rocketteam.d3vs.db.entities.UsuarioAluno[] listAll();
}