package ru.rambler.it.presentation.presenter

import android.content.Intent
import android.os.Bundle
import ru.rambler.it.presentation.view.interfaces.BaseView

@Suppress("UNUSED_PARAMETER")
abstract class BasePresenter<out V : BaseView>(val view: V) {

    fun onCreate(state: Bundle?) {
    }

    fun onViewCreated() {
    }

    fun onStart() {
    }

    fun onStop() {
    }

    fun onSaveInstanceState(state: Bundle?) {
    }

    fun onDestroy() {
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
    }
}