import android.app.Application
import androidx.lifecycle.*
import com.example.myapplication.Receita
import kotlinx.coroutines.launch

class ReceitaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ReceitaRepository
    val todasReceitas: LiveData<List<Receita>>

    init {
        val dao = AppDatabase.getDatabase(application).receitaDao()
        repository = ReceitaRepository(dao)
        todasReceitas = repository.todasReceitas
    }

    fun inserir(receita: Receita) = viewModelScope.launch {
        repository.inserir(receita)
    }

    fun deletar(receita: Receita) = viewModelScope.launch {
        repository.deletar(receita)
    }

    fun deletarTudo() = viewModelScope.launch {
        repository.deletarTudo()
    }
}
