package com.azimsiddiqui.angelonestocklist.ui

import android.icu.lang.UCharacter.IndicPositionalCategory.NA
import android.icu.text.UnicodeSet.EMPTY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.azimsiddiqui.angelonestocklist.R
import com.azimsiddiqui.angelonestocklist.databinding.ActivityStockDetailBinding
import com.azimsiddiqui.angelonestocklist.helper.STOCK_ITEM
import com.azimsiddiqui.angelonestocklist.models.Stock
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStockDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stock_detail)

        val data = intent.extras?.getParcelable<Stock>(STOCK_ITEM)
        setupUI(data)

    }


    private fun setupUI(data: Stock?) {

        data?.let {
            with(binding) {
                tvSecurityCode.text = it.securityCode.toString()
                tvIssuerName.text = it.issuerName
                tvSecurityId.text = it.securityId
                tvSecurityName.text = it.securityName
                tvStatus.text = it.status
                tvGroup.text = it.group
                tvFaceValue.text = it.faceValue.toString()
                tvIsinNo.text = it.iSINNo
                tvIndustry.text = it.industry
                tvInstrument.text = it.instrument

            }
        }

    }
}