package ru.k2d.k2dmessenger.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.databinding.FragmentEnterPhoneNumberBinding

class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {

    private lateinit var mBinding: FragmentEnterPhoneNumberBinding

    override fun onStart() {
        super.onStart()
        mBinding = FragmentEnterPhoneNumberBinding.inflate(layoutInflater)
        mBinding.registerInputPhoneNumber.setOnClickListener {
            sendCode()
        }
    }
    //TODO need to choose sintetics (NO!) or repair code with binding


    private fun sendCode() {
        if (mBinding.registerInputPhoneNumber.text.toString().isEmpty()){
            Toast.makeText(activity, getString(R.string.register_toast_enter_phone), Toast.LENGTH_SHORT).show()
        } else {
            childFragmentManager.beginTransaction()
                .replace(R.id.registerDataContainer,EnterCodeFragment())
                .addToBackStack(null)
                .commit()

        }
    }

}