//package com.example.uijp.gulaDarah.database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import dev.codcow.guladarahapps.dao.GulaDarahDao
//import dev.codcow.guladarahapps.dataModel.GulaDarah
//
//@Database(entities = [GulaDarah::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun gulaDarahDao(): GulaDarahDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "blood_sugar_db"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}
