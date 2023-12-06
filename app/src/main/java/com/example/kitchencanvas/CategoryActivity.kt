package com.example.kitchencanvas

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kitchencanvas.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_TITLES = "extra_titles"
        const val EXTRA_SHORT_DESC = "extra_short_desc"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_INGREDIENTS = "extra_ingredients"
        const val EXTRA_TOOLS = "extra_tools"
        const val EXTRA_STEPS = "extra_steps"
        const val EXTRA_PHOTOS = "extra_photo"
        const val EXTRA_CATEGORY = "extra_category"
    }

    private lateinit var binding: ActivityCategoryBinding
    private lateinit var title: Array<String>
    private lateinit var shortDesc: Array<String>
    private lateinit var desc: Array<String>
    private lateinit var ingredient: Array<String>
    private lateinit var tools: Array<String>
    private lateinit var steps: Array<String>
    private lateinit var photos: TypedArray

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = resources.getStringArray(intent.getIntExtra(EXTRA_TITLES, -1))
        shortDesc = resources.getStringArray(intent.getIntExtra(EXTRA_SHORT_DESC, -1))
        desc = resources.getStringArray(intent.getIntExtra(EXTRA_DESC, -1))
        ingredient = resources.getStringArray(intent.getIntExtra(EXTRA_INGREDIENTS, -1))
        tools = resources.getStringArray(intent.getIntExtra(EXTRA_TOOLS, -1))
        steps = resources.getStringArray(intent.getIntExtra(EXTRA_STEPS, -1))
        photos = resources.obtainTypedArray(intent.getIntExtra(EXTRA_PHOTOS, -1))

        binding.title1.text = title[0].toString()
        binding.title2.text = title[1].toString()
        binding.title3.text = title[2].toString()

        binding.desc1.text = shortDesc[0].toString()
        binding.desc2.text = shortDesc[1].toString()
        binding.desc3.text = shortDesc[2].toString()

        binding.img1.setImageResource(photos.getResourceId(0, -1))
        binding.img2.setImageResource(photos.getResourceId(1, -1))
        binding.img3.setImageResource(photos.getResourceId(2, -1))

        setTopBanner()

        binding.category1.setOnClickListener(this)
        binding.category2.setOnClickListener(this)
        binding.category3.setOnClickListener(this)

    }

    private fun setTopBanner() {
        when(intent.getStringExtra(EXTRA_CATEGORY).toString()) {
            "japan" -> {
                binding.bannerImage.setImageResource(R.drawable.japan_header)
                binding.bannerText.text = "Masakan Jepang"
            }
            "western" -> {
                binding.bannerImage.setImageResource(R.drawable.dark_theme_food)
                binding.bannerText.text = "Masakan Western"
            }
            "vegan" -> {
                binding.bannerImage.setImageResource(R.drawable.vegan_header)
                binding.bannerText.text = "Diet Vegan"
            }
            "nusantara" -> {
                binding.bannerImage.setImageResource(R.drawable.nusantara_header)
                binding.bannerText.text = "Masakan Nusantara"
            }
        }
    }

    @SuppressLint("ResourceType")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.category_1 -> {
                val data = Recipe(
                    title[0].toString(),
                    shortDesc[0].toString(),
                    desc[0].toString(),
                    ingredient[0].toString(),
                    tools[0].toString(),
                    steps[0].toString(),
                    photos.getResourceId(0, -1)
                )
                val intent = Intent(this@CategoryActivity, RecipePageActivity::class.java)
                intent.putExtra(RecipePageActivity.EXTRA_RECIPE, data)
                startActivity(intent)
            }
            R.id.category_2 -> {
                val data = Recipe(
                    title[1].toString(),
                    shortDesc[1].toString(),
                    desc[1].toString(),
                    ingredient[1].toString(),
                    tools[1].toString(),
                    steps[1].toString(),
                    photos.getResourceId(1, -1)
                )
                val intent = Intent(this@CategoryActivity, RecipePageActivity::class.java)
                intent.putExtra(RecipePageActivity.EXTRA_RECIPE, data)
                startActivity(intent)
            }

            R.id.category_3 -> {
                val data = Recipe(
                    title[2].toString(),
                    shortDesc[2].toString(),
                    desc[2].toString(),
                    ingredient[2].toString(),
                    tools[2].toString(),
                    steps[2].toString(),
                    photos.getResourceId(2, -1)
                )
                val intent = Intent(this@CategoryActivity, RecipePageActivity::class.java)
                intent.putExtra(RecipePageActivity.EXTRA_RECIPE, data)
                startActivity(intent)
            }
        }
    }


}