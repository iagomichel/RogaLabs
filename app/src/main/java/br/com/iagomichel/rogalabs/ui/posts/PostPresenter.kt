package br.com.iagomichel.rogalabs.ui.posts

import br.com.iagomichel.rogalabs.api.RogaAPIServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class PostPresenter: PostsContract.Presenter{

    private var _view: PostsContract.View? = null

    override fun attach(view: PostsContract.View) {
        this._view = view
    }

    override fun fetchListPosts() {
        CoroutineScope(IO).launch {
            _view?.showLoading(true)
            val response = RogaAPIServiceInterface.create().fetchPosts()

            _view?.showLoading(false)
            _view?.onFetchedData(response)
        }
    }
}
