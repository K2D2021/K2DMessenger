package ru.k2d.k2dmessenger.ui.fragments

import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import ru.k2d.k2dmessenger.R

class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {


    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener {
            sendCode()
        }
    }


    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()) {
            Toast.makeText(
                activity,
                getString(R.string.register_toast_enter_phone),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.registerDataContainer, EnterCodeFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }

}