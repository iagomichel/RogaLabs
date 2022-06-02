package br.com.iagomichel.rogalabs.ui.detail

import br.com.iagomichel.rogalabs.api.RogaAPIServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostDetailPresenter: PostDetailContract.Presenter {

    private var _view: PostDetailContract.View? = null

    override fun attach(view: PostDetailContract.View) {
        this._view = view
    }

    override fun fetchListComments(postId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            _view?.showLoading(true)
            val response = RogaAPIServiceInterface.create().fetchDetailPosts(postId)

            _view?.showLoading(false)
            _view?.onFetchedData(response)
        }
    }
}
