package com.rocketteam.d3vs.db.entities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/rocketteam/d3vs/db/entities/UsuarioTutor;", "", "Tutor", "Lcom/rocketteam/d3vs/db/entities/Tutor;", "Usuario", "Lcom/rocketteam/d3vs/db/entities/Usuario;", "Qualificacoes", "", "Lcom/rocketteam/d3vs/db/entities/Qualificacoes;", "(Lcom/rocketteam/d3vs/db/entities/Tutor;Lcom/rocketteam/d3vs/db/entities/Usuario;Ljava/util/List;)V", "getQualificacoes", "()Ljava/util/List;", "setQualificacoes", "(Ljava/util/List;)V", "getTutor", "()Lcom/rocketteam/d3vs/db/entities/Tutor;", "setTutor", "(Lcom/rocketteam/d3vs/db/entities/Tutor;)V", "getUsuario", "()Lcom/rocketteam/d3vs/db/entities/Usuario;", "setUsuario", "(Lcom/rocketteam/d3vs/db/entities/Usuario;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class UsuarioTutor {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Embedded()
    private com.rocketteam.d3vs.db.entities.Tutor Tutor;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Relation(parentColumn = "t_user_id_user", entityColumn = "id_user")
    private com.rocketteam.d3vs.db.entities.Usuario Usuario;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Relation(parentColumn = "t_user_id_user", entityColumn = "t_prof_t_user_id_user")
    private java.util.List<com.rocketteam.d3vs.db.entities.Qualificacoes> Qualificacoes;
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.UsuarioTutor copy(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Tutor Tutor, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario, @org.jetbrains.annotations.NotNull()
    java.util.List<com.rocketteam.d3vs.db.entities.Qualificacoes> Qualificacoes) {
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
    
    public UsuarioTutor(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Tutor Tutor, @org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Usuario Usuario, @org.jetbrains.annotations.NotNull()
    java.util.List<com.rocketteam.d3vs.db.entities.Qualificacoes> Qualificacoes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.Tutor component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rocketteam.d3vs.db.entities.Tutor getTutor() {
        return null;
    }
    
    public final void setTutor(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.db.entities.Tutor p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.rocketteam.d3vs.db.entities.Qualificacoes> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.rocketteam.d3vs.db.entities.Qualificacoes> getQualificacoes() {
        return null;
    }
    
    public final void setQualificacoes(@org.jetbrains.annotations.NotNull()
    java.util.List<com.rocketteam.d3vs.db.entities.Qualificacoes> p0) {
    }
}