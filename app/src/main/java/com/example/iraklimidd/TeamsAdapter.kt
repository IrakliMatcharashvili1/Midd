package com.example.iraklimidd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TeamsAdapter(
    private val teamsList: List<Teams>,
    private val onItemClick: (Teams) -> Unit
) : RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameText: TextView = itemView.findViewById(R.id.textView)  // შესაბამისი TextView-ის id
        private val imageView: ImageView = itemView.findViewById(R.id.imageView) // შესაბამისი ImageView-ის id

        fun bind(team: Teams) {
            nameText.text = team.name
            Picasso.get().load(team.imageUrl).into(imageView)

            itemView.setOnClickListener {
                onItemClick(team)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teams, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamsList[position])
    }

    override fun getItemCount(): Int = teamsList.size
}

