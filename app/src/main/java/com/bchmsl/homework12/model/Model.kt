package com.bchmsl.homework12.model

data class Model(
    val model: String,
    val price: Int?,
    val category: Category,
    val image: Int
) {
    val id = lastId
    val fullModelName ="Mercedes-Benz " + this.model + " " + this.category.categoryName.removeSuffix("s")

    init {
        lastId++
    }
    companion object {
        enum class Category(val categoryName: String) {
            SUV("SUVs"),
            SEDAN("Sedans"),
            WAGON("Wagons"),
            COUPE("Coupes"),
            CONVERTIBLE("Convertibles"),
            ROADSTER("Roadsters"),
            ELECTRIC("Electrics")
        }
    }
}

var lastId = 0