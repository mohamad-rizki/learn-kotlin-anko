package com.dafian.android.kotlinanko

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)

                val name = editText {
                    hint = "What's Your Name?"
                }

                button("Say Hello") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick { toast("Hi, ${name.text}") }
                }.lparams(width = matchParent) {
                    topMargin = dip(8)
                }

                button("Show Alert") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick { _ ->
                        alert("Show Alert") {
                            yesButton { toast("Yes Button ${name.text}") }
                            noButton { toast("No Button") }
                        }.show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(8)
                }

                button("Show Selector") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        val club = listOf("Asia", "Africa", "America", "Europe", "Australia")
                        selector("Hi, $name, Where do you come from?", club) { _, i ->
                            toast("Your choose ${club[i]}")
                        }
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(8)
                }

                button("Show Snackbar"){
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        snackbar(name, "Hi, ${name.text}!")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(8)
                }

                button("Show Progress Bar"){
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        indeterminateProgressDialog("Hello, ${name.text}! Please wait...").show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(8)
                }
            }
        }
    }
}
