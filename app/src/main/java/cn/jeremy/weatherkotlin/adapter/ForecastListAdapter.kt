package cn.jeremy.weatherkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.jeremy.weatherkotlin.R
import cn.jeremy.weatherkotlin.domain.Domain
import cn.jeremy.weatherkotlin.listener.OnItemClickListener
import cn.jeremy.weatherkotlin.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by linjy on 2017/5/22.
 */
class ForecastListAdapter(val weekForecast: Domain.ForecastList, val itemClick: OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = weekForecast.size()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxView: TextView
        private val minView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxView = view.find(R.id.maxTemperature)
            minView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Domain.Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxView.text = high.toString()
                minView.text = low.toString()
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }
}