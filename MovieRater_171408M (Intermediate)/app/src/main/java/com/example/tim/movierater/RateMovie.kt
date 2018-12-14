package com.example.tim.movierater
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RatingBar
import com.example.tim.movierater.MainActivity.Companion.movieList
import com.example.tim.movierater.MainActivity.Companion.nowShowing
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_rate_movie.*
import kotlinx.android.synthetic.main.activity_view_movie_details.*
import org.w3c.dom.Comment

class RateMovie : AppCompatActivity() {

    companion object {
        val returnComment = "Comment"
        val returnStars = "Stars"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_movie)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.review, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.mSubmit) {

            val starRating = findViewById<RatingBar>(R.id.ratingBar)
            movieList[nowShowing].userRatingBar = starRating.rating.toDouble()
            movieList[nowShowing].userReview = userComment.text.toString()
            var reviewIntent = Intent(this,ViewMovieDetails::class.java)
            startActivity(reviewIntent)


        }

       return super.onOptionsItemSelected(item)



    }
}