package com.benavalli.arcmovies.api.flow

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface RequestFlow<E> {

    abstract fun schedule(): E

    abstract fun schedule(subscribeOn: Scheduler, observeOn: Scheduler): E
}


class ObservableRequestFlow<T> : RequestFlow<Observable<T>> {

    lateinit var observable: Observable<T>

   /* fun ObservableRequestFlow(observable: Observable<T>): ??? {
        this.observable = observable
    }*/

    override fun schedule(): Observable<T> {
        observable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        return observable
    }

    override fun schedule(subscribeOn: Scheduler, observeOn: Scheduler): Observable<T> {
        observable = observable
                .subscribeOn(subscribeOn)
                .observeOn(observeOn)
        return observable
    }
}
