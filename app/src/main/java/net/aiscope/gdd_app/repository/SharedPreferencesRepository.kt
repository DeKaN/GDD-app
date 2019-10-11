package net.aiscope.gdd_app.repository

import android.content.Context
import android.preference.PreferenceManager
import javax.inject.Inject
import net.aiscope.gdd_app.model.Disease
import net.aiscope.gdd_app.model.HealthFacility

class SharedPreferencesRepository @Inject constructor(val context: Context) : HospitalRepository {
    override fun store(healthFacility: HealthFacility) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString("Health_Facility_Name", healthFacility.name)
        editor.putString("Health_Facility_Id", healthFacility.id)
        editor.apply()
    }

    override fun store(disease: Disease) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString("Disease", disease.name)
        editor.apply()
    }

    override fun load(): String =
        PreferenceManager.getDefaultSharedPreferences(context).getString("Health_Facility_Name", "not found")!!

    override fun delete() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}
