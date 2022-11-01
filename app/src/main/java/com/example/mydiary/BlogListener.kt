package com.example.mydiary

import com.example.mydiary.database.Entity

interface BlogListener {
    fun onClickToBlog(blog: Entity)
}