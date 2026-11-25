import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import androidx.room3.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ReporteExtravioDao {
    @Insert
    suspend fun insertar(reporte: ReporteExtravio): Long

    @Update
    suspend fun actualizar(reporte: ReporteExtravio)

    @Delete
    suspend fun eliminar(reporte: ReporteExtravio)

    @Query("SELECT * FROM reporte_extravio WHERE estado = 'ACTIVO' ORDER BY fecha_hora DESC")
    fun obtenerActivos(): Flow<List<ReporteExtravio>>

    @Query("SELECT * FROM reporte_extravio WHERE id_usuario = :idUsuario ORDER BY fecha_hora DESC")
    fun obtenerPorUsuario(idUsuario: String): Flow<List<ReporteExtravio>>

    @Query("SELECT * FROM reporte_extravio WHERE id_extravio = :idExtravio LIMIT 1")
    suspend fun obtenerPorId(idExtravio: Int): ReporteExtravio?

    @Query("UPDATE reporte_extravio SET estado = :nuevoEstado WHERE id_extravio = :idExtravio")
    suspend fun actualizarEstado(idExtravio: Int, nuevoEstado: String)
}