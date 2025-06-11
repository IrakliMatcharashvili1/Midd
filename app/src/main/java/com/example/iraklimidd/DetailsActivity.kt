package com.example.iraklimidd

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DetailsActivity : AppCompatActivity() {

    private lateinit var detailsName: TextView
    private lateinit var detailsDescription: TextView
    private lateinit var detailsWebsite: TextView
    private lateinit var detailsImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)

        detailsName = findViewById(R.id.detailsName)
        detailsDescription = findViewById(R.id.detailsDescription)
        detailsWebsite = findViewById(R.id.detailsWebsite)
        detailsImage = findViewById(R.id.detailsImage)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val website = intent.getStringExtra("website")
        val imageUrl = intent.getStringExtra("imageUrl")

        detailsName.text = name
        detailsDescription.text = description
        detailsWebsite.text = website

        Picasso.get()
            .load(imageUrl)
            .into(detailsImage)
    }
}
