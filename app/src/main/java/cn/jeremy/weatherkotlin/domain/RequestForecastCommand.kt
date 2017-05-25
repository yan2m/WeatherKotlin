package cn.jeremy.weatherkotlin.domain

import cn.jeremy.weatherkotlin.domain.Domain.ForecastList
import cn.jeremy.weatherkotlin.http.ForecastRequest

/**
 * Created by linjy on 2017/5/25.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val request = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(request.execute())
    }
}