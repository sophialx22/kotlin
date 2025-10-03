package com.example.pr1

class Expense(val amount: Double, val category: String, val date: String) {
    fun displayInfo(): String {
        return "Расход: $amount руб, Категория: $category, Дата: $date"
    }
}
