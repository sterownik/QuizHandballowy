package com.example.quizhandballowy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int liczba = getIntent().getIntExtra("liczba",0);

        ImageView img = (ImageView)findViewById(R.id.zdjecie);
        TextView txt = (TextView)findViewById(R.id.wynik);
        if(liczba>15)
        {
                txt.setText("Uzyskałeś sume punktów: \n" + Integer.toString(liczba)+ "\n" +" Co daje ocene pozytywną");
                img.setImageResource(R.drawable.plus);
        }
        else
        {
            txt.setText("Uzyskałeś sume punktów \n" + Integer.toString(liczba)+ "\n" + " Co daje ocene negatywną");
            img.setImageResource(R.drawable.minus);
        }
    }
}
