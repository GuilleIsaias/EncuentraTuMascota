import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import androidx.room3.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(usuario: Usuario)

    @Update
    suspend fun actualizar(usuario: Usuario)

    @Delete
    suspend fun eliminar(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE email = :email LIMIT 1")
    suspend fun obtenerPorEmail(email: String): Usuario?

    @Query("SELECT * FROM usuarios WHERE id_usuario = :idUsuario LIMIT 1")
    suspend fun obtenerPorId(idUsuario: Int): Usuario?

    @Query("SELECT MAX(id_usuario) FROM usuarios")
    suspend fun obtenerUltimoId(): Int?

    @Query("SELECT * FROM usuarios")
    fun obtenerTodos(): Flow<List<Usuario>>
}