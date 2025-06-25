import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.Receita

@Dao
interface ReceitaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(receita: Receita)

    @Delete
    suspend fun deletar(receita: Receita)

    @Query("SELECT * FROM receitas ORDER BY id DESC")
    fun listarTodas(): LiveData<List<Receita>>

    @Query("DELETE FROM receitas")
    suspend fun deletarTudo()
}
