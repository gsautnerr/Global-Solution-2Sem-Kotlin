package gsautnerr.com.github.alunoresponsvel_rm93388.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity

data class DicaModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val desc: String
)