//package com.example.uijp.gulaDarah.Dao
//
//import androidx.room.*
//import dev.codcow.guladarahapps.dataModel.GulaDarah
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface GulaDarahDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(gulaDarah: GulaDarah)
//
//    @Query("SELECT * FROM gula_darah ORDER BY date DESC, time DESC")
//    fun getAllFlow(): Flow<List<GulaDarah>>
//
//    @Delete
//    suspend fun delete(gulaDarah: GulaDarah)
//}
