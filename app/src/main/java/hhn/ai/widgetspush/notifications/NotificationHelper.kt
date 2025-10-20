package hhn.ai.widgetspush.notifications

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

object NotificationHelper {
    const val CHANNEL_ID = "water_counter_channel"
    const val NOTIFICATION_ID = 1001
    private const val WORKER_TAG = "water_reminder_worker"

    fun scheduleNotifications(context: Context) {
        // LERNZIEL: Periodische, robuste Hintergrund-Tasks mit WorkManager planen.
        // AUFGABE 1: Erstelle einen `PeriodicWorkRequest` für den `NotificationWorker`.
        // Das Intervall soll 2 Stunden betragen.
        // ...

        // LERNZIEL: Sicherstellen, dass nur ein periodischer Task dieser Art läuft.
        // AUFGABE 2: Plane den Request mit dem WorkManager, indem du ihn in die Warteschlange einreihst.
        // - Verwende `enqueueUniquePeriodicWork`, um Duplikate zu vermeiden.
        // - Nutze den `WORKER_TAG` als Namen und `ExistingPeriodicWorkPolicy.KEEP`, um einen
        //   bestehenden Task zu erhalten.
        // ...
    }
}
