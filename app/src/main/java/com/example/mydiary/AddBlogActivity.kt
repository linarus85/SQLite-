package com.example.mydiary

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.mydiary.database.Entity
import com.example.mydiary.database.ManagerDatabase
import com.example.mydiary.database.TableDatabase
import com.example.mydiary.databinding.ActivityAddBlogBinding

class AddBlogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBlogBinding
    val imageRequestCode = 10
    private var emptyOrImageUri  = "empty"
    val manager = ManagerDatabase(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val db  = TableDatabase.getDb(this)
        db.dao().getAll().asLiveData().observe(this){

        }
        binding.addImageBtn.setOnClickListener {giveImage() }
        binding.buttonAddBlog.setOnClickListener {
            val blog = Entity(
                null,
                binding.editTextTitle.text.toString(),
                binding.editTextDescription.text.toString(),
                emptyOrImageUri

            )
            Thread{
                db.dao().insert(blog)
            }.start()
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == imageRequestCode) {
            binding.imageViewBlog.setImageURI(data?.data)
            emptyOrImageUri = data?.data.toString()
        }
    }

    private fun giveImage() {
        binding.cardViewImage.visibility = View.VISIBLE
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, imageRequestCode)
    }

//    fun saveBlog() {
//        val title = binding.editTextTitle.text.toString()
//        val description = binding.editTextDescription.text.toString()
//        if (title.isNotEmpty() && description.isNotEmpty()) {
//            manager.insertToDb(title, description, emptyOrImageUri)
//        }
//    }

}