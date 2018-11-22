package com.example.okta.applicationkade.ui.teams

import com.example.okta.applicationkade.model.Team
import com.example.okta.applicationkade.model.TeamResponse
import com.example.okta.applicationkade.service.ApiRepository
import com.example.okta.applicationkade.service.TheSportDBApi
import com.example.okta.applicationkade.utils.TestContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class TeamsPresenterTest {

    @Mock
    private
    lateinit var view: TeamsView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository
    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        MockitoAnnotations.initMocks(this)
        presenter = TeamsPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun getTeamList() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val league = "English Premiere League"

        GlobalScope.launch {
            `when`(gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)).await(),
                    TeamResponse::class.java
            )).thenReturn(response)

            presenter.getTeamList(league)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showTeamList(teams)
            Mockito.verify(view).hideLoading()
        }
    }
}