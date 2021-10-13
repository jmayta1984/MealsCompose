/*
 * Designed and developed by 2021 jmayta1984 (Jorge Mayta)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pe.edu.upc.mealscompose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "meals")
data class Meal(

    @SerializedName("idMeal")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @SerializedName("strMeal")
    @ColumnInfo(name = "meal_name")
    val name: String,

    @SerializedName("strMealThumb")
    @ColumnInfo(name = "meal_poster")
    val poster: String
) {
    @Ignore
    var favorite: Boolean = false

    @Ignore
    @SerializedName("strInstructions")
    var instructions: String = ""

    @Ignore
    @SerializedName("strCategory")
    var category: String = ""

    @Ignore
    @SerializedName("strArea")
    var country: String = ""

}