package com.example.myapplicationup930421;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class game extends AppCompatActivity {
    public int restart = 0;
    BufferedReader reader = null;
    NodeManager perec;
    DecisionNode node = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getFile();
        perec = new NodeManager(reader);
        navigateMap();
    }
    public void getFile(){

        try {
            InputStream is = getResources().openRawResource(R.raw.datalist);
            reader = new BufferedReader(new InputStreamReader(is));
        }catch (CustomException ce){
            Log.d("game", ce.getMessage());
        }
    }

    public void leftButton(View v){
        if (restart == 1){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } else {
            node = node.getLeftNode();
            navigateMap();
        }
    }
    public void rightButton(View v){
        node = node.getRightNode();
        navigateMap();
    }


    public void navigateMap() {
        if(node == null){
             node = perec.entryPoint();
        }
        TextView desc = (TextView) findViewById(R.id.description);
        Button leftOpt = (Button) findViewById(R.id.leftOption);
        Button rightOpt = (Button) findViewById(R.id.rightOption);
        ImageView image = (ImageView) findViewById(R.id.imageView2);
        Log.d("node", "info" + node);
        desc.setText(node.getDescription());
        try {
            Uri imageUri = Uri.parse("android.resource://com.example.myapplicationup930421/drawable/" + node.getImage());
            image.setImageURI(null);
            image.setImageURI(imageUri);
        }catch(CustomException ce){
            Log.d("game",ce.getMessage());
        }

        if ( node.getLeftID() == 0) {
            leftOpt.setText("click here to go back to start");
            restart = 1;
            rightOpt.setVisibility(View.GONE);
        } else {
            if ( node.getRightID() == 0) {
                leftOpt.setText(node.getLeftText());
                rightOpt.setVisibility(View.GONE);
            } else {
                leftOpt.setText(node.getLeftText());
                rightOpt.setVisibility(View.VISIBLE);
                rightOpt.setText(node.getRightText());
            }

        }

    }
}
