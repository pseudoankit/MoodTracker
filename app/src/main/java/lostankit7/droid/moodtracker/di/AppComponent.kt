package lostankit7.droid.moodtracker.di

import dagger.Component
import lostankit7.droid.moodtracker.data_layer.di.module.DataBaseModule
import lostankit7.droid.moodtracker.presentation.fragment.addentry.AddMoodEntryFragment
import lostankit7.droid.moodtracker.presentation.fragment.addentry.AddTaskEntryFragment
import lostankit7.droid.moodtracker.presentation.fragment.displayentry.DisplayUserEntriesBaseFragment
import lostankit7.droid.moodtracker.presentation.fragment.edit.editmood.DisplayMoodIconsFragment
import lostankit7.droid.moodtracker.presentation.fragment.edit.editmood.UpsertMoodIconFragment
import lostankit7.droid.moodtracker.presentation.fragment.edit.edittask.DisplayTaskCategoriesFragment
import lostankit7.droid.moodtracker.presentation.fragment.edit.edittask.DisplayTasksOfCategoryFragment
import lostankit7.droid.moodtracker.presentation.fragment.edit.edittask.UpsertTaskIconFragment
import lostankit7.droid.moodtracker.presentation.fragment.home.MoreFragment
import lostankit7.droid.moodtracker.presentation.fragment.splash.SplashFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [DataBaseModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(frag: SplashFragment)
    fun inject(frag: DisplayUserEntriesBaseFragment)
    fun inject(frag: AddMoodEntryFragment)
    fun inject(frag: AddTaskEntryFragment)
    fun inject(frag: UpsertMoodIconFragment)
    fun inject(frag: UpsertTaskIconFragment)
    fun inject(frag: DisplayMoodIconsFragment)
    fun inject(frag: DisplayTasksOfCategoryFragment)
    fun inject(frag: DisplayTaskCategoriesFragment)
    fun inject(moreFragment: MoreFragment)
}
