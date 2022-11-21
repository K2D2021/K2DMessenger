package ru.k2d.k2dmessenger.ui.fragments

import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*
import ru.k2d.k2dmessenger.MainActivity
import ru.k2d.k2dmessenger.R
import ru.k2d.k2dmessenger.activities.RegisterActivity
import ru.k2d.k2dmessenger.utilits.AUTH
import ru.k2d.k2dmessenger.utilits.AppTextWatcher
import ru.k2d.k2dmessenger.utilits.replaceActivity
import ru.k2d.k2dmessenger.utilits.showToast

class EnterCodeFragment(val phoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id,code)
        AUTH.signInWithCredential(credential).addOnCompleteListener{ task ->
            if (task.isSuccessful){
                showToast("Welcome!")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else {
                showToast(task.exception?.message.toString())
            }
        }
    }
}