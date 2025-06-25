import androidx.lifecycle.LiveData
import com.example.myapplication.Receita

class ReceitaRepository(private val dao: ReceitaDao) {
    val todasReceitas: LiveData<List<Receita>> = dao.listarTodas()

    suspend fun inserir(receita: Receita) {
        dao.inserir(receita)
    }

    suspend fun deletar(receita: Receita) {
        dao.deletar(receita)
    }

    suspend fun deletarTudo() {
        dao.deletarTudo()
    }
}
