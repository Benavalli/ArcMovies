package com.benavalli.arcmovies.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>,
    C : BaseContract.Component<V, P>> : AppCompatActivity(), BaseContract.View {

  protected val presenter: P by lazy { component.presenter() }
  protected val component: C by lazy { createComponent() }

  protected abstract fun createComponent(): C

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(this as V)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }

  fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction { add(frameId, fragment) }
  }

  inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
  }

}
