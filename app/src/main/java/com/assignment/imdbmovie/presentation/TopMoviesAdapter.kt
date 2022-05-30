package com.assignment.imdbmovie.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.assignment.imdbmovie.R
import com.assignment.imdbmovie.data.model.TopMoviesItem
import com.assignment.imdbmovie.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TopMoviesAdapter() : RecyclerView.Adapter<TopMoviesViewHolder>() {
    private var movies = ArrayList<TopMoviesItem>()
    fun setItems(topmovies: List<TopMoviesItem>) {
        movies.clear()
        movies.addAll(topmovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMoviesViewHolder {

        val binding: ListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )

        return TopMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopMoviesViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class TopMoviesViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(topMoviesItem: TopMoviesItem) {
        binding.textView.text = topMoviesItem.fullTitle
        binding.textView2.text = topMoviesItem.imDbRating
        Glide.with(binding.imageView.context)
            .load(topMoviesItem.image)
            .into(binding.imageView)

    }

}