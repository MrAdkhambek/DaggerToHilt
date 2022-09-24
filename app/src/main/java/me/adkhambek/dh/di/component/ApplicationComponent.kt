package me.adkhambek.dh.di.component

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope
import me.adkhambek.dh.R

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope


@AppScope
@Component(
    modules = [
        AppModule::class,
        BindModule::class,
    ]
)
interface ApplicationComponent {

    val appName: String
    val activityComponent: ActivityComponent.Builder

//    @Component.Builder
//    interface Builder {
//
//        fun build(): ApplicationComponent
//
//        @BindsInstance
//        fun application(application: Application): Builder
//    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}

@Module
object AppModule {

    @Provides
    fun provideAppName(
        context: Context
    ): String {
        return context.getString(R.string.app_name)
    }
}

@Module
interface BindModule {

    @Binds
    fun bindContext(application: Application): Context
}