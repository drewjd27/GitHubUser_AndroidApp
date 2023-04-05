package com.example.githubuser.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuser.data.model.UserResponse
import com.example.githubuser.databinding.ItemUserBinding

class UserAdapter(
    private val data: MutableList<UserResponse.Item> = mutableListOf(),
    private val listener: (UserResponse.Item) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserResponse.Item) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(item.avatarUrl)
                    .into(ivUserPhoto)
                tvUsername.text = item.login
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener(item)
        }
    }

    fun setData(data: MutableList<UserResponse.Item>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}