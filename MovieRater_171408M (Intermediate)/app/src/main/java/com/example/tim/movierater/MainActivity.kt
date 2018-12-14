package com.example.tim.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ContextMenu
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_view_movie_details.*



class MainActivity : AppCompatActivity() {

    internal var rating_float = "0.0"

    companion object {
        var movieList = arrayListOf<Movie>()
        var nowShowing: Int = 0
    }

    val LANDING_ACTIVITY_RESULT_CODE = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etLanguage.setVisibility(View.GONE)
        etChkbox2.setVisibility(View.INVISIBLE)
        etChkbox3.setVisibility(View.INVISIBLE)
        etGone1.setVisibility(View.GONE)
        etGone2.setVisibility(View.GONE)
        etGone3.setVisibility(View.GONE)

        etChkbox1.setOnClickListener(View.OnClickListener {
            if (etChkbox1.isChecked == true) {

                etChkbox2.setVisibility(View.VISIBLE)
                etChkbox3.setVisibility(View.VISIBLE)
                val etGone1: CheckBox = findViewById(R.id.etGone1)
                etGone1.text = "Suitable for all ages = False"


            } else {
                if (etChkbox1.isChecked == false) {
                    etChkbox2.setVisibility(View.INVISIBLE)
                    etChkbox3.setVisibility(View.INVISIBLE)
                    etGone1.text = "Suitable for all ages = True"
                }
            }
        })

        rbtnButton1.setOnClickListener(View.OnClickListener {
            val etLanguage: RadioButton = findViewById(R.id.etLanguage)
            if (rbtnButton1.isChecked == true) {
                etLanguage.text = "English"
            }
        })

        rbtnButton2.setOnClickListener(View.OnClickListener {
            val etLanguage: RadioButton = findViewById(R.id.etLanguage)
            if (rbtnButton2.isChecked == true) {
                etLanguage.text = "Chinese"
            }
        })

        rbtnButton3.setOnClickListener(View.OnClickListener {
            val etLanguage: RadioButton = findViewById(R.id.etLanguage)
            if (rbtnButton3.isChecked == true) {
                etLanguage.text = "Malay"
            }
        })

        rbtnButton4.setOnClickListener(View.OnClickListener {
            val etLanguage: RadioButton = findViewById(R.id.etLanguage)
            if (rbtnButton4.isChecked == true) {
                etLanguage.text = "Tamil"
            }
        })



        etChkbox2.setOnClickListener(View.OnClickListener {
            val etChkBox2: CheckBox = findViewById(R.id.etChkbox2)
            if (etChkBox2.isChecked == true) {
                etGone2.text = "Violence"
            } else {
                etGone2.text = ""
            }
        })

        etChkbox3.setOnClickListener(View.OnClickListener {
            val etChkBox3: CheckBox = findViewById(R.id.etChkbox3)
            if (etChkBox3.isChecked == true) {
                etGone3.text = "Language"
            } else {
                etGone3.text = ""
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
            //clear all entities when clear entities clicked

            if (item?.itemId == R.id.mClear) {
            etName.getText().clear();
            etDescription.getText().clear();
            etDate.getText().clear();
            etChkbox1.setChecked(false)
            etChkbox2.setChecked(false)
            etChkbox3.setChecked(false)
            radiogrp1.clearCheck();
            if (rbtnButton1.isChecked == false) {
                rbtnButton1.setChecked(true)
            }
        }

        if (item?.itemId == R.id.mAdd) {
            var myIntent = Intent(this, ViewMovieDetails::class.java)

            var count:Int = 0


            if (etName.getText().toString().trim().isEmpty()) {
                etName.setError("Field empty")
                count += 1}
            if (etDescription.getText().toString().trim().isEmpty()) {
                etDescription.setError("Field empty")
                count += 1}
            if (etDate.getText().toString().trim().isEmpty()) {
                etDate.setError("Field empty")
                count += 1}

            if(count == 0){
                var movie = Movie(
                    etName.text.toString(),
                    etDescription.text.toString(),
                    etLanguage.text.toString(),
                    etDate.text.toString(),
                    etChkbox1.isChecked,
                    etChkbox2.isChecked,
                    etChkbox3.isChecked,
                    0.0,
                    ""
                )
                movieList.add(movie)
                nowShowing = movieList.indexOf(movie)
                startActivityForResult(myIntent, LANDING_ACTIVITY_RESULT_CODE)}
        }

        return super.onOptionsItemSelected(item)
    }


    class Movie(
        name: String,
        description: String,
        language: String,
        date: String,
        age: Boolean,
        violence: Boolean,
        languageUsed: Boolean,
        userRatingBar: Double,
        userReview: String
    ) {
        var name: String
        var description: String
        var language: String
        var date: String
        var age: Boolean
        var violence: Boolean
        var languageUsed: Boolean
        var userRatingBar: Double
        var userReview: String

        init {
            this.name = name
            this.description = description
            this.language = language
            this.date = date
            this.age = age
            this.violence = violence
            this.languageUsed = languageUsed
            this.userRatingBar = userRatingBar
            this.userReview = userReview

        }
    }



}

