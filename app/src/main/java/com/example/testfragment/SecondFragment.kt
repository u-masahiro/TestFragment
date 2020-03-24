package com.example.testfragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.app.Activity
import android.content.Intent.getIntent
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_second)

        // to get message from MainActivity
        val intent = getIntent()
        val message = intent.extras?.getString(FirstFragment.EXTRA_MESSAGE)?:""

        textView.text = message

        button.setOnClickListener{
            val intentSub = Intent()

            if (editText.text != null) {
                val str = message + editText.text.toString()
                intentSub.putExtra(FirstFragment.EXTRA_MESSAGE, str)

                editText.setText("")
            }

            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }

    }