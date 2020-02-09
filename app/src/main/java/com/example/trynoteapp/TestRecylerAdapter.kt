package com.example.trynoteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.trynoteapp.models.TestPost
import kotlinx.android.synthetic.main.list_item.view.*

class TestRecylerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items : List<TestPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<TestPost>){
        items = blogList
    }

    class BlogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
         val blogImage = itemView.blog_image
         val blogTitle = itemView.blog_title
         val blogAuthor = itemView.blog_author

        fun bind(testPost: TestPost){
            blogTitle.setText(testPost.title)
            blogAuthor.setText(testPost.user)

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(testPost.image)
                .into(blogImage)
        }
    }
}