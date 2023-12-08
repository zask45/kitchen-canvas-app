/*
ANGGOTA:

1. Keysha Zascha Medina 09021282126108
2. Haji RiskY 09021282126097
3. M Agil Faturrahman 09021282126110
4. Deva Saumena 09021182126032
5. Al Amin 09021282126095

* */

package com.example.kitchencanvas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitchencanvas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvRecentRecipe: RecyclerView
    private val recentRecipeList = ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvRecentRecipe = binding.rvRecentRecipe
        rvRecentRecipe.setHasFixedSize(true)
        rvRecentRecipe.setNestedScrollingEnabled(false)

        // ambil semua data recent recipe
        recentRecipeList.addAll(getRecipe(recentRecipeList))

        // panggil fungsi show recent recipe ()
        showRecyclerView()

        // define aksi saat tiap kategori di klik
        binding.japan.setOnClickListener(this)
        binding.western.setOnClickListener(this)
        binding.nusantara.setOnClickListener(this)
        binding.vegan.setOnClickListener(this)

    }

    private fun showRecyclerView() {
        rvRecentRecipe.layoutManager = LinearLayoutManager(this)
        rvRecentRecipe.adapter = RecentRecipeAdapter(recentRecipeList)
    }

    private fun getRecipe(recipeList: ArrayList<Recipe>): ArrayList<Recipe> {
        val titles = resources.getStringArray(R.array.recent_recipes_titles_arr)
        val shortDesc = resources.getStringArray(R.array.recent_recipe_short_desc)
        val descriptions = resources.getStringArray(R.array.recent_recipe_desc_arr)
        val ingredients = resources.getStringArray(R.array.recent_recipe_ingredients_arr)
        val tools = resources.getStringArray(R.array.recent_recipe_tools_arr)
        val steps = resources.getStringArray(R.array.recent_recipe_steps)
        val photo = resources.obtainTypedArray(R.array.recent_recipe_drawable_arr)

        for (i in 0..titles.size - 1) {
            val recipe = Recipe(
                titles[i],
                shortDesc[i],
                descriptions[i],
                ingredients[i],
                tools[i],
                steps[i],
                photo.getResourceId(i, -1))

            recipeList.add(recipe)
        }

        return recipeList
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.japan -> {
                val intent = Intent(this@MainActivity, CategoryActivity::class.java)
                intent.putExtra(CategoryActivity.EXTRA_TITLES, R.array.japan_titles_arr)
                intent.putExtra(CategoryActivity.EXTRA_SHORT_DESC, R.array.japan_recipe_short_desc)
                intent.putExtra(CategoryActivity.EXTRA_DESC, R.array.japan_recipe_desc_arr)
                intent.putExtra(CategoryActivity.EXTRA_INGREDIENTS, R.array.japan_recipe_ingredients_arr)
                intent.putExtra(CategoryActivity.EXTRA_TOOLS, R.array.japan_recipe_tools_arr)
                intent.putExtra(CategoryActivity.EXTRA_STEPS, R.array.japan_recipe_steps)
                intent.putExtra(CategoryActivity.EXTRA_PHOTOS, R.array.japan_drawable_arr)
                intent.putExtra(CategoryActivity.EXTRA_CATEGORY, "japan")
                startActivity(intent)
            }

            R.id.vegan -> {
                val intent = Intent(this@MainActivity, CategoryActivity::class.java)
                intent.putExtra(CategoryActivity.EXTRA_TITLES, R.array.vegan_titles_arr)
                intent.putExtra(CategoryActivity.EXTRA_SHORT_DESC, R.array.vegan_recipe_short_desc)
                intent.putExtra(CategoryActivity.EXTRA_DESC, R.array.vegan_recipe_desc_arr)
                intent.putExtra(CategoryActivity.EXTRA_INGREDIENTS, R.array.vegan_recipe_ingredients_arr)
                intent.putExtra(CategoryActivity.EXTRA_TOOLS, R.array.vegan_recipe_tools_arr)
                intent.putExtra(CategoryActivity.EXTRA_STEPS, R.array.vegan_recipe_steps)
                intent.putExtra(CategoryActivity.EXTRA_PHOTOS, R.array.vegan_drawable_arr)
                intent.putExtra(CategoryActivity.EXTRA_CATEGORY, "vegan")
                startActivity(intent)
            }

            R.id.western -> {
                val intent = Intent(this@MainActivity, CategoryActivity::class.java)
                intent.putExtra(CategoryActivity.EXTRA_TITLES, R.array.western_titles_arr)
                intent.putExtra(CategoryActivity.EXTRA_SHORT_DESC, R.array.western_recipe_short_desc)
                intent.putExtra(CategoryActivity.EXTRA_DESC, R.array.western_recipe_desc_arr)
                intent.putExtra(CategoryActivity.EXTRA_INGREDIENTS, R.array.western_recipe_ingredients_arr)
                intent.putExtra(CategoryActivity.EXTRA_TOOLS, R.array.western_recipe_tools_arr)
                intent.putExtra(CategoryActivity.EXTRA_STEPS, R.array.western_recipe_steps)
                intent.putExtra(CategoryActivity.EXTRA_PHOTOS, R.array.western_drawable_arr)
                intent.putExtra(CategoryActivity.EXTRA_CATEGORY, "western")
                startActivity(intent)
            }

            R.id.nusantara -> {
                val intent = Intent(this@MainActivity, CategoryActivity::class.java)
                intent.putExtra(CategoryActivity.EXTRA_TITLES, R.array.nusantara_titles_arr)
                intent.putExtra(CategoryActivity.EXTRA_SHORT_DESC, R.array.nusantara_recipe_short_desc)
                intent.putExtra(CategoryActivity.EXTRA_DESC, R.array.nusantara_recipe_desc_arr)
                intent.putExtra(CategoryActivity.EXTRA_INGREDIENTS, R.array.nusantara_recipe_ingredients_arr)
                intent.putExtra(CategoryActivity.EXTRA_TOOLS, R.array.nusantara_recipe_tools_arr)
                intent.putExtra(CategoryActivity.EXTRA_STEPS, R.array.nusantara_steps)
                intent.putExtra(CategoryActivity.EXTRA_PHOTOS, R.array.nusantara_drawable_arr)
                intent.putExtra(CategoryActivity.EXTRA_CATEGORY, "nusantara")
                startActivity(intent)
            }
        }
    }
}