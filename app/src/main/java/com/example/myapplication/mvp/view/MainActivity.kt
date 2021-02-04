package com.example.myapplication.mvp.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.navigation.Screens
import com.example.myapplication.di.module.MainView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject


class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var router: Router

    private val navigator: Navigator =
        SupportAppNavigator(this, supportFragmentManager, R.id.container)


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    router.replaceScreen(Screens.ProfileScreen())
                    return@OnNavigationItemSelectedListener true;
                }
                R.id.navigation_dashboard -> {
                    router.replaceScreen(Screens.MySerialsScreen())
                    return@OnNavigationItemSelectedListener true;
                }
                R.id.navigation_notifications -> {
                    router.replaceScreen(Screens.GraphicScreen())
                    return@OnNavigationItemSelectedListener true;
                }
                R.id.navigation_notificatio -> {
                    router.replaceScreen(Screens.AboutUScreen())
                    return@OnNavigationItemSelectedListener true;
                }
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance.appComponent.inject(this)
        bottom_nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onStart() {
        router.replaceScreen(Screens.ProfileScreen())
        super.onStart()
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
//        for (fragment in supportFragmentManager.fragments) {
//            if (fragment is BackButtonListener && (fragment as BackButtonListener).backPressed()) {
//                return
//            }
//        }
//        presenter.backClicked()
    }


    fun toast() {
        runOnUiThread {  Toast.makeText(this,"DDDDD", Toast.LENGTH_SHORT) }
    }

}