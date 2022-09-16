package com.rocketteam.d3vs.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\'J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\'J+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0017\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\'\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\'J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\'\u00a8\u0006\u001b"}, d2 = {"Lcom/rocketteam/d3vs/db/TutorDAO;", "", "()V", "delete", "", "Tutor", "Lcom/rocketteam/d3vs/db/entities/Tutor;", "Id", "", "findByEmail", "Lcom/rocketteam/d3vs/db/entities/UsuarioTutor;", "Email", "", "findById", "insert", "", "Usuario", "Lcom/rocketteam/d3vs/db/entities/Usuario;", "Qualificacoes", "", "Lcom/rocketteam/d3vs/db/entities/Qualificacoes;", "(Lcom/rocketteam/d3vs/db/entities/Tutor;Lcom/rocketteam/d3vs/db/entities/Usuario;[Lcom/rocketteam/d3vs/db/entities/Qualificacoes;)V", "([Lcom/rocketteam/d3vs/db/entities/Qualificacoes;)[Ljava/lang/Long;", "listAll", "", "update", "updateUsuario", "app_debug"})
public abstract class TutorDAO {
    
    public TutorDAO() {
        super();
    }
    
    @androidx.room.Transaction()
    public void insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Tutor Tutor, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Qualificacoes[] Qualificacoes) {
    }
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Tutor Tutor);
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Insert()
    public abstract java.lang.Long[] insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Qualificacoes[] Qualificacoes);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Tutor Tutor);
    
    @androidx.room.Query(value = "delete from t_prof where t_user_id_user = :Id")
    @androidx.room.Transaction()
    public abstract void delete(int Id);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Tutor Tutor);
    
    @androidx.room.Update()
    public abstract void updateUsuario(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from t_user, t_prof where id_user = :Id and discriminacao = \'prof\'")
    public abstract com.rocketteam.d3vs.db.entities.UsuarioTutor findById(int Id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from t_user u inner join t_prof a on (a.t_user_id_user = u.id_user) where ds_email = :Email and discriminacao = \'prof\'")
    public abstract com.rocketteam.d3vs.db.entities.UsuarioTutor findByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String Email);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from t_user, t_prof where discriminacao = \'prof\'")
    public abstract java.util.List<com.rocketteam.d3vs.db.entities.UsuarioTutor> listAll();
}