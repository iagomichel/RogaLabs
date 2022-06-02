package br.com.iagomichel.rogalabs.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.iagomichel.rogalabs.R
import br.com.iagomichel.rogalabs.models.Post
import br.com.iagomichel.rogalabs.models.PostComment

class PostsDetailRecycleAdapter(private val comments: List<PostComment>): RecyclerView.Adapter<PostsDetailRecycleAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvName =
            itemView.findViewById<TextView>(R.id.tv_name)
        private val tvEmail =
            itemView.findViewById<TextView>(R.id.tv_email)
        private val tvComment =
            itemView.findViewById<TextView>(R.id.tv_body_comment)

        fun bind(comment: PostComment){
            with(comment) {
                tvName.text = name
                tvEmail.text = email
                tvComment.text = message
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    override fun getItemCount() = comments.size
}
