package com.example.lecturerapplication.chatlist

import android.annotation.SuppressLint
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pGroup
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lecturerapplication.R
import com.example.lecturerapplication.models.ChatContentModel
import com.example.lecturerapplication.peerlist.PeerListAdapter

class ChatListAdapter: RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {
    private val chatList:MutableList<ChatContentModel> = mutableListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageView: TextView = itemView.findViewById(R.id.tvMessage)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chatList[position]
        (holder.messageView.parent as RelativeLayout).gravity = if (chat.senderIp=="192.168.49.1") Gravity.END else Gravity.START
        holder.messageView.text = chat.message
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    fun addItemToEnd(contentModel: ChatContentModel){
        chatList.add(contentModel)
        notifyItemInserted(chatList.size)
    }
}