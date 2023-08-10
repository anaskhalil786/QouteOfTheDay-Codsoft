package com.example.qouteoftheday

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {
    var listQuotes = mutableListOf(
            R.string.quote_string1,
            R.string.quote_string2,
            R.string.quote_string3,
            R.string.quote_string4,
            R.string.quote_string5,
            R.string.quote_string6,
            R.string.quote_string7
    )

    var quoteNumber=0
    var mainText=""

    private fun quoteOnappLoaded() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState:?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteOnappLoaded()
        clickNewQuote()

    }
    private fun clickNewQuote(){
        val fab_newQuote
        fab_newQuote.setOnClickListener{
            fab_newQuote.isEnabled=false

            if (quoteNumber== listQuotes.size){
                quoteOnappLoaded()

            }else {
                typetext(getString(listQuotes[quoteNumber]))
                ++quoteNumber
            }

        }
    }
    private fun quoteOnappLoaded(){
        fab_newQuote.isEnabled=false
        quoteNumber=0
        listQuotes.shuffle()
        typetext(getString(listQuotes[quoteNumber]))
        ++quoteNumber

    }

    private fun typetext(text:String){
        mainText=""
        val textDelay: Long= 50L

        GlobalScope.Launch(Dispatchers.IO){
            val sb=StringBuilder()
            val updatedText=""

            for (i in text.indices){
                mainText=sb.append(updatedText + text[i]).toString()
                Thread.sleep(textDelay)

            }

        }
        val  handler= Handler()
            Log.d("Main", "Handler started")
        val runnable = object : Runnable {
                @SuppressLint("SetTextI18")
                override fun run () {
            val tv_text
            tv_text.text= "$mainText|"
                        handler.postDelayed(this,10)

                    if (text==mainText) {
                        handler.removeCallbacks(this)
                        tv_text.text = mainText
                        val fab_newQuote;
                        fab_newQuote:isEnabled = true
                    }


                    }

                }
                handler.postDelayed(runnable,10)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item.itemId){
            R.id.nav_share -> {

            val shareIntent= Intent()
            shareIntent.action=Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,mainText)
            startActivity(Intent.createChooser(shareIntent,"Share this quote"))

            true

           }
            else -> super.onOptionsItemSeletced(item)
        }


    }
}