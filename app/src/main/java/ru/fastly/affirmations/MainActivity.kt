package ru.fastly.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.fastly.affirmations.data.Datasource
import ru.fastly.affirmations.databinding.ActivityMainBinding
import ru.fastly.affirmations.item_adapter.MyCustomAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myDataset = Datasource().loadAffirmations()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = MyCustomAdapter(this, myDataset) {
            Toast.makeText(this, this.resources.getString(it.stringResourceId), Toast.LENGTH_LONG).show()
        }
        recyclerView.setHasFixedSize(true)

    }
}