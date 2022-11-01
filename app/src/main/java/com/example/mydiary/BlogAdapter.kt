package com.example.mydiary

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydiary.database.Entity
import com.example.mydiary.database.TableDatabase
import com.example.mydiary.databinding.BlogsItemBinding

class BlogAdapter(val blogListener: BlogListener) :
    RecyclerView.Adapter<BlogAdapter.Holder>() {
    val blogList = ArrayList<Entity>()


    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = BlogsItemBinding.bind(view)
        fun bind(blog: Entity, blogListener: BlogListener) = with(binding) {
            Glide
                .with(imageViewBlogItem)
                .load(blog.imageUri)
                .centerCrop()
                .placeholder(R.drawable.ayano)
                .into(imageViewBlogItem);
            textViewTitleItem.text = blog.title
            itemView.setOnClickListener {
                blogListener.onClickToBlog(blog)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.blogs_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(blogList[position], blogListener)
    }

    override fun getItemCount(): Int = blogList.size

    fun addBlog(blog: Entity) {
        blogList.add(blog)
        notifyDataSetChanged()
    }
}