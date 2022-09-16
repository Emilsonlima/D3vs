package com.rocketteam.d3vs.db.converter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0017\u0010\u0003\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0007\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007H\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/rocketteam/d3vs/db/converter/converters;", "", "()V", "LocalDateToString", "", "Value", "Ljava/time/LocalDate;", "", "", "(Ljava/lang/Integer;)Z", "StringToLocalDate", "(Ljava/lang/Boolean;)I", "app_debug"})
public final class converters {
    
    public converters() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.String LocalDateToString(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate Value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public final java.time.LocalDate StringToLocalDate(@org.jetbrains.annotations.Nullable()
    java.lang.String Value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    public final int StringToLocalDate(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean Value) {
        return 0;
    }
    
    @androidx.room.TypeConverter()
    public final boolean LocalDateToString(@org.jetbrains.annotations.Nullable()
    java.lang.Integer Value) {
        return false;
    }
}