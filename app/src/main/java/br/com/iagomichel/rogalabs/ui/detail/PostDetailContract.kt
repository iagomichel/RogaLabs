package br.com.iagomichel.rogalabs.ui.detail

import br.com.iagomichel.rogalabs.models.PostComment

interface PostDetailContract {

    interface View {
        fun onFetchedData(comments: List<PostComment>)
        fun showLoading(isLoading: Boolean)
    }

    interface Presenter {
        infix fun attach(view: View)
        fun fetchListComments(postId: Int)
    }
}