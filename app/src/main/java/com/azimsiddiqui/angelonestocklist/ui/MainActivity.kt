package com.azimsiddiqui.angelonestocklist.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azimsiddiqui.angelonestocklist.R
import com.azimsiddiqui.angelonestocklist.StockAdapter
import com.azimsiddiqui.angelonestocklist.StockOnClick
import com.azimsiddiqui.angelonestocklist.databinding.ActivityMainBinding
import com.azimsiddiqui.angelonestocklist.helper.STOCK_ITEM
import com.azimsiddiqui.angelonestocklist.models.Stock
import com.azimsiddiqui.angelonestocklist.viewModel.StockListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), StockOnClick {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: StockListViewModel by viewModels()
    private lateinit var stockAdapter: StockAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.getStocks()
        initRecyclerView(binding.stockRecyclerView)
        observeLiveEvents()
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        stockAdapter = StockAdapter(this)
        recyclerView.apply {
            adapter = stockAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

    private fun observeLiveEvents() {

        viewModel.stockListLiveData.observe(this, { stockList ->
            stockList.let {
                stockAdapter.setData(it)
                Log.d("stocks", it.toString())
            }
        })
    }

    override fun onClickStock(stock: Stock) {
        var intent=Intent(this, StockDetailActivity::class.java)
        val bundle=Bundle()
        bundle.putParcelable(STOCK_ITEM,stock)
        intent.putExtras(bundle)
//     val startActivityIntent=Intent(this,StockDetailActivity::class.java)
//        startActivityIntent.putExtra(STOCK_ITEM,stock)
        startActivity(intent)
    }
}