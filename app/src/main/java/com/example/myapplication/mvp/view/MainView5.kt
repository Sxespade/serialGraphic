package com.example.myapplication.mvp.view

import com.example.myapplication.adapters.SerialsAdapter2
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView5 : MvpView {
    fun setAdapter(serialsAdapter2: SerialsAdapter2)
}
