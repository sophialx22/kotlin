package com.example.pr1

class ExpenseTracker {
    private val expenses = mutableListOf<Expense>()

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun getAllExpenses(): List<String> {
        return if (expenses.isEmpty()) {
            listOf("Расходов пока нет.")
        } else {
            expenses.map { it.displayInfo() }
        }
    }

    fun sumByCategory(): List<String> {
        val categorySum = mutableMapOf<String, Double>()
        for (expense in expenses) {
            categorySum[expense.category] =
                categorySum.getOrDefault(expense.category, 0.0) + expense.amount
        }
        return categorySum.map { (category, sum) -> "$category: $sum руб" }
    }
}
