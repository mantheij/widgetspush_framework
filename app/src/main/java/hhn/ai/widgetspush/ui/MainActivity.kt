package hhn.ai.widgetspush.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import hhn.ai.widgetspush.R
import hhn.ai.widgetspush.data.CounterRepository
import hhn.ai.widgetspush.notifications.NotificationHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fordert die Berechtigung für Benachrichtigungen an (ab Android 13/Tiramisu).
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
            }
        }

        // Startet die periodische Planung der Benachrichtigungen.
        NotificationHelper.scheduleNotifications(this)

        val textView = findViewById<TextView>(R.id.textViewCounter)

        // Initialisiert das Repository, damit die LiveData den ersten Wert bekommt.
        CounterRepository.init(this)

        // LERNZIEL: Die UI reaktiv auf Datenänderungen aktualisieren mit LiveData.
        // AUFGABE: Beobachte die `count` LiveData aus dem CounterRepository.
        // In der Lambda-Funktion des Observers soll der Text der `textView` jedes Mal
        // aktualisiert werden, wenn sich der Zählerstand ändert.
        // ...
    }
}
