package com.rocketteam.d3vs.db;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.rocketteam.d3vs.db.converter.converters.class})
@androidx.room.Database(entities = {com.rocketteam.d3vs.db.entities.Usuario.class, com.rocketteam.d3vs.db.entities.Aluno.class, com.rocketteam.d3vs.db.entities.Tutor.class, com.rocketteam.d3vs.db.entities.Interesses.class, com.rocketteam.d3vs.db.entities.Qualificacoes.class, com.rocketteam.d3vs.db.entities.Aula.class}, version = 8)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/rocketteam/d3vs/db/D3vsDataBase;", "Landroidx/room/RoomDatabase;", "()V", "AlunoDAO", "Lcom/rocketteam/d3vs/db/AlunoDAO;", "TutorDAO", "Lcom/rocketteam/d3vs/db/TutorDAO;", "Companion", "app_debug"})
public abstract class D3vsDataBase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.rocketteam.d3vs.db.D3vsDataBase.Companion Companion = null;
    private static com.rocketteam.d3vs.db.D3vsDataBase Instance;
    
    public D3vsDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.rocketteam.d3vs.db.TutorDAO TutorDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.rocketteam.d3vs.db.AlunoDAO AlunoDAO();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/rocketteam/d3vs/db/D3vsDataBase$Companion;", "", "()V", "Instance", "Lcom/rocketteam/d3vs/db/D3vsDataBase;", "getInstance", "Context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.rocketteam.d3vs.db.D3vsDataBase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context Context) {
            return null;
        }
    }
}