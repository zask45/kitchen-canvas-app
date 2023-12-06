package com.example.kitchencanvas

import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BulletSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchencanvas.databinding.ActivityRecipePageBinding

class RecipePageActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_RECIPE = "extra_recipe"
    }

    private lateinit var binding: ActivityRecipePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Recipe>(EXTRA_RECIPE, Recipe::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Recipe>(EXTRA_RECIPE)
        }

        binding.title.text = recipeData?.name.toString()
        binding.description.text = recipeData?.description.toString()
        binding.bahan.text = recipeData?.ingredients.toString()
        binding.alat.text = recipeData?.tools.toString()
        binding.nasiBaliImage.setImageResource(recipeData!!.photo)

        val itemSteps = recipeData?.steps.toString().split("\n")
        setBulletText(binding.caraMembuat, itemSteps)

    }

    fun setBulletText(textView: TextView, items: List<String>) {
        val builder = StringBuilder()
        for (item in items) {
            builder.append("\u2022").append(item).append("\n")
        }

        val spannableString = SpannableString(builder.toString())
        for (i in items.indices) {
            val start = builder.indexOf(items[i])
            val end = start + items[i].length
            spannableString.setSpan(BulletSpan(10), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        textView.text = spannableString
    }


}