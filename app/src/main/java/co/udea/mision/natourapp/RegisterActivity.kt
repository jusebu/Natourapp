package co.udea.mision.natourapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val registrarButton: Button= findViewById(R.id.registrar_button)
        val emailEditText: EditText= findViewById(R.id.emailPersonEditText)
        var emailTextview: TextView= findViewById(R.id.prueba)
        registrarButton.setOnClickListener {
            val nombre=emailEditText.text
            emailTextview.text=nombre
        }
    }
}