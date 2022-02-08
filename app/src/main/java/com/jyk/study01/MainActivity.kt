package com.jyk.study01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 : TextView = findViewById(R.id.number1)
        val number2 : TextView = findViewById(R.id.number2)
        val number3 : TextView = findViewById(R.id.number3)
        val number4 : TextView = findViewById(R.id.number4)
        val number5 : TextView = findViewById(R.id.number5)
        val number6 : TextView = findViewById(R.id.number6)
//        val number7 : TextView = findViewById(R.id.number7)

        val lotteryNumbers = arrayListOf(number1, number2, number3, number4, number5, number6)

        val countDownTimer = object: CountDownTimer(3000, 100){
            override fun onTick(p0: Long) {
                randomNumbers.clear()
                lotteryNumbers.forEach {
                    val randomNumber = getRandomNumber()

                    it.text = "$randomNumber"
                }
            }

            override fun onFinish() {

            }

        }

        val lotteryButton = findViewById<LottieAnimationView>(R.id.lotteryButton)
        lotteryButton.setOnClickListener {
            if (lotteryButton.isAnimating){
                lotteryButton.cancelAnimation()
                countDownTimer.cancel()

            } else {
                lotteryButton.playAnimation()
                countDownTimer.start()
            }
        }
    }

    var randomNumbers: ArrayList<Int> = arrayListOf()
    fun getRandomNumber(): Int {

        /**
         * indexOf
         *  - 찾으려는 값이 없는 경우 -1을 반환
         *  - 찾으려는 값이 있는 경우, 찾으려는 값이 위치한 인덱스를 반환
         * 1 : 10
         * 2 : 12
         * 3 :
         * 4 :
         * 5 :
         * 6 :
         */

        var randomNumber = 0

        do {

            randomNumber = (Math.random()*45+1).toInt()

        } while(randomNumbers.indexOf(randomNumber) >= 0)

        randomNumbers.add(randomNumber)

        return randomNumber
    }

    fun getRandomNumber2(): Int {
        val randomNumber = (Math.random()*45+1).toInt()
        return if (randomNumbers.indexOf(randomNumber) >= 0) getRandomNumber2()
        else randomNumber
    }


    // [10 22 33]
    fun indexOf(n: Int): Int {

        randomNumbers.forEachIndexed { index, num ->
            if (num == n) {
                return index
            }
        }

        return -1

    }
}