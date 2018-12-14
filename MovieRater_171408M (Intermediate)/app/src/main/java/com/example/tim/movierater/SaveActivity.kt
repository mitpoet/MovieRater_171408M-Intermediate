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
import kotlinx.android.synthetic.main.activity_save.*




class SaveActivity : AppCompatActivity() {

    internal var rating_float = "0.0"

    companion object {
        var movieList = arrayListOf<Movie>()
        var nowShowing: Int = 0
    }

    val LANDING_ACTIVITY_RESULT_CODE = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        etLanguage_edit.setVisibility(View.GONE)
        etChkbox2_edit.setVisibility(View.INVISIBLE)
        etChkbox3_edit.setVisibility(View.INVISIBLE)
        etGone1_edit.setVisibility(View.GONE)
        etGone2_edit.setVisibility(View.GONE)
        etGone3_edit.setVisibility(View.GONE)

        etChkbox1_edit.setOnClickListener(View.OnClickListener {
            if (etChkbox1_edit.isChecked == true) {

                etChkbox2_edit.setVisibility(View.VISIBLE)
                etChkbox3_edit.setVisibility(View.VISIBLE)
                val etGone1_edit: CheckBox = findViewById(R.id.etGone1_edit)
                etGone1_edit.text = "Suitable for all ages = False"


            } else {
                if (etChkbox1_edit.isChecked == false) {
                    etChkbox2_edit.setVisibility(View.INVISIBLE)
                    etChkbox3_edit.setVisibility(View.INVISIBLE)
                    etGone1_edit.text = "Suitable for all ages = True"
                }
            }
        })

        rbtnButton1_edit.setOnClickListener(View.OnClickListener {
            val etLanguage_edit: RadioButton = findViewById(R.id.etLanguage_edit)
            if (rbtnButton1_edit.isChecked == true) {
                etLanguage_edit.text = "English"
            }
        })

        rbtnButton2.setOnClickListener(View.OnClickListener {
            val etLanguage_edit: RadioButton = findViewById(R.id.etLanguage_edit)
            if (rbtnButton2_edit.isChecked == true) {
                etLanguage_edit.text = "Chinese"
            }
        })

        rbtnButton3.setOnClickListener(View.OnClickListener {
            val etLanguage_edit: RadioButton = findViewById(R.id.etLanguage_edit)
            if (rbtnButton3_edit.isChecked == true) {
                etLanguage_edit.text = "Malay"
            }
        })

        rbtnButton4.setOnClickListener(View.OnClickListener {
            val etLanguage_edit: RadioButton = findViewById(R.id.etLanguage_edit)
            if (rbtnButton4_edit.isChecked == true) {
                etLanguage_edit.text = "Tamil"
            }
        })



        etChkbox2.setOnClickListener(View.OnClickListener {
            val etChkBox2_edit: CheckBox = findViewById(R.id.etChkbox2_edit)
            if (etChkBox2_edit.isChecked == true) {
                etGone2_edit.text = "Violence"
            } else {
                etGone2_edit.text = ""
            }
        })

        etChkbox3.setOnClickListener(View.OnClickListener {
            val etChkBox3_edit: CheckBox = findViewById(R.id.etChkbox3_edit)
            if (etChkBox3_edit.isChecked == true) {
                etGone3_edit.text = "Language"
            } else {
                etGone3_edit.text = ""
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.save, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //clear all entities when clear entities clicked

        if (item?.itemId == R.id.mClear) {
            etName_edit.getText().clear();
            etDescription_edit.getText().clear();
            etDate_edit.getText().clear();
            etChkbox1_edit.setChecked(false)
            etChkbox2_edit.setChecked(false)
            etChkbox3_edit.setChecked(false)
            radiogrp1_edit.clearCheck();
            if (rbtnButton1_edit.isChecked == false) {
                rbtnButton1_edit.setChecked(true)
            }
        }

        if (item?.itemId == R.id.mSave) {
            var myIntent = Intent(this, ViewMovieDetails::class.java)
            var movie = Movie(
                etName_edit.text.toString(),
                etDescription_edit.text.toString(),
                etLanguage_edit.text.toString(),
                etDate_edit.text.toString(),
                etChkbox1_edit.isChecked,
                etChkbox2_edit.isChecked,
                etChkbox3_edit.isChecked,
                0.0,
                ""
            )
            movieList.add(movie)
            nowShowing = movieList.indexOf(movie)
            startActivityForResult(myIntent, LANDING_ACTIVITY_RESULT_CODE)
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

