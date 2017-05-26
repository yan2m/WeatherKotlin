package cn.jeremy.weatherkotlin.domain

import cn.jeremy.weatherkotlin.http.Response
import cn.jeremy.weatherkotlin.http.Response.ForecastResult
import java.text.DateFormat
import java.util.*

/**
 * Created by linjy on 2017/5/25.
 */
class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): Domain.ForecastList {
        return Domain.ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    }

    private fun convertForecastListToDomain(list: List<Response.Forecast>): List<Domain.Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Response.Forecast): Domain.Forecast {
        return Domain.Forecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(icon: String): String = "http://openweathermap.org/img/w/$icon.png"

    private fun convertDate(dt: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(dt * 1000)
    }

}