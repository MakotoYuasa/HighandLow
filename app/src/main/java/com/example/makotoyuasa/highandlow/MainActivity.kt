package com.example.makotoyuasa.highandlow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val tag = "high and low"
    private var yourCard = 0
    private var androidCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        highbtn.setOnClickListener {
            if((gameStart && !answered)) {
                highAndlow('h')
            }
        }

        lowbtn.setOnClickListener {
            if((gameStart && !answered)) {
                highAndlow('l')
            }
        }

        nextbtn.setOnClickListener {
            if(gameStart) {
                drawCard()
            }
        }
    }

    // ユーザーの処理を受け付ける直前に呼び出される
    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0
        hitText.text = getString(R.string.hit_text)
        loseText.text = getString(R.string.lose_text)
        gameStart = true
        drawCard()
    }

    private fun drawCard() {
        yourcardImage.setImageResource(R.drawable.z02)    // 赤
        androidcardImage.setImageResource(R.drawable.z01) // 黒

        yourCard = Random().nextInt(13) + 1
        when(yourCard) {
            1 -> yourcardImage.setImageResource(R.drawable.d01)
            2 -> yourcardImage.setImageResource(R.drawable.d02)
            3 -> yourcardImage.setImageResource(R.drawable.d03)
            4 -> yourcardImage.setImageResource(R.drawable.d04)
            5 -> yourcardImage.setImageResource(R.drawable.d05)
            6 -> yourcardImage.setImageResource(R.drawable.d06)
            7 -> yourcardImage.setImageResource(R.drawable.d07)
            8 -> yourcardImage.setImageResource(R.drawable.d08)
            9 -> yourcardImage.setImageResource(R.drawable.d09)
            10 -> yourcardImage.setImageResource(R.drawable.d10)
            11 -> yourcardImage.setImageResource(R.drawable.d11)
            12 -> yourcardImage.setImageResource(R.drawable.d12)
            13 -> yourcardImage.setImageResource(R.drawable.d13)
        }
        androidCard = Random().nextInt(13) + 1
        answered = false
    }

    private fun highAndlow(answer:Char) {
        showandroidCard()
        answered = true

        val balance = androidCard - yourCard
        if(balance == 0) {
            // 2枚とも同じ大きさ
        }else if((answer == 'h' && balance > 0)) {
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        }else if((answer == 'l' && balance < 0)) {
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        }else {
            // 外した場合
            loseCount++
            loseText.text = getString(R.string.lose_text) + loseCount
        }

        if(hitCount == 5) {
            resultText.text = "あなたの勝ちです"
            gameStart = false
        }else if(loseCount == 5){
            resultText.text = "あなたの負けです"
            gameStart = false
        }else {
        }
    }

    private fun showandroidCard() {
        when(androidCard) {
            1 -> androidcardImage.setImageResource(R.drawable.c01)
            2 -> androidcardImage.setImageResource(R.drawable.c02)
            3 -> androidcardImage.setImageResource(R.drawable.c03)
            4 -> androidcardImage.setImageResource(R.drawable.c04)
            5 -> androidcardImage.setImageResource(R.drawable.c05)
            6 -> androidcardImage.setImageResource(R.drawable.c06)
            7 -> androidcardImage.setImageResource(R.drawable.c07)
            8 -> androidcardImage.setImageResource(R.drawable.c08)
            9 -> androidcardImage.setImageResource(R.drawable.c09)
            10 -> androidcardImage.setImageResource(R.drawable.c10)
            11 -> androidcardImage.setImageResource(R.drawable.c11)
            12 -> androidcardImage.setImageResource(R.drawable.c12)
            13 -> androidcardImage.setImageResource(R.drawable.c13)
        }
    }
}

