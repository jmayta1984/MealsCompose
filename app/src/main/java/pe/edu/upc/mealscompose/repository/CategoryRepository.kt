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

package pe.edu.upc.mealscompose.repository

import pe.edu.upc.mealscompose.data.model.Category
import pe.edu.upc.mealscompose.data.remote.CategoryService
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val categoryService: CategoryService
) {
    suspend fun fetchCategories(): List<Category> {
        val response = categoryService.fetchCategories()
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!.categories
        }
        return listOf()
    }
}