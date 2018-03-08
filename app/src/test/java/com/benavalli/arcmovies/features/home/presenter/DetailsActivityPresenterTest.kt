package com.benavalli.arcmovies.features.home.presenter

import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.features.home.view.DetailsActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailsActivityPresenterTest {

    @Mock private lateinit var view: DetailsActivity
    @Mock private lateinit var repository: HomeRepository
    private lateinit var presenter: DetailsActivityPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        //todo mock api return with when
        presenter = DetailsActivityPresenter(repository)
        presenter.attachView(view)
    }

    @Test
    fun loadDetailsSuccessTest() {
        //todo verify view is called with correct object
        presenter.getView()
    }

}