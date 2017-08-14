package ru.rambler.it.presentation

abstract class BasePresenter<out T : BaseView>(val view: T)