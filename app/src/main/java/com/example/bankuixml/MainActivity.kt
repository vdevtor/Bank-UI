package com.example.bankuixml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankuixml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterTrasfer: TransferAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterTrasfer = TransferAdapter()
        adapterTrasfer.list = generateList() as MutableList<TransferModel>
        setupRecycler()

    }

    private fun generateList(): List<TransferModel> {
        val client1 =
            TransferModel("Carlos Aburabih", "https://randomuser.me/api/portraits/men/43.jpg")
        val client2 =
            TransferModel("Mia Stephane", "https://randomuser.me/api/portraits/women/81.jpg")
        val client6 = TransferModel(
            "Sofia Charle L Trevor",
            "https://randomuser.me/api/portraits/women/0.jpg"
        )
        val client3 =
            TransferModel("Matheus Rodrigues", "https://randomuser.me/api/portraits/men/34.jpg")
        val client4 = TransferModel("Jason Todd", "https://randomuser.me/api/portraits/men/53.jpg")
        val client5 =
            TransferModel("Daniel San Mendes", "https://randomuser.me/api/portraits/men/52.jpg")

        return listOf(client1, client2, client3, client4, client5, client6)

    }

    private fun setupRecycler() = with(binding) {

        included.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterTrasfer
        }
    }
}