package com.example.myapplication.mvp.presenter

import android.util.Log
import com.example.myapplication.*
import com.example.myapplication.adapters.SerialsAdapter
import com.example.myapplication.di.module.Serial
import com.example.myapplication.mvp.view.IUserListPresenter
import com.example.myapplication.mvp.view.MainView4
import com.example.myapplication.mvp.view.SerialItemView
import com.example.myapplication.navigation.Screens
import com.example.myapplication.room.dao.Database
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers.io
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MySerialPresenter : MvpPresenter<MainView4>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var database: Database

    inner class UsersListPresenter :
        IUserListPresenter {
        var users: List<Serial> = mutableListOf()

        override fun onItemClick(view: SerialItemView?) {
            val result = users[view!!.getPos()]
            Singleton.instance.serial = result
            router.replaceScreen(Screens.SerialScreen())
//            Singleton.instance.serial = result
        }

        override fun bindView(view: SerialItemView?) {
            val user: Serial = users[view!!.getPos()]
            view.setLogin(user.title)
            view.loadAvatar("https://image.tmdb.org/t/p/w500" + user.poster)
        }

        override fun getCount(): Int {
            return users.size
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        takeList()
    }

    private fun takeList() {
        Observable.create<SerialsAdapter> {
            var db = database.userDao()
            var usersListPresenter = UsersListPresenter()
            usersListPresenter.users = db!!.getAll()
            Log.d("fffff", "takeList: " + db!!.getAll())
            it.onNext(
                SerialsAdapter(
                    usersListPresenter
                )
            )
        }.subscribeOn(io()).observeOn(AndroidSchedulers.mainThread()).subscribe { viewState.setAdapter(it) }
    }
}