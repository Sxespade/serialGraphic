package com.example.myapplication.mvp.presenter

import com.example.myapplication.mvp.view.IUserListPresenter2
import com.example.myapplication.mvp.view.MainView5
import com.example.myapplication.mvp.view.SerialItemView2
import com.example.myapplication.adapters.SerialsAdapter2
import com.example.myapplication.di.module.Serial
import com.example.myapplication.room.dao.Database
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject


class GraphicPresenter : MvpPresenter<MainView5>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        takeList()

    }


    @Inject
    lateinit var router: Router
    @Inject
    lateinit var database: Database



    inner class UsersListPresenter2 :
        IUserListPresenter2 {
        var users: List<Serial> = mutableListOf()

        override fun onItemClick(view: SerialItemView2?) {
        }

        override fun bindView(view: SerialItemView2?) {
            val user: Serial = users[view!!.getPos()]
            view.setLogin(user.title)
            view.loadAvatar("https://image.tmdb.org/t/p/w500" + user.poster)
            view.setData(users[view.getPos()].nextAir)
        }

        override fun getCount(): Int {
            return users.size
        }
    }

    private fun takeList() {
        var db = database.userDao()
        Observable.create<SerialsAdapter2> {
            var pcomp = SerialComparator()
            val serials: TreeSet<Serial> = TreeSet(pcomp)
            for (ser in db!!.getAll()) {
                serials.add(ser)
            }
            var usersListPresenter2 = UsersListPresenter2()
            var serialList = mutableListOf<Serial>()
            for (serial in serials) {
                if (serial.nextAir != "Дата выхода следующей серии неизвестна")
                serialList.add(serial)
            }
            usersListPresenter2.users = serialList
            it.onNext(
                SerialsAdapter2(
                    usersListPresenter2
                )
            )
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            viewState.setAdapter(it)
        }
    }


    internal class SerialComparator : Comparator<Serial?> {
        override fun compare(o1: Serial?, o2: Serial?): Int {
            return if (o1!!.nextAir > o2!!.nextAir) 1 else if (o1.nextAir < o2.nextAir) -1 else 0
        }
    }

}