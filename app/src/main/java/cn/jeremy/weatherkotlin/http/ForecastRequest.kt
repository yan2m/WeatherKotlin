package cn.jeremy.weatherkotlin.http

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by linjy on 2017/5/24.
 */
class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val PART_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$PART_URL&APPID=$APP_ID&q="
    }

    fun execute(): Response.ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.d("ForecastResult", forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, Response.ForecastResult::class.java)
    }
}