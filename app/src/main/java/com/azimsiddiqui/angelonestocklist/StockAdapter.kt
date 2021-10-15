package com.azimsiddiqui.angelonestocklist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.azimsiddiqui.angelonestocklist.databinding.ItemStockRowBinding
import com.azimsiddiqui.angelonestocklist.models.Stock
import javax.inject.Inject

class StockAdapter @Inject constructor(private val stockOnClick: StockOnClick):RecyclerView.Adapter<StockAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemStockRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Stock>() {
        override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem.securityCode == newItem.securityCode
        }

        override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    private var stockList: List<Stock>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemStockRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentStock = stockList[position]

        holder.binding.apply {
            securityId.text = currentStock.securityId
            securityName.text=currentStock.securityName

        }
        holder.binding.root.setOnClickListener{
            stockOnClick.onClickStock(currentStock)
        }
       // stockOnClick.onClickStock(currentStock)
    }

    override fun getItemCount() = stockList.size

    fun setData(stockList: List<Stock>){
        this.stockList = stockList
    }
}