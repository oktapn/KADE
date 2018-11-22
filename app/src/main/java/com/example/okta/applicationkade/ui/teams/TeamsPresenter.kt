package com.example.okta.applicationkade.ui.teams

import com.example.okta.applicationkade.model.TeamResponse
import com.example.okta.applicationkade.service.ApiRepository
import com.example.okta.applicationkade.service.TheSportDBApi
import com.example.okta.applicationkade.utils.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getTeamList(league: String?) {
        view.showLoading()
        GlobalScope.launch(context.main){
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeams(league)).await(),
                    TeamResponse::class.java)

            view.showTeamList(data.teams)
            view.hideLoading()
        }
    }
}