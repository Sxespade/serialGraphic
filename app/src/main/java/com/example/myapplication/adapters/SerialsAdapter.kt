package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.mvp.view.SerialItemView
import com.example.myapplication.mvp.view.IUserListPresenter
import com.example.myapplication.mvp.view.image.GlideImageLoader

class SerialsAdapter(private val presenter: IUserListPresenter) :
    RecyclerView.Adapter<SerialsAdapter.ViewHolder>() {

    private val imageLoader = GlideImageLoader()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val userView: View = inflater.inflate(R.layout.item_user, parent, false)
        return ViewHolder(userView)
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.count = position
        holder.itemView.setOnClickListener { presenter.onItemClick(holder) }
        presenter.bindView(holder)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        SerialItemView {
        var textView: TextView
        var avatarView: ImageView
        var count: Int = 0


        override fun setLogin(text: String?) {
            textView.text = text
        }

        override fun loadAvatar(url: String?) {
            imageLoader.loadImage(
                url,
                avatarView
            )
        }

        override fun getPos(): Int {
            return count
        }


        init {
            textView = itemView.findViewById<View>(R.id.tv_login) as TextView
            avatarView =
                itemView.findViewById<View>(R.id.iv_avatar) as ImageView
        }
    }

}