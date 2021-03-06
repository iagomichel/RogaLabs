package br.com.iagomichel.rogalabs.ui.posts

import br.com.iagomichel.rogalabs.models.Post

interface PostsContract {

    interface View {
        fun onFetchedData(posts: List<Post>)
        fun showLoading(isLoading: Boolean)

        fun onDetailClick(idPost: Int, postTitle: String)
    }

    interface Presenter {
        infix fun attach(view: View)
        fun fetchListPosts()
    }
}
