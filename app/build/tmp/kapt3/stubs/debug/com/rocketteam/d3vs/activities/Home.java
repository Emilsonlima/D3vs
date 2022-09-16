package com.rocketteam.d3vs.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001aH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/rocketteam/d3vs/activities/Home;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "actualFragment", "", "bottomNavigation", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "db", "Lcom/rocketteam/d3vs/db/D3vsDataBase;", "fragmentContainer", "Landroid/view/ViewGroup;", "historicfragment", "Lcom/rocketteam/d3vs/activities/fragments/HistoricFragment;", "lblEmail", "Landroid/widget/TextView;", "lblIdade", "lblInteresses", "lblUsuario", "perfil", "Lcom/rocketteam/d3vs/db/entities/UsuarioAluno;", "calcIdade", "date", "Ljava/time/LocalDate;", "homeFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "replaceFragment", "fragment", "Companion", "app_debug"})
public final class Home extends androidx.appcompat.app.AppCompatActivity {
    private final com.rocketteam.d3vs.activities.fragments.HistoricFragment historicfragment = null;
    private com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigation;
    private int actualFragment = 0;
    private android.view.ViewGroup fragmentContainer;
    private android.widget.TextView lblUsuario;
    private android.widget.TextView lblInteresses;
    private android.widget.TextView lblEmail;
    private android.widget.TextView lblIdade;
    private com.rocketteam.d3vs.db.entities.UsuarioAluno perfil;
    private com.google.android.gms.auth.api.signin.GoogleSignInAccount account;
    private com.rocketteam.d3vs.db.D3vsDataBase db;
    @org.jetbrains.annotations.NotNull()
    public static final com.rocketteam.d3vs.activities.Home.Companion Companion = null;
    
    public Home() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final androidx.fragment.app.Fragment homeFragment() {
        return null;
    }
    
    private final int calcIdade(java.time.LocalDate date) {
        return 0;
    }
    
    private final void replaceFragment(androidx.fragment.app.Fragment fragment) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/rocketteam/d3vs/activities/Home$Companion;", "", "()V", "newInstance", "Landroid/content/Intent;", "Context", "Landroid/content/Context;", "Email", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent newInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context Context, @org.jetbrains.annotations.NotNull()
        java.lang.String Email) {
            return null;
        }
    }
}