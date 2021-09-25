package pe.edu.upc.mealscompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pe.edu.upc.mealscompose.data.remote.CategoryService
import pe.edu.upc.mealscompose.data.remote.MealService
import pe.edu.upc.mealscompose.data.repository.CategoryRepository
import pe.edu.upc.mealscompose.data.repository.MealRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMealRepository(
        mealService: MealService
    ): MealRepository {
        return MealRepository(mealService)
    }

    @Provides
    @ViewModelScoped
    fun provideCategoryRepository(
        categoryService: CategoryService
    ): CategoryRepository {
        return CategoryRepository(categoryService)
    }
}