package edu.dongyang.cs.myapplication

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.buy_list.view.*

class BuyListAdapter(val clickListener: (BuyList) -> Unit) : RecyclerView.Adapter<BuyListAdapter.TaskViewHolder>() {

    var items : MutableList<BuyList> = mutableListOf() //컬렉션 동적 리스트0

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.buy_list, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        Log.d("onBindViewholder", ""+position)
        holder.BuyListName.text = items[position].name
        holder.BuyListPrice.text = items[position].price
        (holder as TaskViewHolder).bind(items[position], clickListener)


    }

    fun addItem(item: BuyList) {
        items.add(item)
        notifyDataSetChanged()
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var BuyListName: TextView = itemView?.tv_buy_name
        var BuyListPrice: TextView = itemView?.tv_buy_price
        fun bind(buy: BuyList, clickListener: (BuyList) -> Unit){
            itemView.setOnClickListener {
                clickListener(buy)
            }
        }
    }


}


