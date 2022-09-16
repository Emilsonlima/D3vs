package com.rocketteam.d3vs.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0017H\u0014J\b\u0010$\u001a\u00020\u0017H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/rocketteam/d3vs/activities/CriarPerfil;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "btEstudante", "Landroid/widget/Button;", "btSalvar", "btTutor", "db", "Lcom/rocketteam/d3vs/db/D3vsDataBase;", "edtCpf", "Landroid/widget/EditText;", "edtDate", "edtEmailAddress", "edtPassword", "edtPersonName", "edtQualificacao", "imagePerfil", "Landroid/widget/ImageButton;", "saved", "", "btEstudanteOnClick", "", "it", "Landroid/view/View;", "btSalvarOnClick", "btTutorOnClick", "edtDateOnLostFocus", "view", "edtQualificacaoOnFocusLost", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "Companion", "app_debug"})
public final class CriarPerfil extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.Button btSalvar;
    private android.widget.Button btTutor;
    private android.widget.Button btEstudante;
    private android.widget.ImageButton imagePerfil;
    private android.widget.EditText edtPersonName;
    private android.widget.EditText edtCpf;
    private android.widget.EditText edtDate;
    private android.widget.EditText edtQualificacao;
    private android.widget.EditText edtEmailAddress;
    private android.widget.EditText edtPassword;
    private com.rocketteam.d3vs.db.D3vsDataBase db;
    private com.google.android.gms.auth.api.signin.GoogleSignInAccount account;
    private boolean saved = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.rocketteam.d3vs.activities.CriarPerfil.Companion Companion = null;
    
    public CriarPerfil() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void edtDateOnLostFocus(android.view.View view) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void edtQualificacaoOnFocusLost(android.view.View v) {
    }
    
    private final void btSalvarOnClick(android.view.View it) {
    }
    
    private final void btTutorOnClick(android.view.View it) {
    }
    
    private final void btEstudanteOnClick(android.view.View it) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lcom/rocketteam/d3vs/activities/CriarPerfil$Companion;", "", "()V", "newInstance", "Landroid/content/Intent;", "Context", "Landroid/content/Context;", "Email", "", "Senha", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent newInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context Context, @org.jetbrains.annotations.NotNull()
        java.lang.String Email, @org.jetbrains.annotations.NotNull()
        java.lang.String Senha) {
            return null;
        }
    }
}