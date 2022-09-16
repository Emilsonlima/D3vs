package com.rocketteam.d3vs.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/rocketteam/d3vs/activities/Login;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btEntrar", "Landroid/widget/Button;", "btGoogle", "Lcom/google/android/gms/common/SignInButton;", "db", "Lcom/rocketteam/d3vs/db/D3vsDataBase;", "edtEmail", "Landroid/widget/EditText;", "edtSenha", "gso", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getGso", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "setGso", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;)V", "toolBar2", "Landroidx/appcompat/widget/Toolbar;", "btEntrarOnClick", "", "it", "Landroid/view/View;", "btGoogleOnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_debug"})
public final class Login extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.EditText edtSenha;
    private android.widget.EditText edtEmail;
    private com.google.android.gms.common.SignInButton btGoogle;
    private android.widget.Button btEntrar;
    private androidx.appcompat.widget.Toolbar toolBar2;
    private com.rocketteam.d3vs.db.D3vsDataBase db;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.auth.api.signin.GoogleSignInOptions gso;
    
    public Login() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.auth.api.signin.GoogleSignInOptions getGso() {
        return null;
    }
    
    public final void setGso(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.auth.api.signin.GoogleSignInOptions p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void btGoogleOnClick(android.view.View it) {
    }
    
    private final void btEntrarOnClick(android.view.View it) {
    }
}