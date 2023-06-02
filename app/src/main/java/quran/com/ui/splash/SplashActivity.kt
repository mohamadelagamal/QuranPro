package quran.com.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import quran.com.R
import quran.com.ui.home.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val tarning = AnimationUtils.loadAnimation(this, R.anim.traning)
        val image = findViewById(R.id.iconQuran) as ImageView
        image.startAnimation(tarning)
        Handler().postDelayed({
            openHome()
        },2000)
    }

    private fun openHome() {
        startActivity(Intent(this, MainActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}