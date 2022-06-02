package br.com.iagomichel.rogalabs.ui.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.iagomichel.rogalabs.R
import br.com.iagomichel.rogalabs.models.Post

class PostsRecycleAdapter(private val posts: List<Post>): RecyclerView.Adapter<PostsRecycleAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvTitle =
            itemView.findViewById<TextView>(R.id.tv_title)
        private val tvBody =
            itemView.findViewById<TextView>(R.id.tv_body)

        fun bind(post: Post){
            tvTitle.text = post.title
            tvBody.text = post.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount() = posts.size
}
