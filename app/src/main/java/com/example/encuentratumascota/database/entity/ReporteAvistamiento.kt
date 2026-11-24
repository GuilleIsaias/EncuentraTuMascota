import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.Index
import androidx.room3.PrimaryKey

@Entity(
    tableName = "reporte_avistamiento",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id_usuario"],
            childColumns = ["id_usuario"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ReporteExtravio::class,
            parentColumns = ["id_extravio"],
            childColumns = ["id_extravio"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_usuario"]),
        Index(value = ["id_extravio"])
    ]
)
data class ReporteAvistamiento(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_avistamiento")
    val idAvistamiento: Int = 0,
    @ColumnInfo(name = "id_usuario")
    val idUsuario: Int,
    @ColumnInfo(name = "id_extravio")
    val idExtravio: Int,
    @ColumnInfo(name = "fecha_hora")
    val fechaHora: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "ruta_fotografia")
    val rutaFotografia: String? = null,
    val longitud: Double,
    val latitud: Double,
    val comentario: String
)