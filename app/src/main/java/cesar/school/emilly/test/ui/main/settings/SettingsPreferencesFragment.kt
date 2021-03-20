package cesar.school.emilly.test.ui.main.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import cesar.school.emilly.test.R

class SettingsPreferencesFragment: PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.pref_screen)
    }
    companion object {
        private var currentTempUnit: String = "metric"

        fun getTempUnit(): String {
            return when (currentTempUnit) {
                "metric" -> "°C"
                "imperial" -> "°F"
                else -> "°C"
            }
        }


    }


}