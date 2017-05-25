package cn.jeremy.kotlinapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

open class MainActivity : AppCompatActivity() {

    var txt: String = "hello kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast(txt)
    }

    fun toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }
}
