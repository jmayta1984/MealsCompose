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

package pe.edu.upc.mealscompose.screens.meals

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.mealscompose.data.model.Meal
import pe.edu.upc.mealscompose.repository.MealRepository
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val mealRepository: MealRepository) : ViewModel() {

    private var _meals = MutableLiveData<List<Meal>>()
    val meals get() = _meals

    fun fetchMealsByCategory(name: String) {
        viewModelScope.launch {
            _meals.postValue(mealRepository.fetchMealsByCategory(name))
        }
    }

    fun insert(meal: Meal) {
        viewModelScope.launch {
            mealRepository.insert(meal)
        }
    }

    fun delete(meal: Meal) {
        viewModelScope.launch {
            mealRepository.delete(meal)
        }
    }
}