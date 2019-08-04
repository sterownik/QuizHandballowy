package com.example.quizhandballowy;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static android.view.Window.FEATURE_NO_TITLE;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class quizowanieeng extends AppCompatActivity {
    RelativeLayout simple;
    ArrayList<String> lista = new ArrayList<String>();

    String tmp2 = " ";
    int ilosc = 0;
    int dobre = 0;
    int w;
    int j = 0;
    boolean czas1;
    boolean play;
    CountDownTimer mCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizowanieeng);
        try {
            Play();
        }catch (IOException e)
        {
            Toast.makeText(getApplicationContext(),"Były problemy z plikiem",Toast.LENGTH_LONG).show();
        }
    }





    @SuppressLint("ResourceType")
    public void Play() throws IOException
    {
        czas1 = true;
        play=true;


        final ArrayList<Integer> lista = new ArrayList<Integer>();



        simple = (RelativeLayout)findViewById(R.id.rel);

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
        final ProgressBar czasomierz = (ProgressBar)findViewById(R.id.czas);
        final CheckBox[] checkBoxes = {jedynka,dwojka,trojka,czwarty,piaty,szosty,siodmy,osmy,dziewiaty};

        w=90;
        czasomierz.setMax(90);

        czasomierz.setProgress(w);







        RelativeLayout.LayoutParams buttonParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        final Button myButton = new Button(this);  // create a new Button
        myButton.setId(1);
        myButton.setText("Next question"); // set Text in the Button
        myButton.setLayoutParams(buttonParam); // set defined layout params to Button


        //simple.addView(myButton);







        String str = "";
        String odp = "";

        StringBuffer buf1 = new StringBuffer();
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.angquestions);
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

        final int random = rand.nextInt(367);
        //Toast.makeText(getApplicationContext(),Integer.toString(random),Toast.LENGTH_LONG).show();


        str2 = str1[random].split("&");
        str2[0] = str2[0].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
        str2[1] = str2[1].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
        str2[2] = str2[2].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
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
            buttonParam.addRule(RelativeLayout.BELOW, R.id.drugi);




        }
        if (str2.length==4)
        {
            str2[3] = str2[3].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            trojka.setText(str2[3]);
            trojka.setVisibility(View.VISIBLE);
            czwarty.setVisibility(View.INVISIBLE);
            piaty.setVisibility(View.INVISIBLE);
            szosty.setVisibility(View.INVISIBLE);
            siodmy.setVisibility(View.INVISIBLE);
            osmy.setVisibility(View.INVISIBLE);
            dziewiaty.setVisibility(View.INVISIBLE);
            buttonParam.addRule(RelativeLayout.BELOW, R.id.trzeci);


        }
        if(str2.length==5)
        {
            str2[3] = str2[3].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[4] = str2[4].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            trojka.setText(str2[3]);
            trojka.setVisibility(View.VISIBLE);
            czwarty.setText(str2[4]);
            czwarty.setVisibility(View.VISIBLE);
            piaty.setVisibility(View.INVISIBLE);
            szosty.setVisibility(View.INVISIBLE);
            siodmy.setVisibility(View.INVISIBLE);
            osmy.setVisibility(View.INVISIBLE);
            dziewiaty.setVisibility(View.INVISIBLE);
            buttonParam.addRule(RelativeLayout.BELOW, R.id.czwarty);


        }
        if (str2.length==6)
        {
            str2[3] = str2[3].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[4] = str2[4].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[5] = str2[5].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
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
            buttonParam.addRule(RelativeLayout.BELOW, R.id.piaty);


        }
        if(str2.length==7)
        {
            str2[3] = str2[3].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[4] = str2[4].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[5] = str2[5].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[6] = str2[6].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
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
            buttonParam.addRule(RelativeLayout.BELOW, R.id.szosty);


        }
        if(str2.length==8)
        {
            str2[3] = str2[3].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[4] = str2[4].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[5] = str2[5].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[6] = str2[6].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[7] = str2[7].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
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
            buttonParam.addRule(RelativeLayout.BELOW, R.id.siodmy);


        }
        if(str2.length==9)
        {
            str2[3] = str2[3].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[4] = str2[4].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[5] = str2[5].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[6] = str2[6].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[7] = str2[7].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[8] = str2[8].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
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
            buttonParam.addRule(RelativeLayout.BELOW, R.id.osmy);


        }
        if(str2.length==10)
        {
            str2[3] = str2[3].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[4] = str2[4].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[5] = str2[5].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[6] = str2[6].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[7] = str2[7].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[8] = str2[8].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            str2[9] = str2[9].replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
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
            buttonParam.addRule(RelativeLayout.BELOW, R.id.dziewiaty);
        }





        buttonParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
        simple.addView(myButton);
        myButton.setVisibility(View.VISIBLE);



        RelativeLayout.LayoutParams txt1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT  );

        final TextView txt = new TextView(this);
        txt.setText("Ilosc odpowiedzi dobrych : "+Integer.toString(dobre)+"\n"+"Ilosc udzielonych odpowiedzi : "+Integer.toString(ilosc));

        txt.setLayoutParams(txt1);
        txt1.addRule(RelativeLayout.BELOW,1);

        txt1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        simple.addView(txt);
        txt.setVisibility(View.VISIBLE);








        // wyniczek.setText("Ilosc odpowiedzi dobrych : "+Integer.toString(dobre)+"\n"+"Ilosc udzielonych odpowiedzi : "+Integer.toString(ilosc));


        if(ilosc==40)
        {
            mCountDownTimer.cancel();
            Intent intent = new Intent(getApplicationContext(),result.class);
            intent.putExtra("liczba",dobre);
            startActivity(intent);
        }


        mCountDownTimer = new CountDownTimer(90000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                if(play) {
                    w--;
                    //  czasomierz.setProgress((int) w * 50 / (5000 / 1000));
                    czasomierz.setProgress(w);
                }

            }

            @Override
            public void onFinish() {
                //Do what you want
                w--;
                czasomierz.setProgress(100);
                Toast.makeText(getApplicationContext(), "koniec czasu", Toast.LENGTH_LONG).show();
                ilosc++;
                czas1 = false;

                sprawdzanie(checkBoxes, myButton, txt, odppytanie, random,czas1);
                zmien(checkBoxes);

                try {
                    Play();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Były problemy z plikiem", Toast.LENGTH_LONG).show();
                }
            }
        }.start();

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownTimer.cancel();
                w=90;
                ilosc++;
               /* if(jedynka.isChecked())
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
            myButton.setVisibility(View.INVISIBLE);
                txt.setVisibility(View.INVISIBLE);
            for(int i=0;i<odppytanie.length;i++) {
                if (random == i) {
                    if (tmp2.contains(odppytanie[i]) && j==odppytanie[i].length()) {
                       Toast.makeText(getApplicationContext(), "Zdobywasz punkt", Toast.LENGTH_LONG).show();
                       dobre++;
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Zla odpowiedz", Toast.LENGTH_LONG).show();
                    }
                }
            }
            tmp2=" ";
            j=0;*/

                sprawdzanie(checkBoxes,myButton,txt,odppytanie,random,czas1);
                if(sprawdzanie(checkBoxes,myButton,txt,odppytanie,random,czas1))
                {
                    zmienkolor(checkBoxes);
                    zmien(checkBoxes);

                    try {
                        Play();
                    }catch (IOException e)
                    {
                        Toast.makeText(getApplicationContext(),"Były problemy z plikiem",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            zmienkolor(checkBoxes);
                            zmien(checkBoxes);

                            try {
                                Play();
                            }catch (IOException e)
                            {
                                Toast.makeText(getApplicationContext(),"Były problemy z plikiem",Toast.LENGTH_LONG).show();
                            }

                        }
                    },3000);
                }
            }
        });

    }

    public void zmien(CheckBox[] checkBoxes)
    {
        for (int i = 0 ;i<checkBoxes.length;i++)
        {
            checkBoxes[i].setChecked(false);
        }
    }

    public boolean sprawdzanie(CheckBox[] checkBoxes,Button button,TextView txt,String[] str,int liczba,boolean czas)
    {
        boolean dobra = false;
        if(checkBoxes[0].isChecked())
        {
            tmp2=tmp2+"a";
            j++;
        }
        if(checkBoxes[1].isChecked())
        {
            tmp2=tmp2+"b";
            j++;
        }

        if(checkBoxes[2].isChecked())
        {
            tmp2=tmp2+"c";
            j++;
        }

        if(checkBoxes[3].isChecked())
        {
            tmp2=tmp2+"d";
            j++;
        }

        if(checkBoxes[4].isChecked()){
            tmp2=tmp2+"e";
            j++;
        }
        if(checkBoxes[5].isChecked()){
            tmp2=tmp2+"f";
            j++;
        }
        if(checkBoxes[6].isChecked()){
            tmp2=tmp2+"g";
            j++;
        }
        if(checkBoxes[7].isChecked())
        {
            tmp2=tmp2+"h";
            j++;
        }
        if(checkBoxes[8].isChecked())
        {
            tmp2=tmp2+"i";
            j++;
        }
        button.setVisibility(View.INVISIBLE);
        txt.setVisibility(View.INVISIBLE);
        for(int i=0;i<str.length;i++) {
            if (liczba == i) {
                if (tmp2.contains(str[i]) && j==str[i].length()) {
                    dobra=true;
                    Toast.makeText(getApplicationContext(), "You get a point", Toast.LENGTH_LONG).show();
                    dobre++;
                }
                else if(!czas)
                {
                    dobra=false;
                    Toast.makeText(getApplicationContext(), "Time is up", Toast.LENGTH_LONG).show();
                }
                else
                {
                    dobra=false;
                    Toast.makeText(getApplicationContext(), "Wrong answer", Toast.LENGTH_LONG).show();
                    char[] odpowiedz;
                    String que="";
                    for (int j =0;j<str[i].length();j++)
                    {
                        odpowiedz=str[i].toCharArray();
                        que=que+odpowiedz[j]+ " ";
                    }
                    final String que1 = que;



                    if(que1.contains("a"))
                    {
                        checkBoxes[0].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("b"))
                    {
                        checkBoxes[1].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("c"))
                    {
                        checkBoxes[2].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("d"))
                    {
                        checkBoxes[3].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("e"))
                    {
                        checkBoxes[4].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("f"))
                    {
                        checkBoxes[5].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("g"))
                    {
                        checkBoxes[6].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("h"))
                    {
                        checkBoxes[7].setTextColor(Color.GREEN);
                    }
                    if(que1.contains("i"))
                    {
                        checkBoxes[8].setTextColor(Color.GREEN);
                    }
                }
            }
        }
        tmp2=" ";
        j=0;
        return dobra;
    }


    @Override
    protected void onResume() {
        //mCountDownTimer.start();
        super.onResume();

    }




    @Override
    protected void onPause() {
        mCountDownTimer.cancel();

        super.onPause();
    }

    @Override
    protected void onStop() {
        mCountDownTimer.cancel();

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mCountDownTimer.cancel();

        super.onDestroy();
    }
    public void zmienkolor(CheckBox[] checkBoxes)
    {
        for(int i=0;i<checkBoxes.length;i++)
        {
            checkBoxes[i].setTextColor(Color.BLACK);
        }
    }

}
