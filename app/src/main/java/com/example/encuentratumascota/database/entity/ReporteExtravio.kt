import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.Index
import androidx.room3.PrimaryKey

@Entity(
    tableName = "reporte_extravio",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["idUsuario"],
            childColumns = ["id_usuario"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Mascota::class,
            parentColumns = ["id_mascota"],
            childColumns = ["id_mascota"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_usuario"]),
        Index(value = ["id_mascota"])
    ]
)
data class ReporteExtravio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_extravio")
    val idExtravio: Int = 0,
    @ColumnInfo(name = "id_usuario")
    val idUsuario: Int,
    @ColumnInfo(name = "id_mascota")
    val idMascota: Int,
    @ColumnInfo(name = "fecha_hora")
    val fechaHora: Long = System.currentTimeMillis(),
    val latitud: Double,
    val longitud: Double,
    val descripcion: String,
    val estado: String = "ACTIVO"
)