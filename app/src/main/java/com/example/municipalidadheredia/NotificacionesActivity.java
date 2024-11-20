package com.example.municipalidadheredia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificacionesActivity extends AppCompatActivity {

    private RecyclerView rvNotificaciones;
    private Button btnVolver;
    private List<String> notificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        // Vincular elementos de la interfaz
        rvNotificaciones = findViewById(R.id.rvNotificaciones);
        btnVolver = findViewById(R.id.btnVolver);

        // Configurar RecyclerView
        rvNotificaciones.setLayoutManager(new LinearLayoutManager(this));

        // Crear una lista simulada de notificaciones
        notificaciones = new ArrayList<>();
        notificaciones.add("Notificación: La recolección en la zona A ha comenzado.");
        notificaciones.add("Notificación: La recolección en la zona B ha terminado.");
        notificaciones.add("Notificación: La recolección en la zona C ha comenzado.");

        NotificacionesAdapter adapter = new NotificacionesAdapter(notificaciones);
        rvNotificaciones.setAdapter(adapter);

        // Manejar el botón de volver
        btnVolver.setOnClickListener(view -> finish());
    }
}
