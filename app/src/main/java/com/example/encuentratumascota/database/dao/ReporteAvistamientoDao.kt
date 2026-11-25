import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReporteAvistamientoDao {
    @Insert
    suspend fun insertar(avistamiento: ReporteAvistamiento): Long

    @Delete
    suspend fun eliminar(avistamiento: ReporteAvistamiento)

    @Query("SELECT * FROM reporte_avistamiento WHERE id_extravio = :idExtravio ORDER BY fecha_hora DESC")
    fun obtenerPorExtravio(idExtravio: Int): Flow<List<ReporteAvistamiento>>

    @Query("SELECT * FROM reporte_avistamiento WHERE id_usuario = :idUsuario ORDER BY fecha_hora DESC")
    fun obtenerPorUsuario(idUsuario: String): Flow<List<ReporteAvistamiento>>
}