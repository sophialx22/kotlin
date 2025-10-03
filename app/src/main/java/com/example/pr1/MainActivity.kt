package com.example.pr1
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tracker = ExpenseTracker()
        tracker.addExpense(Expense(500.0, "Еда", "2025-09-27"))
        tracker.addExpense(Expense(1200.0, "Одежда", "2025-09-26"))
        tracker.addExpense(Expense(300.0, "Еда", "2025-09-25"))

        val output = StringBuilder()
        output.append("Список расходов:\n")
        tracker.getAllExpenses().forEach { output.append(it).append("\n") }

        output.append("\nСумма по категориям:\n")
        tracker.sumByCategory().forEach { output.append(it).append("\n") }

        val textView: TextView = findViewById(R.id.textView)
        textView.text = output.toString()
    }
}
