package gsautnerr.com.github.alunoresponsvel_rm93388.data

import androidx.room.Database
import androidx.room.RoomDatabase
import gsautnerr.com.github.alunoresponsvel_rm93388.model.DicaModel

@Database(entities = [DicaModel::class], version = 1)
abstract class DicaDatabase : RoomDatabase() {
    abstract fun dicaDao(): DicaDao
}