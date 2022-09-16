package com.rocketteam.d3vs.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010\'\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020#H\u0014J\b\u0010,\u001a\u00020#H\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lcom/rocketteam/d3vs/activities/Cadastro;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "RC_SIGN_IN", "", "getRC_SIGN_IN", "()I", "btEntrar", "Landroid/widget/Button;", "getBtEntrar", "()Landroid/widget/Button;", "setBtEntrar", "(Landroid/widget/Button;)V", "btGoogle", "Lcom/google/android/gms/common/SignInButton;", "getBtGoogle", "()Lcom/google/android/gms/common/SignInButton;", "setBtGoogle", "(Lcom/google/android/gms/common/SignInButton;)V", "edtEmail", "Landroid/widget/EditText;", "getEdtEmail", "()Landroid/widget/EditText;", "setEdtEmail", "(Landroid/widget/EditText;)V", "edtSenha", "getEdtSenha", "setEdtSenha", "gso", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getGso", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "setGso", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;)V", "GoogleSign", "", "btEntrarOnClick", "it", "Landroid/view/View;", "btGoogleOnClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "app_debug"})
public final class Cadastro extends androidx.appcompat.app.AppCompatActivity {
    private final int RC_SIGN_IN = 2;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Button btEntrar;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.common.SignInButton btGoogle;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText edtEmail;
    @org.jetbrains.annotations.Nullable()
    private android.widget.EditText edtSenha;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.auth.api.signin.GoogleSignInOptions gso;
    
    public Cadastro() {
        super();
    }
    
    public final int getRC_SIGN_IN() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.Button getBtEntrar() {
        return null;
    }
    
    public final void setBtEntrar(@org.jetbrains.annotations.Nullable()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.common.SignInButton getBtGoogle() {
        return null;
    }
    
    public final void setBtGoogle(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.common.SignInButton p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText getEdtEmail() {
        return null;
    }
    
    public final void setEdtEmail(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.EditText getEdtSenha() {
        return null;
    }
    
    public final void setEdtSenha(@org.jetbrains.annotations.Nullable()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.auth.api.signin.GoogleSignInOptions getGso() {
        return null;
    }
    
    public final void setGso(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.auth.api.signin.GoogleSignInOptions p0) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void btEntrarOnClick(android.view.View it) {
    }
    
    private final void btGoogleOnClick(android.view.View it) {
    }
    
    private final void GoogleSign() {
    }
}