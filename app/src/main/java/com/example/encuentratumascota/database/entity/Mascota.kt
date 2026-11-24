import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.Index
import androidx.room3.PrimaryKey

@Entity(
    tableName = "mascota",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id_usuario"],
            childColumns = ["id_usuario"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["id_usuario"])]
)
data class Mascota(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_mascota")
    val idMascota: Int = 0,
    @ColumnInfo(name = "id_usuario")
    val idUsuario: Int,
    val nombre: String,
    val especie: String,
    val raza: String,
    val descripcion: String,
    @ColumnInfo(name = "ruta_fotografia")
    val rutaFotografia: String? = null
)
