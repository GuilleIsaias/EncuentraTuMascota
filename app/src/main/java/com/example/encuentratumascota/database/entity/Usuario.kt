import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.Index
import androidx.room3.PrimaryKey

@Entity(
    tableName = "usuarios",
    indices = [
        Index(value = ["id_usuario"], unique = true)
    ]
)
data class Usuario(
    @PrimaryKey
    val email: String,
    @ColumnInfo(name = "id_usuario")
    val idUsuario: Int,
    val nombre: String,
    @ColumnInfo(name = "fecha_registro")
    val fechaRegistro: Long = System.currentTimeMillis(),
    val direccion: String
)
