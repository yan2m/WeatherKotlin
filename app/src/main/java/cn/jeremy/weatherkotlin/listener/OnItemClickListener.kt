package cn.jeremy.weatherkotlin.listener

import cn.jeremy.weatherkotlin.domain.Domain.Forecast

/**
 * Created by linjy on 2017/5/26.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}