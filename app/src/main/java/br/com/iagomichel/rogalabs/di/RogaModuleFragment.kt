package br.com.iagomichel.rogalabs.di

import br.com.iagomichel.rogalabs.ui.detail.PostDetailContract
import br.com.iagomichel.rogalabs.ui.detail.PostDetailPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object RogaModuleFragment {
    @Provides
    fun providePostDetailPresenter(): PostDetailContract.Presenter {
        return PostDetailPresenter()
    }
}
