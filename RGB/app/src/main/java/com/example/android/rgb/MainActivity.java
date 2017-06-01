package com.example.android.rgb;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    int r=0,g=0,b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(android.R.id.content);
        view.setBackgroundColor(Color.rgb(r,g,b));

        display();

    }

    public void saveinfo()
    {
        SharedPreferences sharedpref = getSharedPreferences("colours", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();

        editor.putInt("red",r);
        editor.putInt("green",g);
        editor.putInt("blue",b);

        editor.apply();
    }

    public void display()
    {
        SharedPreferences sharedpref = getSharedPreferences("colours", Context.MODE_PRIVATE);

        int r1 = sharedpref.getInt("red",r);
        int g1 = sharedpref.getInt("green",g);
        int b1 = sharedpref.getInt("blue",b);

        r=r1;
        b=b1;
        g=g1;

        TextView T = (TextView) findViewById(R.id.textviewr);
        T.setText("RED = " + r);

        T = (TextView) findViewById(R.id.textviewg);
        T.setText("GREEN = " + g);

        T = (TextView) findViewById(R.id.textviewb);
        T.setText("BLUE = " + b);

        update();

    }

    public void redInc(View view)
    {
        r+=5;
        if(r==260)r=0;
        TextView T = (TextView) findViewById(R.id.textviewr);
        T.setText("RED = " + r);
        update();
        saveinfo();

    }


    public void greenInc(View view)
    {
        g+=5;
        if(g==260)g=0;
        TextView T = (TextView) findViewById(R.id.textviewg);
        T.setText("GREEN = " + g);
        update();
        saveinfo();

    }

    public void blueInc(View view)
    {
        b+=5;
        if(b==260)b=0;
        TextView T = (TextView) findViewById(R.id.textviewb);
        T.setText("BLUE = " + b);
        update();
        saveinfo();

    }

    public void reset(View view)
    {
        r=0;
        g=0;
        b=0;

        TextView T = (TextView) findViewById(R.id.textviewr);
        T.setText("RED = " + r);

        T = (TextView) findViewById(R.id.textviewg);
        T.setText("GREEN = " + g);

        T = (TextView) findViewById(R.id.textviewb);
        T.setText("BLUE = " + b);

        update();
    }


    public void update()
    {
        View v = findViewById(android.R.id.content);
        v.setBackgroundColor(Color.rgb(r,g,b));
    }
}
