package gsautnerr.com.github.alunoresponsvel_rm93388.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import gsautnerr.com.github.alunoresponsvel_rm93388.data.DicaDao
import gsautnerr.com.github.alunoresponsvel_rm93388.data.DicaDatabase
import gsautnerr.com.github.alunoresponsvel_rm93388.model.DicaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  DicasViewModel(application: Application) : AndroidViewModel(application) {

    private val dicaDao: DicaDao
    val dicasLiveData: LiveData<List<DicaModel>>


    init {
        val database = Room.databaseBuilder(
            getApplication(),
            DicaDatabase::class.java,
            "dicas_database"
        ).build()

        dicaDao = database.dicaDao()
        dicasLiveData = dicaDao.getAll()
    }

    fun addDica(dica: String, descricao : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val newDica = DicaModel(name = dica, desc= descricao)
            dicaDao.insert(newDica)
        }
    }


    fun removeDica(dica: DicaModel) {
        viewModelScope.launch(Dispatchers.IO) {
            dicaDao.delete(dica)
        }
    }
}