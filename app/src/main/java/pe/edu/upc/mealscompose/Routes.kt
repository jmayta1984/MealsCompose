package pe.edu.upc.mealscompose

sealed class Routes(val route: String) {
    object Categories : Routes("Categories")
    object Meals : Routes("Meals") {
        const val routeWithArgument = "Meals/{categoryId}"
        const val argument = "categoryId"
    }
}