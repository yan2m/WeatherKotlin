package cn.jeremy.kotlinapplication

import android.os.Bundle

class SecondActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        toast("second")
    }
}
