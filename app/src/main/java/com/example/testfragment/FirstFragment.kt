package com.example.testfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {
        const val EXTRA_MESSAGE = "com.example.kotlinactivitydatatrans.MESSAGE"
    }

    private val RESULT_SUBACTIVITY = 1000

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            if (editText.text != null) {
                val intent = Intent(applicationContext, SecondFragment::class.java)
                val str = editText.text.toString()
                Log.d("debug", str)

                intent.putExtra(EXTRA_MESSAGE, str)
                startActivityForResult(intent, RESULT_SUBACTIVITY)

                editText.setText("")

            }
        }
        if (resultCode == Activity.RESULT_OK &&
            requestCode == RESULT_SUBACTIVITY && intent != null
        ) {

            val res = intent.extras?.getString(EXTRA_MESSAGE) ?: ""
            textView.text = res
        }
    }
}