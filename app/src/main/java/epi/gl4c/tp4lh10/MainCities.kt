package epi.gl4c.tp4lh10

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import epi.gl4c.tp4lh10.databinding.ActivityCitiesBinding

class MainCities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // Récupération des tableaux de ressources
        val continents = resources.getStringArray(R.array.Continents)
        val africa = resources.getStringArray(R.array.PaysAfr)
        val europe = resources.getStringArray(R.array.PaysEur)
        val america = resources.getStringArray(R.array.PaysAm)
        val oceania = resources.getStringArray(R.array.PaysOc)
        val asia = resources.getStringArray(R.array.PaysAsie)

        // Configuration de l'adapter pour le Spinner
        val continentsWithEmpty = mutableListOf("").apply {
            addAll(resources.getStringArray(R.array.Continents).toList())
        }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,

            continentsWithEmpty
        )

        val adapter1 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            africa
        )
        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            europe
        )
        val adapter3 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            asia
        )
        val adapter4 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            oceania
        )
        val adapter5 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            america
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner1.adapter = adapter
var selectedContinent=""
        // Gestion de la sélection dans le Spinner
        binding.spinner1.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                 selectedContinent = parent.getItemAtPosition(position).toString()


                when (selectedContinent) {
                    "Afrique" ->  binding.spinner2.adapter=adapter1
                    "Europe" -> binding.spinner2.adapter=adapter2
                    "Amérique" -> binding.spinner2.adapter=adapter3
                    "Océanie" -> binding.spinner2.adapter=adapter4
                    "Asie" ->  binding.spinner2.adapter=adapter5
                }
            }


            override fun onNothingSelected(parent: android.widget.AdapterView<*>) {
                // Action si rien n'est sélectionné
            }
        }
binding.spinner2.onItemSelectedListener= object : android.widget.AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: android.widget.AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
       val selectednation = parent.getItemAtPosition(position).toString()
        Toast.makeText(this@MainCities, " $selectedContinent  $selectednation", Toast.LENGTH_SHORT).show()
        val url = "https://fr.wikipedia.org/wiki/$selectednation"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
    override fun onNothingSelected(parent: android.widget.AdapterView<*>) {
        // Action si rien n'est sélectionné
    }
}
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCountries(countries: Array<String>) {
        // Implémentez ici la logique pour afficher les pays (dans un autre Spinner par exemple)
        // Exemple :
        // val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        // binding.spinner2.adapter = countryAdapter
    }
}