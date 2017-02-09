package ru.rambler.it.domain.executor


import rx.Scheduler

interface PostExecutionThread {

    fun getScheduler() : Scheduler
}
