package gsautnerr.com.github.alunoresponsvel_rm93388.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import gsautnerr.com.github.alunoresponsvel_rm93388.model.DicaModel

@Dao
interface DicaDao {
    @Query("SELECT * FROM dicaModel")
    fun getAll(): LiveData<List<DicaModel>>
    @Insert
    fun insert(dica: DicaModel)
    @Delete
    fun delete(dica: DicaModel)
}