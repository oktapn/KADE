package com.example.okta.applicationkade.ui.detailteam

import com.example.okta.applicationkade.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}