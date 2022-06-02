package br.com.iagomichel.rogalabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.viewProvider
import br.com.iagomichel.rogalabs.models.Post
import br.com.iagomichel.rogalabs.ui.detail.PostDetailDialogFragment
import br.com.iagomichel.rogalabs.ui.posts.PostsContract
import br.com.iagomichel.rogalabs.ui.posts.PostsRecycleAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), PostsContract.View {

    @Inject lateinit var presenter: PostsContract.Presenter

    private val pbLoading: ProgressBar by viewProvider(
        R.id.pb_loading
    )
    private val rvPosts: RecyclerView by viewProvider(
        R.id.rv_posts
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter attach this
        presenter.fetchListPosts()
    }

    override fun onFetchedData(posts: List<Post>) {
        runOnUiThread {
            with(rvPosts) {
                visibility = View.VISIBLE
                adapter = PostsRecycleAdapter(posts, this@MainActivity)
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    override fun showLoading(isLoading: Boolean) {
        runOnUiThread {
            pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    override fun onDetailClick(idPost: Int, postTitle: String) {
        PostDetailDialogFragment
            .newInstance(idPost, postTitle)
            .show(supportFragmentManager, "PostDetailDialogFragment")

        //Toast.makeText(this, "xclicou $idPost", Toast.LENGTH_SHORT).show()
    }
}
