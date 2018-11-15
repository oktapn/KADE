package com.example.okta.applicationkade.ui.teams

import com.example.okta.applicationkade.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}