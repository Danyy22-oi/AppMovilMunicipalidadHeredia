package com.example.municipalidadheredia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class ContactoActivity extends AppCompatActivity {

    private EditText etConsulta;
    private Button btnEnviarConsulta, btnVolver;
    private TextView tvTicketNumero, tvRespuestaMunicipalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        // Vincular elementos de la interfaz
        etConsulta = findViewById(R.id.etConsulta);
        btnEnviarConsulta = findViewById(R.id.btnEnviarConsulta);
        btnVolver = findViewById(R.id.btnVolver);
        tvTicketNumero = findViewById(R.id.tvTicketNumero);
        tvRespuestaMunicipalidad = findViewById(R.id.tvRespuestaMunicipalidad);

        // Manejar el botón de enviar consulta
        btnEnviarConsulta.setOnClickListener(view -> {
            String consulta = etConsulta.getText().toString().trim();

            if (consulta.isEmpty()) {
                Toast.makeText(ContactoActivity.this, "Por favor, ingresa una consulta.", Toast.LENGTH_SHORT).show();
            } else {
                // Generar un número de ticket único
                String ticketNumero = generarNumeroTicket();

                // Mostrar el número de ticket
                tvTicketNumero.setText("Número de Ticket: " + ticketNumero);

                // Simular una respuesta de la municipalidad
                tvRespuestaMunicipalidad.setText("Respuesta de la Municipalidad: Tu consulta ha sido recibida. Te responderemos en breve.");

                // Limpiar el campo de consulta
                etConsulta.setText("");

                // Simular el proceso de envío (puedes integrarlo con un backend)
                Toast.makeText(ContactoActivity.this, "Consulta enviada con éxito.", Toast.LENGTH_SHORT).show();
            }
        });

        // Manejar el botón de volver
        btnVolver.setOnClickListener(view -> finish());
    }

    // Método para generar un número de ticket único
    private String generarNumeroTicket() {
        return UUID.randomUUID().toString().substring(0, 8);  // Genera un ticket de 8 caracteres
    }
}
