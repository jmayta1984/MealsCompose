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

package pe.edu.upc.mealscompose.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pe.edu.upc.mealscompose.data.local.AppDatabase
import pe.edu.upc.mealscompose.data.local.MealDao
import pe.edu.upc.mealscompose.data.model.Meal
import javax.inject.Inject
import javax.inject.Named
import com.google.common.truth.Truth.assertThat

@HiltAndroidTest
@SmallTest
class MealDaoTest {

    @get: Rule
    val hiltRule = HiltAndroidRule(this)

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test.db")
    lateinit var database: AppDatabase

    private lateinit var mealDao: MealDao

    @Before
    fun setUp() {
        hiltRule.inject()
        mealDao = database.mealDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertMeal() = runBlockingTest {
        val meal =
            Meal("13", "Breakfast", "https://www.themealdb.com/images/category/breakfast.png")
        mealDao.insert(meal)
        val mealFound = mealDao.fetchById("13")
        assertThat(mealFound).isEqualTo(meal)
    }


}