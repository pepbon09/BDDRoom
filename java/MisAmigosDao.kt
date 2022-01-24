package com.example.basededatossql

import androidx.room.*

@Dao
interface MisAmigosDao {
    @Query("SELECT * FROM amigos")
    suspend fun getTodo(): List<MisAmigos>
    @Query("SELECT * FROM amigos WHERE identificador = :id")
    suspend fun getPorId(id: Int): MisAmigos
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(amigos: MisAmigos)
    @Query("UPDATE amigos SET nombre = :nombre, email = :email WHERE identificador = :id")
    suspend fun update(id: Int, nombre: String, email: String)
    @Query("DELETE FROM amigos WHERE identificador = :id")
    suspend fun delete(id: Int)
}
