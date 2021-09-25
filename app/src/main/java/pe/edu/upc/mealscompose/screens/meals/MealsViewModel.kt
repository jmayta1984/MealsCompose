package pe.edu.upc.mealscompose.screens.meals

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            val response = mealRepository.fetchMealsByCategory(name)
            if (response.isSuccessful && response.body() != null) {
                _meals.postValue(response.body()!!.meals)
            }

        }
    }
}