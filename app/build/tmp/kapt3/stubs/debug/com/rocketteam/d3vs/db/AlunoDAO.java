package com.rocketteam.d3vs.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\'J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\'J+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0017\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\'J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\'\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001cH\'J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\'\u00a8\u0006\u001f"}, d2 = {"Lcom/rocketteam/d3vs/db/AlunoDAO;", "", "()V", "autenticar", "", "GoogleAuth", "", "Email", "Senha", "delete", "", "Aluno", "Lcom/rocketteam/d3vs/db/entities/Aluno;", "Id", "", "findByEmail", "Lcom/rocketteam/d3vs/db/entities/UsuarioAluno;", "findById", "insert", "", "Usuario", "Lcom/rocketteam/d3vs/db/entities/Usuario;", "Interesses", "", "Lcom/rocketteam/d3vs/db/entities/Interesses;", "(Lcom/rocketteam/d3vs/db/entities/Aluno;Lcom/rocketteam/d3vs/db/entities/Usuario;[Lcom/rocketteam/d3vs/db/entities/Interesses;)V", "([Lcom/rocketteam/d3vs/db/entities/Interesses;)[Ljava/lang/Long;", "listAll", "", "update", "updateUsuario", "app_debug"})
public abstract class AlunoDAO {
    
    public AlunoDAO() {
        super();
    }
    
    @androidx.room.Transaction()
    public void insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno Aluno, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Interesses[] Interesses) {
    }
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno Aluno);
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Insert()
    public abstract java.lang.Long[] insert(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Interesses[] Interesses);
    
    @androidx.room.Delete()
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
    public abstract com.rocketteam.d3vs.db.entities.UsuarioAluno findById(int Id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) where ds_email = :Email and discriminacao = \'aluno\'")
    public abstract com.rocketteam.d3vs.db.entities.UsuarioAluno findByEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String Email);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from t_user, t_aluno")
    public abstract java.util.List<com.rocketteam.d3vs.db.entities.UsuarioAluno> listAll();
    
    @androidx.room.Query(value = "select count(*) from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) where ds_email = :Email and ds_senha = :Senha and discriminacao = \'aluno\'")
    public abstract boolean autenticar(@org.jetbrains.annotations.NotNull()
    java.lang.String Email, @org.jetbrains.annotations.NotNull()
    java.lang.String Senha);
    
    @androidx.room.Query(value = "select count(*) from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) where googleauth = :GoogleAuth and discriminacao = \'aluno\'")
    public abstract boolean autenticar(@org.jetbrains.annotations.NotNull()
    java.lang.String GoogleAuth);
}