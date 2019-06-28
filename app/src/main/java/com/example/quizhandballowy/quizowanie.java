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
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class quizowanie extends AppCompatActivity {
    int i=0;
    ArrayList<String> lista = new ArrayList<String>();
    String odp1;

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

    public void jedynka(View v)
    {
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
         //   lista.add("a");
            odp1 = "a";
        }
    }
    public void dwojka(View v)
    {
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
         //   lista.add("b");
            odp1 = "b";
        }
    }
    public void trojka(View v)
    {
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
          //  lista.add("c");
            odp1 = "c";
        }
    }
    public void czworka(View v)
    {
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
           // lista.add("d");
            odp1 = "d";
        }
    }
    public void piatka(View v)
    {
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
           // lista.add("e");
            odp1 = "e";
        }
    }
    public void szostka(View v)
    {
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
          //  lista.add("f");
            odp1 = "f";
        }
    }


    public void Play() throws IOException
    {
        final ArrayList<Integer> lista = new ArrayList<Integer>();


        ImageButton butonik = (ImageButton)findViewById(R.id.imageButton);

        final CheckBox jedynka=(CheckBox)findViewById(R.id.pierwszy);
        final CheckBox dwojka=(CheckBox)findViewById(R.id.drugi);
        final CheckBox trojka=(CheckBox)findViewById(R.id.trzeci);
        final CheckBox czwarty=(CheckBox)findViewById(R.id.czwarty);
        final CheckBox piaty=(CheckBox)findViewById(R.id.piaty);
        final CheckBox szosty=(CheckBox)findViewById(R.id.szosty);
        final TextView pt = (TextView)findViewById(R.id.pytanie);
        String str = "";
        String odp = "";
        StringBuffer buf1 = new StringBuffer();
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.pytania);
        InputStream is2 = this.getResources().openRawResource(R.raw.odp);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(is2));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if(is!=null)
        {
            while (( str = reader.readLine()) != null)
            {
                buf.append(str + "\n");
            }
        }
        is.close();
        if(is2!=null)
        {
            while (( odp = reader2.readLine()) != null)
            {
                buf1.append(odp + "\n");
            }
        }
        is2.close();

        String odpowiedz = buf1.toString();

        String pytanko = buf.toString();

        String[] odp2;
        String[] str2;

        final String[] odppytanie = odpowiedz.split("#");


        final String[] str1 = pytanko.split("#");
        final Random rand = new Random();

        final int random = rand.nextInt(str1.length);
        //Toast.makeText(getApplicationContext(),Integer.toString(random),Toast.LENGTH_LONG).show();


            str2 = str1[random].split("&");
            jedynka.setText(str2[1]);
            dwojka.setText(str2[2]);
            trojka.setText(str2[3]);
            czwarty.setText(str2[4]);
            if (czwarty.getText().equals("CheckBox")) {
                czwarty.setVisibility(View.INVISIBLE);
            }
            if (piaty.getText().equals("CheckBox")) {
                piaty.setVisibility(View.INVISIBLE);
            }
            if (szosty.getText().equals("CheckBox")) {
                szosty.setVisibility(View.INVISIBLE);
            }
            pt.setText(str2[0]);







        butonik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random==0)
                {
                  //  Toast.makeText(getApplicationContext(),odppytanie[0],Toast.LENGTH_LONG).show();
                    if(odp1.equals(odppytanie[0]))
                    {
                        Toast.makeText(getApplicationContext(),"Zdobywasz punkt",Toast.LENGTH_LONG).show();
                    }
                }
                else   if(random==1)
                {
                    if(lista.contains(odppytanie[1]))
                    {
                        Toast.makeText(getApplicationContext(),"Zdobywasz punkt",Toast.LENGTH_LONG).show();
                    }
                }
                else if(random==2)
                {
                    if(lista.contains(odppytanie[2]))
                    {
                        Toast.makeText(getApplicationContext(),"Zdobywasz punkt",Toast.LENGTH_LONG).show();
                    }
                }
                else if(random==3)
                {
                    if(lista.contains(odppytanie[3]))
                    {
                        Toast.makeText(getApplicationContext(),"Zdobywasz punkt",Toast.LENGTH_LONG).show();
                    }
                }
                 else if(random==4)
                {
                    if(lista.contains(odppytanie[4]))
                    {
                        Toast.makeText(getApplicationContext(),"Zdobywasz punkt",Toast.LENGTH_LONG).show();
                    }
                }
                jedynka.setChecked(false);
                dwojka.setChecked(false);
                trojka.setChecked(false);
                czwarty.setChecked(false);
                piaty.setChecked(false);
                szosty.setChecked(false);
                try {
                    Play();
                }catch (IOException e)
                {
                    Toast.makeText(getApplicationContext(),"By³y problemy z plikiem",Toast.LENGTH_LONG).show();
                }
            }
        });






    }

}
