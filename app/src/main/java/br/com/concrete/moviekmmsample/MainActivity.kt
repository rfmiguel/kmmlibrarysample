package br.com.concrete.moviekmmsample

import CustomAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fogaca.shared.MoviesSdk
import br.com.fogaca.shared.data.Response
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val recyclerView: RecyclerView = findViewById(R.id.rv)
        val moviesSdk = MoviesSdk()

        mainScope.launch {
            val movies = moviesSdk.getPopularMovies()
            if (movies is Response.Success) {

                val adapter = CustomAdapter(movies.data.results)
                val llm = LinearLayoutManager(this@MainActivity)
                llm.orientation = LinearLayoutManager.VERTICAL
                recyclerView.layoutManager = llm
                val dividerItemDecoration = DividerItemDecoration(
                    recyclerView.context,
                    llm.orientation
                )
                recyclerView.addItemDecoration(dividerItemDecoration)
                recyclerView.adapter = adapter
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}