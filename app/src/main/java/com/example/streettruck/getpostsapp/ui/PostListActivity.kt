package com.example.streettruck.getpostsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streettruck.databinding.ActivityPostListBinding
import com.example.streettruck.getpostsapp.service.RetrofitInstancePostList
import com.example.streettruck.getpostsapp.ui.utils.PostListAdapter
import retrofit2.HttpException
import java.io.IOException

class PostListActivity : AppCompatActivity() {
    private lateinit var postListAdapter: PostListAdapter
    private lateinit var binding: ActivityPostListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPostListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView() // Calling the view

        lifecycleScope.launchWhenCreated {
            binding.progressBarPostList.isVisible = true // Show Progress Bar

            val response = try {
                RetrofitInstancePostList.api.getPosts() // Getting List of Posts Data
            } catch (e:IOException){
                Log.d("PostListActivity", "You may have no internet connection")
                binding.progressBarPostList.isVisible = false // Disable Progress Bar
                return@launchWhenCreated
            } catch (e:HttpException){
                Log.d("PostListActivity", "Unexpected Response")
                binding.progressBarPostList.isVisible = false // Disable Progress Bar
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null){
                postListAdapter.posts = response.body()!!
            }else {
                Log.d("PostListActivity", "Response is not successful")
            }
            binding.progressBarPostList.isVisible = false // Disable Progress Bar

        }
    }

    private fun setupRecyclerView() = binding.rvPostList.apply {

        postListAdapter = PostListAdapter()
        adapter = postListAdapter
        layoutManager = LinearLayoutManager(this@PostListActivity)
    }
}