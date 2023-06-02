package quran.com.ui.home

import android.os.Bundle
import quran.com.R
import quran.com.base.BaseActivity
import quran.com.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(),Navigator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun makeViewModelProvider(): MainViewModel {
        return MainViewModel()
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }
}