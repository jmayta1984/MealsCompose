package pe.edu.upc.mealscompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.mealscompose.data.model.Meal

@Dao
interface MealDao {

    @Insert
    suspend fun insert(vararg meal: Meal)

    @Delete
    suspend fun delete(vararg meal: Meal)

    @Query("select * from meals where id =:id")
    suspend fun fetchById(id: String): Meal?
}