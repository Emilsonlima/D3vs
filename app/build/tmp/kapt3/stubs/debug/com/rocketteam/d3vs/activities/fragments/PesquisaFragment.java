package com.rocketteam.d3vs.activities.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [PesquisaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/rocketteam/d3vs/activities/fragments/PesquisaFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/rocketteam/d3vs/activities/adapter/AdapterCard;", "descricao", "", "", "getDescricao", "()[Ljava/lang/String;", "setDescricao", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "foto", "", "getFoto", "()[I", "setFoto", "([I)V", "linguagem", "getLinguagem", "setLinguagem", "nivel", "getNivel", "setNivel", "nome", "getNome", "setNome", "recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "tutorArrayList", "Ljava/util/ArrayList;", "Lcom/rocketteam/d3vs/activities/model/CardTutor;", "Lkotlin/collections/ArrayList;", "dataInitialize", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "app_debug"})
public final class PesquisaFragment extends androidx.fragment.app.Fragment {
    private com.rocketteam.d3vs.activities.adapter.AdapterCard adapter;
    private androidx.recyclerview.widget.RecyclerView recyclerview;
    private java.util.ArrayList<com.rocketteam.d3vs.activities.model.CardTutor> tutorArrayList;
    public int[] foto;
    public java.lang.String[] nome;
    public java.lang.String[] descricao;
    public java.lang.String[] linguagem;
    public java.lang.String[] nivel;
    @org.jetbrains.annotations.NotNull()
    public static final com.rocketteam.d3vs.activities.fragments.PesquisaFragment.Companion Companion = null;
    
    public PesquisaFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getFoto() {
        return null;
    }
    
    public final void setFoto(@org.jetbrains.annotations.NotNull()
    int[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getNome() {
        return null;
    }
    
    public final void setNome(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getDescricao() {
        return null;
    }
    
    public final void setDescricao(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getLinguagem() {
        return null;
    }
    
    public final void setLinguagem(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getNivel() {
        return null;
    }
    
    public final void setNivel(@org.jetbrains.annotations.NotNull()
    java.lang.String[] p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param2 Parameter 3.
     * @param param2 Parameter 4.
     * @param param2 Parameter 5.
     * @return A new instance of fragment PesquisaFragment.
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.rocketteam.d3vs.activities.fragments.PesquisaFragment newInstance(@org.jetbrains.annotations.NotNull()
    com.rocketteam.d3vs.activities.model.CardTutor[] Tutor) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void dataInitialize() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/rocketteam/d3vs/activities/fragments/PesquisaFragment$Companion;", "", "()V", "newInstance", "Lcom/rocketteam/d3vs/activities/fragments/PesquisaFragment;", "Tutor", "", "Lcom/rocketteam/d3vs/activities/model/CardTutor;", "([Lcom/rocketteam/d3vs/activities/model/CardTutor;)Lcom/rocketteam/d3vs/activities/fragments/PesquisaFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @param param2 Parameter 3.
         * @param param2 Parameter 4.
         * @param param2 Parameter 5.
         * @return A new instance of fragment PesquisaFragment.
         */
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.rocketteam.d3vs.activities.fragments.PesquisaFragment newInstance(@org.jetbrains.annotations.NotNull()
        com.rocketteam.d3vs.activities.model.CardTutor[] Tutor) {
            return null;
        }
    }
}