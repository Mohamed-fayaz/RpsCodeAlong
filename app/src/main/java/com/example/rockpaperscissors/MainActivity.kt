package com.example.rockpaperscissors

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rockpaperscissors.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private enum class Options(Selected: Int) {
        Rock(1),
        Paper(2),
        Scissors(3)
    }

    private var yourSelectioon = Options.Rock
    private var CompSelectioon = Options.Rock
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.RockBtn.setOnClickListener {
            yourSelectioon = Options.Rock
            binding.UserImageView.setImageResource(R.drawable.sheriffrock)
            randomiNumGenerator()
            Compare()
        }
        binding.PaperBtn.setOnClickListener {
            yourSelectioon = Options.Paper
            binding.UserImageView.setImageResource(R.drawable.sheriffpaper)
            randomiNumGenerator()
            Compare()
        }
        binding.ScissorBtn.setOnClickListener {
            yourSelectioon = Options.Scissors
            binding.UserImageView.setImageResource(R.drawable.scissors)
            randomiNumGenerator()
            Compare()
        }
    }
    private fun Compare() : Int{
        if (yourSelectioon == CompSelectioon){
            binding.resulttextview.text = "Draw"
        }else if (yourSelectioon == Options.Rock){
            if (CompSelectioon == Options.Paper){
                binding.resulttextview.text = "Computer Wins"
                return 1
            }
        }else if (yourSelectioon == Options.Paper){
            if (CompSelectioon == Options.Scissors){
                binding.resulttextview.text = "Computer Wins"
                return 1
            }
        }else if (yourSelectioon == Options.Scissors){
            if (CompSelectioon == Options.Rock){
                binding.resulttextview.text = "Computer Wins"
                return 1
            }
        }

        binding.resulttextview.text = "You Win"
        return 1
    }

    private fun randomiNumGenerator() {

        when ((1..3).shuffled().last()) {
            1 -> {
                CompSelectioon = Options.Rock
                binding.ComputeImageView.setImageResource(R.drawable.outlawrock)
            }
            2 -> {
                CompSelectioon = Options.Paper
                binding.ComputeImageView.setImageResource(R.drawable.outlawpaper)
            }
            3 -> {
                CompSelectioon = Options.Scissors
                binding.ComputeImageView.setImageResource(R.drawable.outlawscissors)
            }
        }
    }
}