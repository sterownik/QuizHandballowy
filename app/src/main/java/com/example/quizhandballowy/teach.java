package com.example.quizhandballowy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class teach extends AppCompatActivity {

    ArrayList<String> lista = new ArrayList<String>();

    String tmp2 = " ";
    int ilosc = 0;
    int dobre = 0;
    int liczba = 0;
    int j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teach);
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
        final ImageButton wstecz = (ImageButton)findViewById(R.id.back);
        final Button sprawdz = (Button)findViewById(R.id.check);





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

        //Toast.makeText(getApplicationContext(),Integer.toString(random),Toast.LENGTH_LONG).show();


        str2 = str1[liczba].split("&");
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


        wyniczek.setText("Numer pytania to : "+ Integer.toString(liczba));



        sprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ilosc++;
                if(jedynka.isChecked())
                {
                    tmp2=tmp2+"a";
                    j++;
                }
                if(dwojka.isChecked())
                {
                    tmp2=tmp2+"b";
                    j++;
                }

                if(trojka.isChecked())
                {
                    tmp2=tmp2+"c";
                    j++;
                }

                if(czwarty.isChecked())
                {
                    tmp2=tmp2+"d";
                    j++;
                }

                if(piaty.isChecked()){
                    tmp2=tmp2+"e";
                    j++;
                }
                if(szosty.isChecked()){
                    tmp2=tmp2+"f";
                    j++;
                }
                if(siodmy.isChecked()){
                    tmp2=tmp2+"g";
                    j++;
                }
                if(osmy.isChecked())
                {
                    tmp2=tmp2+"h";
                    j++;
                }
                if(dziewiaty.isChecked())
                {
                    tmp2=tmp2+"i";
                    j++;
                }

                for(int i=0;i<odppytanie.length;i++) {
                    if (liczba == i) {
                        if (tmp2.contains(odppytanie[i]) && j==odppytanie[i].length()) {
                            Toast.makeText(getApplicationContext(), "Zdobywasz punkt", Toast.LENGTH_LONG).show();
                            dobre++;
                        }

                    }

                }
                char[] odpowiedz;
                String que="";

                for (int i =0;i<odppytanie[liczba].length();i++)
                {
                    odpowiedz=odppytanie[liczba].toCharArray();
                    que=que+odpowiedz[i]+ " ";
                }
                wyniczek.setText("Poprawne odpowiedzi to : " + que.toUpperCase());

            }
        });
        wstecz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(liczba==0)
                {
                    liczba=0;
                }
                else {
                    liczba--;
                }

                tmp2=" ";
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






        butonik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(liczba==378)
                {
                    liczba=378;
                }
                else {
                    liczba++;
                }

                tmp2=" ";
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
