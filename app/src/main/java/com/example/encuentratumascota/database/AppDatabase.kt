import androidx.room3.Database
import androidx.room3.RoomDatabase

@Database(
    entities = [
        Usuario::class,
        Mascota::class,
        ReporteExtravio::class,
        ReporteAvistamiento::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun mascotaDao(): MascotaDao
    abstract fun reporteExtravioDao(): ReporteExtravioDao
    abstract fun reporteAvistamientoDao(): ReporteAvistamientoDao
}