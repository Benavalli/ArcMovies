package com.benavalli.arcmovies.features.home.presenter

import android.content.Context
import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.features.home.view.DetailsActivity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsActivityPresenterTest {

    @Mock private lateinit var view: DetailsActivity
    @Mock private lateinit var context: Context
    @Mock private lateinit var repository: HomeRepository
    private lateinit var presenter: DetailsActivityPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        //todo mock api return with when
        presenter = DetailsActivityPresenter(context, repository)
        presenter.attachView(view)
    }

    @Test
    fun loadDetailsSuccessTest() {
        //todo verify view is called with correct object
        presenter.getView()
    }

}