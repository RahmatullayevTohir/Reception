package com.example.reception

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.timepicker.MaterialTimePicker

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    fun initViews(){
        containerView = findViewById(R.id.contenier_view)
        var addButton = findViewById<Button>(R.id.btn_item)
        var etName = findViewById<EditText>(R.id.et_name)
        var etTime = findViewById<EditText>(R.id.et_time)

       

        addButton.setOnClickListener {
            if (etName.text.isNotEmpty()&&etTime.text.isNotEmpty()){
                val item = item(name = etName.text.toString(), time = etTime.text.toString())
                containerView.addView(addNewItem(item))
            }
            else{
                Snackbar.make(containerView,"To'liq to'ldirmadingiz",
                Snackbar.LENGTH_LONG).show()
            }


        }
    }

    private fun addNewItem(item: item):LinearLayout{
        val tempLinearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val params = LinearLayout.LayoutParams(-1,-2)
            params.setMargins(30,30,30,0)
            background = getDrawable(R.drawable.rounded_background)
            layoutParams = params
        }
        val nameTextView = TextView(this).apply {
            text = item.name
            val params = LinearLayout.LayoutParams(-1,-2)
            params.setMargins(30,30,30,0)
            layoutParams = params
        }
        val timeTextView = TextView(this).apply {
            val params = LinearLayout.LayoutParams(-1,-2)
            params.setMargins(30,30,30,0)
            layoutParams =params
            text = item.time
        }

        tempLinearLayout.addView(nameTextView)
        tempLinearLayout.addView(timeTextView)
        return tempLinearLayout
    }
}