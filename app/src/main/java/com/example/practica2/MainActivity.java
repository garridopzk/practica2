package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "canal_notificaciones";
    private static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonToast = findViewById(R.id.button_toast);
        Button buttonNotification = findViewById(R.id.button_notification);
        Button buttonmodificado= findViewById(R.id.button_toast2);

        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar Toast
                Toast.makeText(MainActivity.this, "Este es un Toast", Toast.LENGTH_SHORT).show();
            }
        });
        buttonmodificado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar Notificación
                showNotification();
            }
        });
    }

    private void showNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Crear canal de notificación para Android Oreo y superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Canal de Notificaciones", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        // Construir la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)  // Asegúrate de que este icono exista
                .setContentTitle("Título de Notificación")
                .setContentText("Este es el contenido de la notificación")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Mostrar la notificación
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}

