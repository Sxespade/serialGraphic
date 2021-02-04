package com.example.myapplication.mvp.view

import com.example.myapplication.adapters.SerialsAdapter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView2 : MvpView {
    fun setRecycle(serialsAdapter: SerialsAdapter)
}

