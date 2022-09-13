package com.rocketteam.d3vs.db.entities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/rocketteam/d3vs/db/entities/UsuarioAluno;", "", "Aluno", "Lcom/rocketteam/d3vs/db/entities/Aluno;", "Usuario", "Lcom/rocketteam/d3vs/db/entities/Usuario;", "(Lcom/rocketteam/d3vs/db/entities/Aluno;Lcom/rocketteam/d3vs/db/entities/Usuario;)V", "getAluno", "()Lcom/rocketteam/d3vs/db/entities/Aluno;", "setAluno", "(Lcom/rocketteam/d3vs/db/entities/Aluno;)V", "getUsuario", "()Lcom/rocketteam/d3vs/db/entities/Usuario;", "setUsuario", "(Lcom/rocketteam/d3vs/db/entities/Usuario;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class UsuarioAluno {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private com.rocketteam.d3vs.db.entities.Aluno Aluno;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Relation(parentColumn = "t_user_id_user", entityColumn = "id_user")
    private com.rocketteam.d3vs.db.entities.Usuario Usuario;
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.UsuarioAluno copy(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno Aluno, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public UsuarioAluno(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno Aluno, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.Aluno component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.Aluno getAluno() {
        return null;
    }
    
    public final void setAluno(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Aluno p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.Usuario component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.Usuario getUsuario() {
        return null;
    }
    
    public final void setUsuario(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario p0) {
    }
}