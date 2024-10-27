package com.example.basiclearningapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.basiclearningapp.databinding.ActivityMainBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("poppers", "onCreate")

        binding.button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


        val call = RetrofitUtils.getInstance().create(ApiInterface::class.java).getExampleData()


        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful && response.body()!=null){
                    Log.e("poppers", response.body()!!.string())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

    override fun onStart() {
        super.onStart()
        Log.e("poppers", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("poppers", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("poppers", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("poppers", "onStop")    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("poppers", "onDestroy")
    }
}