package hhn.ai.widgetspush.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import hhn.ai.widgetspush.R
import hhn.ai.widgetspush.data.CounterRepository

class NotificationWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        val context = applicationContext
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // LERNZIEL: Notification Channels für Android 8+ erstellen.
        // AUFGABE 1: Prüfe, ob die Android-Version Oreo oder höher ist. Wenn ja,
        // erstelle einen NotificationChannel. Gib ihm eine ID (aus NotificationHelper),
        // einen Namen und eine Wichtigkeit.
        // ...

        // LERNZIEL: Daten aus dem Hintergrund-Task heraus lesen.
        // AUFGABE 2: Lese den aktuellen Zählerstand aus dem Repository.
        // ...

        // LERNZIEL: Eine Benachrichtigung mit dynamischem Inhalt erstellen.
        // AUFGABE 3: Baue die Benachrichtigung mit NotificationCompat.Builder.
        // - Weise den Channel zu.
        // - Setze Icon, Titel und einen Text, der den aktuellen Zählerstand enthält.
        // ...

        // AUFGABE 4: Zeige die Benachrichtigung mit dem NotificationManager an.
        // Verwende eine eindeutige ID aus dem NotificationHelper.
        // ...

        return Result.success()
    }
}
