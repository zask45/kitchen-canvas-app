package com.example.kitchencanvas

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kitchencanvas.RecipePageActivity.Companion.EXTRA_RECIPE

class RecentRecipeAdapter(val recentRecipes: ArrayList<Recipe>) : RecyclerView.Adapter<RecentRecipeAdapter.RecentRecipeViewHolder>() {

    class RecentRecipeViewHolder(itemList: View) : RecyclerView.ViewHolder(itemList) {
        val title: TextView = itemList.findViewById(R.id.recent_recipe_title)
        val description: TextView = itemList.findViewById(R.id.recent_recipe_desc)
        val photo: ImageView = itemList.findViewById(R.id.recent_recipe_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentRecipeViewHolder {
        val itemList: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_item, parent, false)
        return RecentRecipeViewHolder(itemList)
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecentRecipeViewHolder, position: Int) {
        val (title, shortDesc, desc, ingredients, tools, steps, photo) = recentRecipes[position]

        holder.title.text = title.toString()
        holder.description.text = shortDesc.toString()
        holder.photo.setImageResource(photo)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, RecipePageActivity::class.java)
            intent.putExtra(EXTRA_RECIPE, recentRecipes[position])
            holder.itemView.context.startActivity(intent)
        }
    }

}