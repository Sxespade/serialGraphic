package com.example.myapplication.mvp.view.image

interface IImageLoader<T> {
    fun loadImage(url: String?, container: T?)
}