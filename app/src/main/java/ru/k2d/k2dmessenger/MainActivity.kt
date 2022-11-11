package ru.k2d.k2dmessenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.k2d.k2dmessenger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}