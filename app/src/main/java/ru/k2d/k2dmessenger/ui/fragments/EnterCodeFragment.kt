package ru.k2d.k2dmessenger.ui.fragments

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.databinding.FragmentEnterCodeBinding

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    private lateinit var mBinding: FragmentEnterCodeBinding

    override fun onStart() {
        super.onStart()
        mBinding = FragmentEnterCodeBinding.inflate(layoutInflater)
        mBinding.registerInputCode.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val string = mBinding.registerInputCode.text.toString()
                if (string.length == 6){
                    verifyCode()
                }
            }

        })
    }

    private fun verifyCode() {
        Toast.makeText(activity, "Ok", Toast.LENGTH_SHORT).show()
    }
}