package com.example.streettruck.getpostsapp.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.streettruck.databinding.ItemPostBinding
import com.example.streettruck.getpostsapp.model.Post

class PostListAdapter :RecyclerView.Adapter<PostListAdapter.PostListViewHolder>() {

    inner class PostListViewHolder(val binding: ItemPostBinding):RecyclerView.ViewHolder(binding.root)
    
    private val diffCallback = object : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
           return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallback)

    var posts : List<Post>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        return PostListViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        holder.binding.apply {
            var singlePost = posts[position]
            txPostTitle.text = singlePost.title
            txPostBody.text = singlePost.body
        }
    }

    override fun getItemCount() = posts.size
}