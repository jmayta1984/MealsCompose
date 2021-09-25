package pe.edu.upc.mealscompose.screens.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.upc.mealscompose.data.model.Category
import pe.edu.upc.mealscompose.data.repository.CategoryRepository
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val categoryRepository: CategoryRepository) :
    ViewModel() {

    private var _categories = MutableLiveData<List<Category>>()
    val categories get() = _categories

    fun fetchCategories() {
        viewModelScope.launch {
            val response = categoryRepository.fetchCategories()
            if (response.isSuccessful && response.body() != null)
                _categories.postValue(response.body()!!.categories)
        }
    }
}