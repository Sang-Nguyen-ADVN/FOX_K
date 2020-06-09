package net.ihaha.sunny.ui.data.base

interface IConvertableTo<T> {
    fun convertTo(): T?
}