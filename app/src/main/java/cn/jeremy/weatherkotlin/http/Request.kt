package cn.jeremy.weatherkotlin.http

import android.util.Log
import java.net.URL

/**
 * Created by linjy on 2017/5/24.
 */
class Request(val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d("request", forecastJsonStr)
    }
}