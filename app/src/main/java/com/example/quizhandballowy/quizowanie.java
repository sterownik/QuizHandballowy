package com.example.quizhandballowy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class quizowanie extends AppCompatActivity {
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizowanie);
        try {
            Play();
        }catch (IOException e)
        {
            Toast.makeText(getApplicationContext(),"By³y problemy z plikiem",Toast.LENGTH_LONG).show();
        }




    }


    public void Play() throws IOException
    {


        ImageButton butonik = (ImageButton)findViewById(R.id.imageButton);

        CheckBox jedynka=(CheckBox)findViewById(R.id.pierwszy);
        CheckBox dwojka=(CheckBox)findViewById(R.id.drugi);
        CheckBox trojka=(CheckBox)findViewById(R.id.trzeci);
        CheckBox czwarty=(CheckBox)findViewById(R.id.czwarty);
        CheckBox piaty=(CheckBox)findViewById(R.id.piaty);
        CheckBox szosty=(CheckBox)findViewById(R.id.szosty);
        TextView pt = (TextView)findViewById(R.id.pytanie);
        String str = "";
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.pytania);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if(is!=null)
        {
            while (( str = reader.readLine()) != null)
            {
                buf.append(str + "\n");
            }
        }
        is.close();
        String pytanko = buf.toString();

        String[] str1 = pytanko.split("#");




        butonik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
            }
        });
        while(i<6) {

            String[] str2 = str1[i].split("&");


            jedynka.setText(str2[1]);
            dwojka.setText(str2[2]);
            trojka.setText(str2[3]);
            czwarty.setText(str2[4]);
            if (piaty.getText().equals("CheckBox")) {
                piaty.setVisibility(View.INVISIBLE);
            }
            if (szosty.getText().equals("CheckBox")) {
                szosty.setVisibility(View.INVISIBLE);
            }
            pt.setText(str2[0]);
            break;
        }





    }

}
