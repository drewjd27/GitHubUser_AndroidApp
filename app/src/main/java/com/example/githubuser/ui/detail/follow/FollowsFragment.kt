package com.example.githubuser.ui.detail.follow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.data.model.UserResponse
import com.example.githubuser.databinding.FragmentFollowsBinding
import com.example.githubuser.ui.detail.DetailViewModel
import com.example.githubuser.ui.main.UserAdapter
import com.example.githubuser.utils.Result

class FollowsFragment : Fragment() {

    private var binding: FragmentFollowsBinding? = null
    private val adapter by lazy {
        UserAdapter {

        }
    }

    private val viewModel by activityViewModels<DetailViewModel>()
    var type = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rvFollows?.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
            adapter = this@FollowsFragment.adapter
        }

        when(type) {
            FOLLOWERS -> {
               viewModel.resultFollowersUser.observe(viewLifecycleOwner, this::manageResultFollows)
            }

            FOLLOWING -> {
                viewModel.resultFollowingUser.observe(viewLifecycleOwner, this::manageResultFollows)
            }
        }
    }

    private fun manageResultFollows(state: Result) {
        when (state) {
            is Result.Success<*> -> {
                val data = state.data as MutableList<UserResponse.Item>
                adapter.setData(data)
//                adapter.setData(state.data as MutableList<UserResponse.Item>)
            }
            is Result.Error -> {
                Toast.makeText(requireActivity(), state.exception.message.toString(), Toast.LENGTH_SHORT).show()
            }
            is Result.Loading -> {
                binding?.progressBar?.isVisible = state.isLoading
            }
        }
    }

    companion object {
        const val FOLLOWING = 0
        const val FOLLOWERS = 1

        fun newInstance(type: Int) = FollowsFragment()
            .apply {
                this.type = type
            }
    }
}