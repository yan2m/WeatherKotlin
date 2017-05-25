package cn.jeremy.weatherkotlin.domain

/**
 * Created by linjy on 2017/5/25.
 */
interface Command<T> {
    fun execute(): T
}