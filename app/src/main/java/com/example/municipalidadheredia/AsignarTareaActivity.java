package com.example.municipalidadheredia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AsignarTareaActivity extends AppCompatActivity {

    private RecyclerView rvReportes;
    private Spinner spinnerEquipo;
    private Button btnAsignarTarea, btnVolver;
    private TextView tvMensajeEstado;
    private List<String> reportes;
    private String[] equipos = {"Equipo 1", "Equipo 2", "Equipo 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_tareas);

        // Vincular elementos de la interfaz
        rvReportes = findViewById(R.id.rvReportes);
        spinnerEquipo = findViewById(R.id.spinnerEquipo);
        btnAsignarTarea = findViewById(R.id.btnAsignarTarea);
        btnVolver = findViewById(R.id.btnVolver);
        tvMensajeEstado = findViewById(R.id.tvMensajeEstado);

        // Configurar RecyclerView para la lista de reportes
        rvReportes.setLayoutManager(new LinearLayoutManager(this));

        // Crear una lista de reportes simulados (esto debe provenir de un backend o base de datos)
        reportes = new ArrayList<>();
        reportes.add("Reporte #1: Recolección en zona A");
        reportes.add("Reporte #2: Recolección en zona B");
        reportes.add("Reporte #3: Recolección en zona C");

        ReportesAdapter adapter = new ReportesAdapter(reportes);
        rvReportes.setAdapter(adapter);

        // Manejar el botón de asignación de tarea
        btnAsignarTarea.setOnClickListener(view -> {
            // Verificar si se ha seleccionado un reporte
            int selectedReportePosition = rvReportes.getChildAdapterPosition(rvReportes.getFocusedChild());
            if (selectedReportePosition == RecyclerView.NO_POSITION) {
                Toast.makeText(AsignarTareaActivity.this, "Por favor, selecciona un reporte.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Obtener el reporte seleccionado
            String reporteSeleccionado = reportes.get(selectedReportePosition);

            // Obtener el equipo seleccionado
            String equipoSeleccionado = spinnerEquipo.getSelectedItem().toString();

            // Llamar a la función para asignar la tarea
            asignarTarea(reporteSeleccionado, equipoSeleccionado);
        });

        // Manejar el botón de volver
        btnVolver.setOnClickListener(view -> finish());
    }

    private void asignarTarea(String reporte, String equipo) {
        // Simular la asignación de la tarea
        Toast.makeText(this, "Tarea asignada a " + equipo + " para el reporte: " + reporte, Toast.LENGTH_LONG).show();

        // Actualizar el estado del reporte (ejemplo: cambiar estado de "Pendiente" a "En Proceso")
        // Esto puede realizarse en un backend o base de datos
        tvMensajeEstado.setText("Estado del reporte: En Proceso");

        // Mostrar mensaje de notificación
        Toast.makeText(this, "Notificación enviada al " + equipo, Toast.LENGTH_SHORT).show();

        // Puedes realizar más lógica aquí, como enviar una notificación real o actualizar una base de datos
    }
}
