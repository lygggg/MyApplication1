package edu.dongyang.cs.myapplication

import android.content.ClipData
import android.content.Context
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_review.view.*
import kotlinx.android.synthetic.main.item_review.view.*
import org.jetbrains.anko.image
import org.jetbrains.anko.imageBitmap
import org.jetbrains.anko.sdk25.coroutines.onClick

class ReviewListAdapter : RecyclerView.Adapter<ReviewListAdapter.ListViewHolder>(){
    var items : MutableList<Buyreview> = mutableListOf()


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ListViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.tvReviewTitle.text = items[position].title
        holder.tvRatingBar.rating = items[position].ratingbar
        holder.tvReviewImageView.image = items[position].reviewImage
        holder.tvReviewmodify.setOnCreateContextMenuListener(holder)



    }
    fun addItem1(itemPosition: Int, item: Buyreview){
        items.add(itemPosition, item)
        notifyDataSetChanged()
    }
    fun addItem(item: Buyreview){
        items.add(item)
        notifyDataSetChanged()
    }
    fun removeItem(itemPosition: Int){
        items.removeAt(itemPosition)
        notifyDataSetChanged()
    }


    class ListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView),
            View.OnCreateContextMenuListener{

        override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            Log.d("test", "onCreateContextMenu")
            var Edit = menu?.add(Menu.NONE,R.id.modify_dialog, 1, "편집")
            var Delete = menu?.add(Menu.NONE,R.id.remove_dialog, 2, "삭제")
            Log.d("TAG", "메세지" +"menu")

        }


        var tvReviewTitle: TextView = itemView.tv_task_name
        var tvRatingBar : RatingBar = itemView.tv_mainRb
        var tvReviewImageView : ImageView = itemView.tv_task_image
        var tvReviewmodify : ConstraintLayout = itemView.cl_review











    }

}