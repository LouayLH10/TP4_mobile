package epi.gl4c.tp4lh10

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import epi.gl4c.tp4lh10.databinding.ActivityCitiesBinding
import epi.gl4c.tp4lh10.databinding.ActivityGridBinding

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGridBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        val cities = arrayOf("TUNIS", "SOUSSE", "GABES", "TOZEUR", "MAHDIA")


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        binding.lste.adapter = adapter


        binding.lste.setOnItemClickListener { parent, view, position, id ->
            val selectedCity = cities[position]

            val url = "http://www.google.fr/search?q=$selectedCity"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }


        setContentView(R.layout.activity_grid)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}