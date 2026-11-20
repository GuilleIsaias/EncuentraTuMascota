import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MascotaDao {
    @Insert
    suspend fun insertar(mascota: Mascota): Long

    @Update
    suspend fun actualizar(mascota: Mascota)

    @Delete
    suspend fun eliminar(mascota: Mascota)

    @Query("SELECT * FROM mascota WHERE id_usuario = :emailUsuario ORDER BY nombre ASC")
    fun obtenerPorUsuario(emailUsuario: String): Flow<List<Mascota>>

    @Query("SELECT * FROM mascota WHERE id_mascota = :idMascota LIMIT 1")
    suspend fun obtenerPorId(idMascota: Int): Mascota?
}