package me.adkhambek.dh.di.component

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.adkhambek.dh.R


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAppName(
        @ApplicationContext context: Context
    ): String {
        return context.getString(R.string.app_name)
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface BindModule