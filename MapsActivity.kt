package com.aditya.tic_tac_toe_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

var player1Win = 0
var player2Win = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun buttonClick(view:View)
    {
        val selectedButton = view as Button   //the variable gets the clicked button object all property
        /*when i get selectedButton.id as any of these like R.id.button1 then for that id i set cellID value to something specific*/
        var cellID = 0
        when(selectedButton.id){
            R.id.button1 -> cellID =1
            R.id.button2 -> cellID =2
            R.id.button3 -> cellID =3
            R.id.button4 -> cellID =4
            R.id.button5 -> cellID =5
            R.id.button6 -> cellID =6
            R.id.button7 -> cellID =7
            R.id.button8 -> cellID =8
            R.id.button9 -> cellID =9
        }

        //Log.d("buttonClick", selectedButton.id.toString())   //used for de-buging
        //Log.d("buttonClick: cellID",cellID.toString())

        playGame(cellID, selectedButton)
    }
    var activePlayer = 1
    var player1 = ArrayList<Int>()  //it will save all the buttons selected by player1
    var player2 = ArrayList<Int>()



    fun playGame(cellID:Int, selectedButton:Button){
        if (activePlayer == 1){
            selectedButton.text = "X"
            selectedButton.setBackgroundResource(R.color.player1)
            player1.add(cellID)
            activePlayer = 2
            // autoPlay()     //this function makes device play the game
        } else {
            selectedButton.text = "O"
            selectedButton.setBackgroundResource(R.color.player2)
            player2.add(cellID)
            activePlayer = 1

        }
        selectedButton.isEnabled = false   //so same button is not pressed again

        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        //diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if (winner == 1){
            Toast.makeText(this,"Player RED wins :)",Toast.LENGTH_LONG).show()
            player1Score()
            //tableLayout.setBackgroundResource(R.color.tableLayoutRed)
            stopper()

        } else if (winner == 2){
            Toast.makeText(this,"Player BLUE wins :)",Toast.LENGTH_LONG).show()
            player2Score()
            //tableLayout.setBackgroundResource(R.color.tableLayoutBlue)
            stopper()


        }


    }

    fun player1Score(){
        textView3.text = "${++player1Win}"
    }

    fun player2Score(){
        textView.text = "${++player2Win}"
    }
/*
    fun autoPlay(){

        var emptyCells = ArrayList<Int>()
        for(cellID in 1..9){
            if (!(player1.contains(cellID)) || !(player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        var r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellID = emptyCells[randIndex]

        var selectedButton:Button?
        selectedButton = when(cellID){
            1 -> button1
            2 -> button2
            3 -> button3
            4 -> button4
            5 -> button5
            6 -> button6
            7 -> button7
            8 -> button8
            9 -> button9
            else -> {button1}
        }
        playGame(cellID, selectedButton)
    }
*/

    fun stopper(){
        var blankBox = ArrayList<Int>()
        for (i in 1..9){
            if (!(player1.contains(i)) && !(player2.contains(i))){
                blankBox.add(i)

            }
        }
        for (j in 0 until blankBox.size){
            var nonPlayBox = blankBox[j]
            when(nonPlayBox){
                1 -> {button1.isEnabled = false
                    button1.setBackgroundResource(R.color.deadBox)}
                2 -> {button2.isEnabled = false
                    button2.setBackgroundResource(R.color.deadBox)}
                3 -> {button3.isEnabled = false
                    button3.setBackgroundResource(R.color.deadBox)}
                4 -> {button4.isEnabled = false
                    button4.setBackgroundResource(R.color.deadBox)}
                5 -> {button5.isEnabled = false
                    button5.setBackgroundResource(R.color.deadBox)}
                6 -> {button6.isEnabled = false
                    button6.setBackgroundResource(R.color.deadBox)}
                7 -> {button7.isEnabled = false
                    button7.setBackgroundResource(R.color.deadBox)}
                8 -> {button8.isEnabled = false
                    button8.setBackgroundResource(R.color.deadBox)}
                9 -> {button9.isEnabled = false
                    button9.setBackgroundResource(R.color.deadBox)}
            }
        }
    }

    fun restart(view: View)
    {
        player1.clear()
        player2.clear()
        activePlayer = 1
        for (i in 1..9){
            when(i){
                1 -> {button1.text = ""
                    button1.setBackgroundResource(R.color.box)
                    button1.isEnabled = true}
                2 -> {button2.text = ""
                    button2.setBackgroundResource(R.color.box)
                    button2.isEnabled = true}
                3 -> {button3.text = ""
                    button3.setBackgroundResource(R.color.box)
                    button3.isEnabled = true}
                4 -> {button4.text = ""
                    button4.setBackgroundResource(R.color.box)
                    button4.isEnabled = true}
                5 -> {button5.text = ""
                    button5.setBackgroundResource(R.color.box)
                    button5.isEnabled = true}
                6 -> {button6.text = ""
                    button6.setBackgroundResource(R.color.box)
                    button6.isEnabled = true}
                7 -> {button7.text = ""
                    button7.setBackgroundResource(R.color.box)
                    button7.isEnabled = true}
                8 -> {button8.text = ""
                    button8.setBackgroundResource(R.color.box)
                    button8.isEnabled = true}
                9 -> {button9.text = ""
                    button9.setBackgroundResource(R.color.box)
                    button9.isEnabled = true}
            }
        }
    }



}
