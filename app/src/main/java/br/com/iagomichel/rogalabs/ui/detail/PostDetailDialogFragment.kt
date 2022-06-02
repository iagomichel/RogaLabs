package br.com.iagomichel.rogalabs.ui.detail

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.viewProvider
import br.com.iagomichel.rogalabs.R
import br.com.iagomichel.rogalabs.models.PostComment
import br.com.iagomichel.rogalabs.ui.posts.PostsRecycleAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


const val POST_ID = "POST_ID"
const val POST_TITLE = "POST_TITLE"

@AndroidEntryPoint
class PostDetailDialogFragment: DialogFragment(), PostDetailContract.View {

    @Inject lateinit var presenter: PostDetailContract.Presenter

    private val tvTitleToolbar: TextView by viewProvider(
        R.id.tv_title_toolbar
    )
    private val pbLoading: ProgressBar by viewProvider(
        R.id.pb_loading
    )
    private val rvComments: RecyclerView by viewProvider(
        R.id.rv_comments
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_fragment_post_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(POST_TITLE) ?: ""
        val id = arguments?.getInt(POST_ID) ?: 0

        tvTitleToolbar.text = getString(R.string.what_people_commented_about, title)
        presenter attach this
        presenter.fetchListComments(id)
    }

    override fun onFetchedData(comments: List<PostComment>) {
        activity?.runOnUiThread {
            with(rvComments) {
                visibility = android.view.View.VISIBLE
                adapter = PostsDetailRecycleAdapter(comments)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    override fun showLoading(isLoading: Boolean) {
        activity?.runOnUiThread {
            pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    companion object {
        fun newInstance(postId: Int, postTitle: String) =
            PostDetailDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt(POST_ID, postId)
                    putString(POST_TITLE, postTitle)
                }
            }
    }
}
