package pe.edu.upc.mealscompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import pe.edu.upc.mealscompose.data.local.MealDao
import pe.edu.upc.mealscompose.data.remote.CategoryService
import pe.edu.upc.mealscompose.data.remote.MealService
import pe.edu.upc.mealscompose.repository.CategoryRepository
import pe.edu.upc.mealscompose.repository.MealRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMealRepository(
        mealService: MealService,
        mealDao: MealDao
    ): MealRepository {
        return MealRepository(mealService, mealDao)
    }

    @Provides
    @ViewModelScoped
    fun provideCategoryRepository(
        categoryService: CategoryService
    ): CategoryRepository {
        return CategoryRepository(categoryService)
    }
}