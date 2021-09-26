package pe.edu.upc.mealscompose.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.mealscompose.data.local.AppDatabase
import pe.edu.upc.mealscompose.data.local.MealDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "meals.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideMealDao(appDatabase: AppDatabase): MealDao {
        return appDatabase.mealDao()
    }
}