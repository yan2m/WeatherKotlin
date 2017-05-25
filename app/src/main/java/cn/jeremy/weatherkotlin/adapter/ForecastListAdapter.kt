package cn.jeremy.weatherkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import cn.jeremy.weatherkotlin.domain.Domain

/**
 * Created by linjy on 2017/5/22.
 */
class ForecastListAdapter(val weekForecast: Domain.ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}