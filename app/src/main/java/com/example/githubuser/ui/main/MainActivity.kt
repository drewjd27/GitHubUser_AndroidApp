package com.example.githubuser.ui.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuser.R
import com.example.githubuser.data.model.User
import com.example.githubuser.databinding.ActivityMainBinding
import com.example.githubuser.ui.detail.DetailUserActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter()
        adapter.notifyDataSetChanged()

        adapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                Intent(this@MainActivity, DetailUserActivity::class.java).also {
                    it.putExtra(DetailUserActivity.EXTRA_USERNAME, data.login)
                    startActivity(it)
                }
            }

        })
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(UserViewModel::class.java)


        binding.apply {
            rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUsers.setHasFixedSize(true)
            rvUsers.adapter = adapter

            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
            searchView.queryHint = resources.getString(R.string.searchbar_placeholder)
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
//                    Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                    searchUser()
                    searchView.clearFocus()
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
        viewModel.getSearchUsers().observe(this, {
            if (it != null) {
                adapter.setList(it)
                showNoSearch(false)
                showLoading(false)
            }
        })
    }

    private fun searchUser() {
        binding.apply {
            val querySearch = searchView.query.toString()
            if (querySearch.isEmpty()) return
            showLoading(true)
            viewModel.setSearchUsers(querySearch)
        }
    }

    private fun showNoSearch(stateNoSearch: Boolean) {
        if (stateNoSearch) {
            binding.noSearch.itemNoSearch.visibility = View.VISIBLE
        } else {
            binding.noSearch.itemNoSearch.visibility = View.GONE
        }
    }

    private fun showLoading(stateLoading: Boolean) {
        if (stateLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}