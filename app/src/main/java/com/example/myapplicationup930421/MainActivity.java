package com.example.myapplicationup930421;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.start);
    }

    public void startGame(View v){
        Intent i = new Intent(this, game.class);
        startActivity(i);

    }

}
