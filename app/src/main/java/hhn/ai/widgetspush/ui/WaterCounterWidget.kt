package hhn.ai.widgetspush.ui

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import hhn.ai.widgetspush.R
import hhn.ai.widgetspush.data.CounterRepository

class WaterCounterWidget : AppWidgetProvider() {

    companion object {
        // LERNZIEL: Eigene Aktionen für Broadcasts definieren.
        // AUFGABE 1: Definiere hier zwei private, eindeutige Action-Strings für die Button-Klicks.
        // Beispiel: private const val ACTION_INCREMENT = "dein.paket.name.ACTION_INCREMENT"


        // Diese Funktion aktualisiert ein einzelnes Widget.
        private fun updateWidget(context: Context, manager: AppWidgetManager, id: Int) {
            val views = RemoteViews(context.packageName, R.layout.widget_water_counter)

            // LERNZIEL: Daten aus einer persistenten Quelle (SharedPreferences) lesen.
            // AUFGABE 2: Lese den aktuellen Zählerstand aus dem CounterRepository und zeige ihn
            // in der TextView des Widgets an. Das Format sollte "X / 8" sein.
            // ...

            // LERNZIEL: Intents erstellen, die Aktionen in einem AppWidgetProvider auslösen.
            // AUFGABE 3: Erstelle zwei Intents, die auf diese Klasse (WaterCounterWidget) zielen.
            // Weise jedem Intent die passende, oben definierte Action zu.
            // ...

            // LERNZIEL: PendingIntents für Widget-Interaktionen korrekt erstellen (inkl. Flags für Android 12+).
            // AUFGABE 4: Erstelle zwei PendingIntents vom Typ "Broadcast".
            // - Nutze die Intents aus der vorigen Aufgabe.
            // - Verwende unterschiedliche Request-Codes, um sie einzigartig zu machen.
            // - WICHTIG: Denke an die notwendigen Flags wie FLAG_IMMUTABLE.
            // ...

            // AUFGABE 5: Verknüpfe die PendingIntents mit den On-Click-Events der beiden Buttons.
            // ...

            // Aktualisiert das spezifische Widget.
            manager.updateAppWidget(id, views)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        // LERNZIEL: Auf Broadcast-Aktionen reagieren.
        // AUFGABE 6: Prüfe, welche Action der empfangene Intent hat.
        // Nutze dafür ein `when`-Statement mit den oben definierten Action-Strings.
        // ...

        // LERNZIEL: Daten persistent speichern.
        // AUFGABE 7: Innerhalb des `when`-Statements:
        // Lese den aktuellen Zähler, verändere ihn (erhöhe/verringere) und speichere den neuen Wert
        // zurück ins CounterRepository. Achte darauf, dass der Wert nicht unter 0 oder über 8 geht.
        // ...

        // LERNZIEL: Alle platzierten Widgets gleichzeitig aktualisieren.
        // AUFGABE 8: Nach dem Speichern des neuen Werts: Sorge dafür, dass alle Instanzen
        // dieses Widgets aktualisiert werden, nicht nur eines. Hol dir dazu alle Widget-IDs
        // und rufe für jede ID die `updateWidget`-Funktion auf.
        // ...
    }

    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        // Ruft für jedes platzierte Widget die update-Methode auf, wenn es erstellt wird.
        ids.forEach { updateWidget(context, manager, it) }
    }
}
