package com.example.myapplication.di.module

import com.example.myapplication.mvp.presenter.*
import com.example.myapplication.mvp.view.AboutUFragment
import com.example.myapplication.mvp.view.MainActivity
import com.example.myapplication.mvp.view.SerialFragment
import com.example.serialgraphicinteres.di.module.CiceroneModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        CiceroneModule::class,
        DatabaseModule::class]
)
interface AppComponent {
//    fun repositorySubcomponent() : RepositorySubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(profilePresenter: ProfilePresenter)
    fun inject(serialPresenter: SerialPresenter)
    fun inject(mySerialPresenter: MySerialPresenter)
    fun inject(aboutUPresenter: AboutUPresenter)
    fun inject(graphicPresenter: GraphicPresenter)
}