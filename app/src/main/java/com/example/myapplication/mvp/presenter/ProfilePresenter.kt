package com.example.myapplication.mvp.presenter

import com.example.myapplication.*
import com.example.myapplication.adapters.SerialsAdapter
import com.example.myapplication.di.module.Serial
import com.example.myapplication.mvp.model.Model
import com.example.myapplication.mvp.view.IUserListPresenter
import com.example.myapplication.mvp.view.MainView2
import com.example.myapplication.mvp.view.SerialItemView
import com.example.myapplication.navigation.Screens
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import moxy.MvpPresenter
import retrofit2.Retrofit
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ProfilePresenter: MvpPresenter<MainView2>() {

    @Inject lateinit var retrofit: Retrofit
    @Inject lateinit var router: Router
    var model = Model()

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



    fun findMySerial(toString: String) {
        model.retrofitDai(toString,retrofit).subscribeOn(io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            var usersListPresenter = UsersListPresenter()
            usersListPresenter.users = it
            viewState.setRecycle(
                SerialsAdapter(
                    usersListPresenter
                )
            )
        }
    }

}