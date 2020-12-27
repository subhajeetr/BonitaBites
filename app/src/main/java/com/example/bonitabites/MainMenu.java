package com.example.bonitabites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenu extends AppCompatActivity {
    Button signinemail,signphone,signup;
    ImageView bgimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Animation Zoomin= AnimationUtils.loadAnimation(this,R.anim.zoomin);
        final Animation Zoomout= AnimationUtils.loadAnimation(this,R.anim.zoomout);


        bgimage=findViewById(R.id.back2);
        bgimage.setAnimation(Zoomin);
        bgimage.setAnimation(Zoomout);

        Zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation(Zoomin);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                bgimage.startAnimation(Zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        signinemail=findViewById(R.id.SignwithEmail);
        signphone=findViewById(R.id.SignwithPhone);
        signup=findViewById(R.id.Signup);

        signinemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signemail = new Intent(MainMenu.this,chooseOne.class);
                signemail.putExtra("HOME","EMAIL");
                startActivity(signemail);
                finish();

            }
        });
        signphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signphone = new Intent(MainMenu.this,chooseOne.class);
                signphone.putExtra("HOME","PHONE");
                startActivity(signphone);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(MainMenu.this,chooseOne.class);
                signup.putExtra("HOME","Signup");
                startActivity(signup);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}