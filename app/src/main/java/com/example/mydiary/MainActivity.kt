package com.example.mydiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydiary.database.Entity
import com.example.mydiary.database.ManagerDatabase
import com.example.mydiary.database.TableDatabase
import com.example.mydiary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BlogListener {
    val manager = ManagerDatabase(this)
    private lateinit var binding: ActivityMainBinding
    private val adapter = BlogAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getBlog()
        binding.addBlog.setOnClickListener { openAddBlogPage() }
    }


    private fun openAddBlogPage() {
        val i = Intent(this, AddBlogActivity::class.java)
        startActivity(i)
    }

    private fun getBlog() {
        binding.apply {
            rvBlogs.layoutManager = LinearLayoutManager(this@MainActivity)
            rvBlogs.adapter = adapter
            val db = TableDatabase.getDb(this@MainActivity)
            db.dao().getAll().asLiveData().observe(this@MainActivity) {
                it.forEach { blogs ->
                    adapter.addBlog(blogs)
                }
            }
        }
    }

    override fun onClickToBlog(blog: Entity) {
        startActivity(Intent(this, ContentActivity::class.java)
            .apply {
                putExtra("content", blog)
            })
    }


}
