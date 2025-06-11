package com.example.iraklimidd

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TeamsAdapter
    private val teamsList = mutableListOf<Teams>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.init()

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TeamsAdapter(teamsList) { team ->
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("name", team.name)
                putExtra("description", team.description)
                putExtra("website", team.website)
                putExtra("imageUrl", team.imageUrl)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        fetchTeams()
    }

    private fun fetchTeams() {
        val call = RestClient.getReqResService().getTeams(1)
        call.enqueue(object : Callback<ReqresObj<List<Teams>>> {
            override fun onResponse(
                call: Call<ReqresObj<List<Teams>>>,
                response: Response<ReqresObj<List<Teams>>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        teamsList.clear()
                        teamsList.addAll(it)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "დაფიქსირდა შეცდომა!", Toast.LENGTH_SHORT).show()
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ReqresObj<List<Teams>>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ქსელური შეცდომა: ${t.message}", Toast.LENGTH_LONG).show()
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })
    }
}

