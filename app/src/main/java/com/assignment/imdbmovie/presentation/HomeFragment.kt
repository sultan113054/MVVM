package com.assignment.imdbmovie.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.imdbmovie.R
import com.assignment.imdbmovie.databinding.FragmentHomeBinding
import com.assignment.imdbmovie.presentation.di.injector
import okhttp3.internal.notifyAll
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    lateinit var vieModelFactory: TopMovieVieModelFactory
    private lateinit var viewModel: TopMoviesViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TopMoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        (requireActivity().application as injector).createTopMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, vieModelFactory).get(TopMoviesViewModel::class.java)
        binding.lifecycleOwner = this
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = TopMoviesAdapter()
        binding.movieRecyclerView.adapter = adapter
        displaytopMovies()
    }

    private fun displaytopMovies() {
        binding.movieProgressBar.visibility=View.VISIBLE
        var responseLiveData = viewModel.getTopMovies()
        responseLiveData.observe(viewLifecycleOwner) {
            it?.let {
                adapter.setItems(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility=View.GONE

            }
        }
    }
}