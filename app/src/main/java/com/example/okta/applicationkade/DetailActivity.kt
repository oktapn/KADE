package com.example.okta.applicationkade

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                imageView(R.drawable.img_barca).lparams(width = matchParent
                        , height = 100) {
                    padding = dip(20)
                    margin = dip(15)
                }

                val name = editText() {
                    hint = "What's your name?"
                }

                button("Say Hello")
            }
        }
    }
}
