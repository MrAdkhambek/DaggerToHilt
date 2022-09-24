package me.adkhambek.dh.di.component

import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope
import me.adkhambek.dh.MainActivity

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@ActivityScope
@Subcomponent(
    modules = [
        ActivityModule::class,
    ],
)
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {

        fun build(): ActivityComponent

        @BindsInstance
        fun activity(activity: MainActivity): Builder
    }
}

@Module
class ActivityModule