package com.example.myapplication2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.adapter.ItemRecyclerViewAdapter
import com.example.myapplication2.model.ItemModel

class MainActivity : AppCompatActivity() {
    private val itemList=ArrayList<ItemModel>()
    private lateinit var ItemRecyclerViewAdapter: ItemRecyclerViewAdapter
    private lateinit var ItemRecyclerView: RecyclerView
    private lateinit var endTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }
    private fun initUI(){
        val books = arrayOf("The Godfather", "Jurassic Park", "The Shining", "Forrest Gump", "The Lord of the Rings", "Harry Potter and the Philosopher's Stone", "The Silence of the Lambs", "The Hunger Games", "To Kill a Mockingbird", "The Chronicles of Narnia: The Lion, the Witch and the Wardrobe", "Gone Girl", "The Girl with the Dragon Tattoo", "The Da Vinci Code", "The Hobbit", "Life of Pi", "The Perks of Being a Wallflower", "The Fault in Our Stars", "Ready Player One", "Divergent", "The Maze Runner")
        val authors = arrayOf("Mario Puzo", "Michael Crichton", "Stephen King", "Winston Groom", "J.R.R. Tolkien", "J.K. Rowling", "Thomas Harris", "Suzanne Collins", "Harper Lee", "C.S. Lewis", "Gillian Flynn", "Stieg Larsson", "Dan Brown", "J.R.R. Tolkien", "Yann Martel", "Stephen Chbosky", "John Green", "Ernest Cline", "Veronica Roth", "James Dashner")
        val images = arrayOf(R.drawable.batman, R.drawable.bb, R.drawable.daredevil, R.drawable.ghostrider, R.drawable.gojo, R.drawable.goku, R.drawable.heisenberg, R.drawable.johnwick, R.drawable.joker, R.drawable.oppie, R.drawable.peakyblinders, R.drawable.sukuna, R.drawable.thanos, R.drawable.vegeta, R.drawable.vengence,R.drawable.flash,R.drawable.darkseid,R.drawable.levi,R.drawable.bcs,R.drawable.boys)
        ItemRecyclerView=findViewById(R.id.recyclerView)
        endTextView = findViewById(R.id.end)
        ItemRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) {
                    endTextView.visibility = View.VISIBLE
                } else {
                    endTextView.visibility = View.GONE
                }
            }
        })
        ItemRecyclerView.layoutManager=LinearLayoutManager(this)
        for (i in 0..<authors.size){
            itemList.add(ItemModel("${i+1})",image=images[i],books[i],authors[i]))
        }
        ItemRecyclerViewAdapter=ItemRecyclerViewAdapter(itemList)
        ItemRecyclerView.adapter=ItemRecyclerViewAdapter
    }
}