package com.rocketteam.d3vs.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rocketteam.d3vs.db.converter.converters
import com.rocketteam.d3vs.db.entities.*

@Database(entities = [Usuario::class, Aluno::class, Tutor::class, Interesses::class, Qualificacoes::class, Aula::class], version = 9)
@TypeConverters(converters::class)
abstract class D3vsDataBase : RoomDatabase() {

    companion object {
        private var Instance: D3vsDataBase? = null;

        public fun getInstance(Context: android.content.Context): D3vsDataBase {
            if (Instance == null)
                Instance = Room.databaseBuilder(
                    Context,
                    D3vsDataBase::class.java,
                    "org.d3vs"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            return Instance!!
        }
    }

    abstract fun TutorDAO(): TutorDAO
    abstract fun AlunoDAO(): AlunoDAO
}