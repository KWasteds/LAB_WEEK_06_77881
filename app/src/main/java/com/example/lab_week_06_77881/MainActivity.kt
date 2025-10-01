package com.example.lab_week_06_77881

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab_week_06_77881.model.GlideImageLoader
import kotlin.getValue
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06_77881.R
import com.example.lab_week_06_77881.model.CatAdapter
import com.example.lab_week_06_77881.model.CatModel
import com.example.lab_week_06_77881.model.Gender
import com.example.lab_week_06_77881.model.CatBreed
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper



class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
    //Glide is used here to load the images
    //Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        //Setup the layout manager for the recycler view
        //A layout manager is used to set the structure of the item views
        //For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        //Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Tommy", "Sleeps all day", "https://cdn2.thecatapi.com/images/a6p.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Luna", "Queen of chaos", "https://cdn2.thecatapi.com/images/bpc.jpg"),
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Shadow", "Silent observer", "https://cdn2.thecatapi.com/images/b1c.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Chloe", "Snack hunter", "https://cdn2.thecatapi.com/images/cdq.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Max", "The fluffy destroyer", "https://cdn2.thecatapi.com/images/d5s.jpg"),
                CatModel(Gender.Unknown, CatBreed.BalineseJavanese, "Misty", "No one knows", "https://cdn2.thecatapi.com/images/e35.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Bella", "Royal guardian", "https://cdn2.thecatapi.com/images/f9p.jpg")
            )
        )

    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            //Set the title for the dialog
            .setTitle("Cat Selected")

            //Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")

            //Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}
