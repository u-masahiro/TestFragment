package com.example.testfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //buttonを参照
        val firstbutton = findViewById<Button>(R.id.firstButton)
        val secondButton = findViewById<Button>(R.id.secondButton)
        //FirstFragmentActivityクラスをインスタンス化その下も同様。
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        //buttonをクリックしたときにreplaceFragmentメソッドを実行
        firstbutton.setOnClickListener {
            replaceFragment(firstFragment)
        }
        secondButton.setOnClickListener {
            replaceFragment(secondFragment)
        }
    }
    //R.id.containerに引数で渡されたフラグメントを入れる。
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.commit()
    }
}
