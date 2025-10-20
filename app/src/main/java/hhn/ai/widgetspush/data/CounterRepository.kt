package hhn.ai.widgetspush.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.core.content.edit

object CounterRepository {
    private const val PREF_NAME = "WaterCounterPrefs"
    private const val KEY_COUNT = "count"

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    fun init(context: Context) {
        _count.value = getCount(context)
    }

    fun getCount(context: Context): Int {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getInt(KEY_COUNT, 0)
    }

    fun setCount(context: Context, value: Int) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit { putInt(KEY_COUNT, value) }
        _count.postValue(value)
    }
}