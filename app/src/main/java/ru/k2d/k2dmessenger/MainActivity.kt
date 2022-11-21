package ru.k2d.k2dmessenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import ru.k2d.k2dmessenger.activities.RegisterActivity
import ru.k2d.k2dmessenger.databinding.ActivityMainBinding
import ru.k2d.k2dmessenger.ui.fragments.ChatsFragment
import ru.k2d.k2dmessenger.ui.objects.AppDrawer
import ru.k2d.k2dmessenger.utilits.AUTH
import ru.k2d.k2dmessenger.utilits.replaceActivity
import ru.k2d.k2dmessenger.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        AUTH = FirebaseAuth.getInstance()
    }
}