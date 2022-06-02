package br.com.iagomichel.rogalabs.di

import br.com.iagomichel.rogalabs.ui.posts.PostPresenter
import br.com.iagomichel.rogalabs.ui.posts.PostsContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RogaModuleActivity {
    @Provides
    fun providePostPresenter(): PostsContract.Presenter {
        return PostPresenter()
    }
}
