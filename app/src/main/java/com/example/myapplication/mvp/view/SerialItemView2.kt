package com.example.myapplication.mvp.view

import com.example.myapplication.di.module.IItemView

interface SerialItemView2: IItemView {
    fun setLogin(text: String?)
    fun loadAvatar(url: String?)
    fun setData(text: String?)
}