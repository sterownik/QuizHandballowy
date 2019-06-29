package com.example.quizhandballowy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

    ArrayList<String> lista = new ArrayList<String>();
    String odp1 = "x";
    String tmp="x";
    int ilosc = 0;
    int dobre = 0;
    int j = 0;
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
        final ArrayList<Integer> lista = new ArrayList<Integer>();


        ImageButton butonik = (ImageButton)findViewById(R.id.imageButton);

        final CheckBox jedynka=(CheckBox)findViewById(R.id.pierwszy);
        final CheckBox dwojka=(CheckBox)findViewById(R.id.drugi);
        final CheckBox trojka=(CheckBox)findViewById(R.id.trzeci);
        final CheckBox czwarty=(CheckBox)findViewById(R.id.czwarty);
        final CheckBox piaty=(CheckBox)findViewById(R.id.piaty);
        final CheckBox szosty=(CheckBox)findViewById(R.id.szosty);
        final CheckBox siodmy=(CheckBox)findViewById(R.id.siodmy);
        final CheckBox osmy = (CheckBox)findViewById(R.id.osmy);
        final CheckBox dziewiaty = (CheckBox)findViewById(R.id.dziewiaty);
        final TextView pt = (TextView)findViewById(R.id.pytanie);
        final TextView wyniczek = (TextView)findViewById(R.id.wynik);


        jedynka.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"a";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('a','x');
                }
            }
        });
        dwojka.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"b";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('b','x');
                }
            }
        });
        trojka.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"c";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('c','x');
                }
            }
        });
        czwarty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"d";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('d','x');
                }
            }
        });
        piaty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"e";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('e','x');
                }
            }
        });
        szosty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"f";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('f','x');
                }
            }
        });
        siodmy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"g";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('g','x');
                }
            }
        });
        osmy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"h";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('h','x');
                }
            }
        });
        dziewiaty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    odp1=odp1+"i";
                    tmp=odp1;
                }
                else if(!isChecked)
                {
                    tmp = odp1.replace('i','x');
                }
            }
        });


        String str = "";
        String odp = "";
        StringBuffer buf1 = new StringBuffer();
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.pytanka2);
        InputStream is2 = this.getResources().openRawResource(R.raw.moje);
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
      //  Toast.makeText(getApplicationContext(),odppytanie[4],Toast.LENGTH_LONG).show();


        final String[] str1 = pytanko.split("#");
        final Random rand = new Random();

        final int random = rand.nextInt(str1.length);
        //Toast.makeText(getApplicationContext(),Integer.toString(random),Toast.LENGTH_LONG).show();


            str2 = str1[random].split("&");
            pt.setText(str2[0]);
            jedynka.setText(str2[1]);
            dwojka.setText(str2[2]);



            if (str2.length==3)
            {
                trojka.setVisibility(View.INVISIBLE);
                czwarty.setVisibility(View.INVISIBLE);
                piaty.setVisibility(View.INVISIBLE);
                szosty.setVisibility(View.INVISIBLE);
                siodmy.setVisibility(View.INVISIBLE);
                osmy.setVisibility(View.INVISIBLE);
                dziewiaty.setVisibility(View.INVISIBLE);
            }
            if (str2.length==4)
            {
                trojka.setText(str2[3]);
                trojka.setVisibility(View.VISIBLE);
                czwarty.setVisibility(View.INVISIBLE);
                piaty.setVisibility(View.INVISIBLE);
                szosty.setVisibility(View.INVISIBLE);
                siodmy.setVisibility(View.INVISIBLE);
                osmy.setVisibility(View.INVISIBLE);
                dziewiaty.setVisibility(View.INVISIBLE);
            }
            if(str2.length==5)
            {
                trojka.setText(str2[3]);
                trojka.setVisibility(View.VISIBLE);
                czwarty.setText(str2[4]);
                czwarty.setVisibility(View.VISIBLE);
                piaty.setVisibility(View.INVISIBLE);
                szosty.setVisibility(View.INVISIBLE);
                siodmy.setVisibility(View.INVISIBLE);
                osmy.setVisibility(View.INVISIBLE);
                dziewiaty.setVisibility(View.INVISIBLE);
            }
            if (str2.length==6)
            {
                trojka.setText(str2[3]);
                trojka.setVisibility(View.VISIBLE);
                piaty.setText(str2[5]);
                czwarty.setText(str2[4]);
                czwarty.setVisibility(View.VISIBLE);
                piaty.setVisibility(View.VISIBLE);
                szosty.setVisibility(View.INVISIBLE);
                siodmy.setVisibility(View.INVISIBLE);
                osmy.setVisibility(View.INVISIBLE);
                dziewiaty.setVisibility(View.INVISIBLE);
            }
            if(str2.length==7)
            {
                trojka.setText(str2[3]);
                trojka.setVisibility(View.VISIBLE);
                piaty.setVisibility(View.VISIBLE);
                szosty.setVisibility(View.VISIBLE);
                czwarty.setVisibility(View.VISIBLE);
                piaty.setText(str2[5]);
                czwarty.setText(str2[4]);
                szosty.setText(str2[6]);
                siodmy.setVisibility(View.INVISIBLE);
                osmy.setVisibility(View.INVISIBLE);
                dziewiaty.setVisibility(View.INVISIBLE);
            }
            if(str2.length==8)
            {
                trojka.setText(str2[3]);
                trojka.setVisibility(View.VISIBLE);
                piaty.setVisibility(View.VISIBLE);
                szosty.setVisibility(View.VISIBLE);
                czwarty.setVisibility(View.VISIBLE);
                piaty.setText(str2[5]);
                czwarty.setText(str2[4]);
                szosty.setText(str2[6]);
                siodmy.setVisibility(View.VISIBLE);
                siodmy.setText(str2[7]);
                osmy.setVisibility(View.INVISIBLE);
                dziewiaty.setVisibility(View.INVISIBLE);
            }
            if(str2.length==9)
            {
                trojka.setText(str2[3]);
                trojka.setVisibility(View.VISIBLE);
                piaty.setVisibility(View.VISIBLE);
                szosty.setVisibility(View.VISIBLE);
                czwarty.setVisibility(View.VISIBLE);
                piaty.setText(str2[5]);
                czwarty.setText(str2[4]);
                szosty.setText(str2[6]);
                siodmy.setVisibility(View.VISIBLE);
                siodmy.setText(str2[7]);
                osmy.setText(str2[8]);
                osmy.setVisibility(View.VISIBLE);
                dziewiaty.setVisibility(View.INVISIBLE);
            }
            if(str2.length==10)
            {
                trojka.setText(str2[3]);
                trojka.setVisibility(View.VISIBLE);
                piaty.setVisibility(View.VISIBLE);
                szosty.setVisibility(View.VISIBLE);
                czwarty.setVisibility(View.VISIBLE);
                piaty.setText(str2[5]);
                czwarty.setText(str2[4]);
                szosty.setText(str2[6]);
                siodmy.setVisibility(View.VISIBLE);
                siodmy.setText(str2[7]);
                osmy.setText(str2[8]);
                osmy.setVisibility(View.VISIBLE);
                dziewiaty.setVisibility(View.VISIBLE);
                dziewiaty.setText(str2[9]);
            }

            wyniczek.setText("Ilosc odpowiedzi dobrych : "+Integer.toString(dobre)+"\n"+"Ilosc udzielonych odpowiedzi : "+Integer.toString(ilosc));

             butonik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilosc++;
                if(jedynka.isChecked())j++;
                if(dwojka.isChecked())j++;
                if(trojka.isChecked())j++;
                if(czwarty.isChecked())j++;
                if(piaty.isChecked())j++;
                if(szosty.isChecked())j++;
                if(siodmy.isChecked())j++;
                if(osmy.isChecked())j++;
                if(dziewiaty.isChecked())j++;

            for(int i=0;i<odppytanie.length;i++) {
                if (random == i) {
                    if (tmp.contains(odppytanie[i]) && j==odppytanie[i].length()) {
                       Toast.makeText(getApplicationContext(), "Zdobywasz punkt", Toast.LENGTH_LONG).show();
                       dobre++;
                    }
                }

            }
            odp1 = "x";
            tmp="x";
            j=0;
                jedynka.setChecked(false);
                dwojka.setChecked(false);
                trojka.setChecked(false);
                czwarty.setChecked(false);
                piaty.setChecked(false);
                szosty.setChecked(false);
                siodmy.setChecked(false);
                osmy.setChecked(false);
                dziewiaty.setChecked(false);
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
