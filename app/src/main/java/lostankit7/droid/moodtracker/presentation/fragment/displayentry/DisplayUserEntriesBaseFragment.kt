package lostankit7.droid.moodtracker.presentation.fragment.displayentry

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import lostankit7.droid.moodtracker.R
import lostankit7.droid.moodtracker.base.fragment.BaseDaggerFragment
import lostankit7.droid.moodtracker.common.di.utils.InjectUtils
import lostankit7.droid.moodtracker.data_layer.database.entities.UserEntry
import lostankit7.droid.moodtracker.databinding.FragmentDisplayUserEntriesBinding
import lostankit7.droid.moodtracker.presentation.adapter.RvUserEntriesAdapter
import lostankit7.droid.moodtracker.presentation.viewmodel.UserEntriesViewModel

abstract class DisplayUserEntriesBaseFragment : BaseDaggerFragment<FragmentDisplayUserEntriesBinding, UserEntriesViewModel>() {

    protected val adapter = RvUserEntriesAdapter(::onItemClicked)

    override fun initRecyclerView() {
        binding.rvUserEntries.adapter = adapter
    }

    private fun onItemClicked(menuItem: MenuItem, userEntry: UserEntry): Boolean {
        return when (menuItem.itemId) {
            R.id.edit -> {
                //todo edit
                true
            }
            R.id.delete -> {
                viewModel.deleteUserEntry(userEntry)
                true
            }
            else -> false
        }
    }

    override fun inflateLayout(layoutInflater: LayoutInflater) =
        FragmentDisplayUserEntriesBinding.inflate(layoutInflater)

    override fun injectFragment() {
        DaggerAppComponent
            .builder()
            .baseComponent(InjectUtils.provideBaseComponent(
                activity?.applicationContext ?: error(""))
            ).build()
            .inject(this)
    }

    override fun initiateViewModel(viewModelProvider: ViewModelProvider) =
        viewModelProvider[UserEntriesViewModel::class.java]
}