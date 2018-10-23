package com.example.okta.applicationkade

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    private var name: String = ""
    lateinit var nameTextView: TextView
    lateinit var descTextView: TextView
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        name = intent.getStringExtra("name")
        var image = intent.getIntExtra("image", 0)
        var desc = intent.getStringExtra("desc")
        verticalLayout {
            imageView = imageView().lparams(width = matchParent
                    , height = 300) {
                padding = dip(20)
                margin = dip(15)
            }
            nameTextView = textView()
            nameTextView.text = name
            descTextView = textView()
            descTextView.text = desc
            Glide.with(this).load(image).into(imageView)
        }
    }

}
