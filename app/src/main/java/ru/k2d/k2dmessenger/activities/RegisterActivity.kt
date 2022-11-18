package ru.k2d.k2dmessenger.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.k2d.k2dmessenger.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}