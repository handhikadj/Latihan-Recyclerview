package com.example.dika.latihanrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dika.latihanrecyclerview.R
import com.example.dika.latihanrecyclerview.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<BlogPost> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun submitList(blogList: List<BlogPost>) {
        items = blogList
    }

    class BlogViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val blogImage = itemView.blog_image
        val blogTitle = itemView.blog_title
        val blogAuthor = itemView.blog_author

        fun bind(blogPost: BlogPost) {
            blogTitle.text = blogPost.title
            blogAuthor.text = blogPost.username

            val reqOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(reqOptions)
                .load(blogPost.image)
                .into(blogImage)
        }

        companion object {
            fun from(parent: ViewGroup): BlogViewHolder {
                return BlogViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.layout_blog_list_item,
                        parent,
                        false
                    )
                )
            }
        }
    }


}