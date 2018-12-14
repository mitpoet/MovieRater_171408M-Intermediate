package com.example.tim.movierater

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ContextMenu
import android.view.View
import android.widget.*
import com.example.tim.movierater.MainActivity.Companion.movieList
import com.example.tim.movierater.MainActivity.Companion.nowShowing
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_movie_details.*

class ViewMovieDetails : AppCompatActivity() {

    companion object {
        val RETURN_MSG = "message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie_details)
        registerForContextMenu(tvReview)

        if (movieList[nowShowing].userRatingBar == 0.0) {
            tvTitle.text = movieList[nowShowing].name
            tvOverview.text = movieList[nowShowing].description
            tvLanguage.text = movieList[nowShowing].language
            tvReleaseDate.text = movieList[nowShowing].date


            if (movieList[nowShowing].age) {
                if (movieList[nowShowing].age) {
                    tvAge.text = "No"
                }
                if (movieList[nowShowing].violence && movieList[nowShowing].languageUsed) {
                    tvAge.text = "No (Violence & Language Used)"
                } else if (movieList[nowShowing].violence) {
                    tvAge.text = "No (Violence)"
                } else if (movieList[nowShowing].languageUsed) {
                    tvAge.text = "No (Language Used)"
                }

            } else {
                tvAge.text = "Yes"
            }
        }
        else{
            tvTitle.text = movieList[nowShowing].name
            tvOverview.text = movieList[nowShowing].description
            tvLanguage.text = movieList[nowShowing].language
            tvReleaseDate.text = movieList[nowShowing].date
            tvRating.rating = movieList[nowShowing].userRatingBar.toFloat()
            tvReview.text = movieList[nowShowing].userReview
            tvRating.setVisibility(View.VISIBLE)

            if (movieList[nowShowing].age) {
                if (movieList[nowShowing].age) {
                    tvAge.text = "No"
                }

                if (movieList[nowShowing].violence && movieList[nowShowing].languageUsed) {
                    tvAge.text = "No (Violence & Language Used)"
                } else if (movieList[nowShowing].violence) {
                    tvAge.text = "No (Violence)"
                } else if (movieList[nowShowing].languageUsed) {
                    tvAge.text = "No (Language Used)"
                }

            } else {
                tvAge.text = "Yes"
            }

        }

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if(v?.id == R.id.tvReview){
            menu?.add(1,1005,1,"Add Review")
        }

    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1005){
            var reviewIntent = Intent(this,RateMovie::class.java)
            startActivity(reviewIntent)
        }
        return super.onContextItemSelected(item)
    }
}
