package com.example.myapplication.mvp.view

import com.example.myapplication.di.module.IItemView

interface SerialItemView: IItemView {
    fun setLogin(text: String?)
    fun loadAvatar(url: String?)
}