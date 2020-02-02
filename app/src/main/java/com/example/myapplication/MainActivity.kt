package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.models.Machin
import com.example.myapplication.models.Movie
import com.example.myapplication.models.RandomUserResults
import com.example.myapplication.network.ApiError
import com.example.myapplication.network.ApiHelpers
import com.example.myapplication.network.ApiRequest
import com.example.myapplication.network.ApiRequestCallback
import kotlinx.android.synthetic.main.activity_main.*
import com.example.myapplication.MoviesAdapter as MoviesAdapter1

class MainActivity : AppCompatActivity() {

    lateinit var movies : MutableList<Movie>
    lateinit var machins : MutableList<Machin>
    lateinit var adapter: MoviesAdapter1
    private val apiHelpers = ApiHelpers(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        machins = mutableListOf()
        adapter = MoviesAdapter1()

        val recyclerView = recycler_view // on récupère ici le RV concerné
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        //loadMachins() // récupérations des données à injecter dans l'adapter du recyclerview
        loadUserById()
    }

    private fun loadMachins() {
        for (i in 1..15) {
            machins.add(Machin("Title: $i", "Description $i"))
        }
    }

    private fun loadUserById() {
        apiHelpers.getForecastAsync(10,
            object : ApiRequestCallback<RandomUserResults>() {
                override fun onSuccess(result: RandomUserResults) {
                    super.onSuccess(result)
                    Log.d("RES", result.toString())
                    runOnUiThread {
                        val resultList = result.movies
                        for (item in resultList ) {
                            movies.add(item)
                        }
                        adapter.notifyDataSetChanged()
                    }
                }

                override fun onError(error: ApiError) {
                    super.onError(error)
                    Log.d(
                        MainActivity::class.java.canonicalName,
                        "onError() called with: error.code = [" + error.code.toString() + " & error.message " + error.message + "]"
                    )
                }
            }
        )
    }
}
