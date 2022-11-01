package com.example.mydiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mydiary.database.Entity
import com.example.mydiary.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val content = intent.getSerializableExtra("content") as Entity
        binding.apply {
            Glide
                .with(imageViewBlogContent)
                .load(content.imageUri)
                .centerCrop()
                .placeholder(R.drawable.ayano)
                .into(imageViewBlogContent);
            tvTitle.text = content.title
            tvDescription.text = content.description
        }
    }
}