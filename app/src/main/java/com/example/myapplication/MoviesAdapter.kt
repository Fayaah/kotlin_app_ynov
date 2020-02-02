package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.models.Movie
import kotlinx.android.synthetic.main.item_card_list.view.*

class MoviesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is CardViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    fun submitList(movieUserResults: List<Movie> ) {
        items = movieUserResults
    }


    class CardViewHolder constructor( itemView: View ): RecyclerView.ViewHolder(itemView) {
        //val movieImage = itemView.card_image
        val movieTitle = itemView.card_title
        val movieDate = itemView.card_date

        fun bind(randomMovie: Movie) {
            //movieImage.(randomMovie.movies.get(adapterPosition).poster)
            movieTitle.setText(randomMovie.title)
            movieDate.setText(randomMovie.productionYear)

            /*=val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(Movies.image)
                .into(cardImage)*/
        }
    }
}