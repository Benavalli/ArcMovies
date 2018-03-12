package com.benavalli.arcmovies.features.home.presenter

import com.benavalli.arcmovies.api.Endpoints
import com.benavalli.arcmovies.api.repository.HomeRepository
import com.benavalli.arcmovies.domain.Genre
import com.benavalli.arcmovies.domain.MovieDetails
import com.benavalli.arcmovies.features.home.contract.DetailsActivityContract
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class DetailsActivityPresenterTest {

    @Mock private lateinit var view: DetailsActivityContract.View
    @Mock private lateinit var repository: HomeRepository
    private lateinit var presenter: DetailsActivityPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        `when`(repository.getDetails(anyInt())).thenReturn(buildObservableMovie())
        presenter = DetailsActivityPresenter(repository)
        presenter.attachView(view)
    }

    @After
    fun after() {
        presenter.detachView()
    }

    @Test
    fun loadDetailsSuccessTest() {
        presenter.loadDetails(anyInt())
        verify(view, times(1)).bindDetails(buildMovie())
    }

    private fun buildObservableMovie() : Observable<MovieDetails> = Observable.just(buildMovie())

    private fun buildMovie() : MovieDetails =  MovieDetails("title", "", "",
            ArrayList<Genre>(), "overview")

}