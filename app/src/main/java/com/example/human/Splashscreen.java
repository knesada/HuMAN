package com.example.human;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Millochka on 1/26/17.
 */

public class Splashscreen extends Activity {
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        StartAnimations();
    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();

        Animation anim2=AnimationUtils.loadAnimation(this, R.anim.beta);
        anim2.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.splash_screen);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.profile_image);
        ImageView tx=(ImageView) findViewById(R.id.app_name);
        iv.clearAnimation();
        iv.startAnimation(anim);
        tx.clearAnimation();
        tx.startAnimation(anim2);
        splashTread = new Thread() {

            @Override
            public void run() {
                try {
                    int waited = 0;
// Splash screen pause time
                    while (waited < 5000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splashscreen.this,
                            HomePage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Splashscreen.this.finish();
                } catch (InterruptedException e) {
// do nothing
                } finally {
                    Splashscreen.this.finish();
                }
            }
        };
        splashTread.start();

        }
}
