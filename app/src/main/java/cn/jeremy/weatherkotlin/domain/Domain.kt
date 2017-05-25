package cn.jeremy.weatherkotlin.domain

/**
 * Created by linjy on 2017/5/25.
 */
class Domain {
    data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)
    data class Forecast(val date: String, val description: String, val high: Int, val low: Int)
}