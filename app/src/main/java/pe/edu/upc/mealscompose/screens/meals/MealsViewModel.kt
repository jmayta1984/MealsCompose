package pe.edu.upc.mealscompose.screens.meals

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.mealscompose.data.model.Meal
import pe.edu.upc.mealscompose.data.repository.MealRepository
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