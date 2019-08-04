package com.example.quizhandballowy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import static android.view.Window.FEATURE_NO_TITLE;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class teacheng extends AppCompatActivity {
    RelativeLayout simple1;
    ArrayList<String> lista = new ArrayList<String>();

    String tmp2 = " ";
    int ilosc = 0;
    int dobre = 0;
    int liczba = 0;
    int j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);//USTWIAM FLAGI
        requestWindowFeature(FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacheng);

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
        final ArrayList<Integer> lista = new ArrayList<Integer>();




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
        final CheckBox[] checkBoxess = {jedynka,dwojka,trojka,czwarty,piaty,szosty,siodmy,osmy,dziewiaty};
        final TextView numerek = (TextView)findViewById(R.id.numer);





        simple1 = (RelativeLayout)findViewById(R.id.teach);

        RelativeLayout.LayoutParams buttonParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams buttonParam2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams buttonParam3 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams editparams = new RelativeLayout.LayoutParams(
                300,RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams paramsidz = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        final Button next = new Button(this);  // create a new Button

        //next.setImageResource(R.drawable.next); // set Text in the Button
        next.setTextColor(Color.BLACK);

        next.setText("Next question");
        next.setId(11);
        next.setLayoutParams(buttonParam); // set defined layout params to Button

        final Button idz = new Button(this);
        idz.setTextColor(Color.BLACK);

        idz.setText("To the question...");
        idz.setId(8);
        idz.setLayoutParams(paramsidz);

        final EditText numer = new EditText(this);
        numer.setInputType(InputType.TYPE_CLASS_NUMBER);
        numer.setId(6);
        numer.setHint("Question");
        numer.setHintTextColor(Color.GRAY);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        numer.setLayoutParams(editparams);

        final Button back = new Button(this);  // create a new Button
        back.setTextColor(Color.BLACK);


        // back.setImageResource(R.drawable.back); // set Text in the Button
        back.setText("Previous question");
        back.setLayoutParams(buttonParam3); // set defined layout params to Button



        final Button myButton = new Button(this);  // create a new Button
        myButton.setText("Check"); // set Text in the Button
        myButton.setId(3);

        myButton.setLayoutParams(buttonParam2); // set defined layout params to Button
        myButton.setTextColor(Color.BLACK); // set white color for the text of Button




       // Charset ch = Charset.forName("windows-1250");
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

        //Toast.makeText(getApplicationContext(),Integer.toString(random),Toast.LENGTH_LONG).show();


        str2 = str1[liczba].split("&");
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
            buttonParam.addRule(RelativeLayout.BELOW,R.id.drugi);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.drugi);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.drugi);
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
            buttonParam.addRule(RelativeLayout.BELOW,R.id.trzeci);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.trzeci);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.trzeci);
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
            buttonParam.addRule(RelativeLayout.BELOW,R.id.czwarty);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.czwarty);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.czwarty);
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
            buttonParam.addRule(RelativeLayout.BELOW,R.id.piaty);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.piaty);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.piaty);
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
            buttonParam.addRule(RelativeLayout.BELOW,R.id.szosty);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.szosty);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.szosty);
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
            buttonParam.addRule(RelativeLayout.BELOW,R.id.siodmy);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.siodmy);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.siodmy);
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
            buttonParam.addRule(RelativeLayout.BELOW,R.id.osmy);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.osmy);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.osmy);
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

            buttonParam.addRule(RelativeLayout.BELOW,R.id.dziewiaty);
            buttonParam2.addRule(RelativeLayout.BELOW,R.id.dziewiaty);

            buttonParam3.addRule(RelativeLayout.BELOW,R.id.dziewiaty);
        }

        editparams.addRule(RelativeLayout.BELOW,3);
        editparams.setMargins(0,50,0,0);



        paramsidz.addRule(RelativeLayout.BELOW,6);
        paramsidz.addRule(RelativeLayout.CENTER_HORIZONTAL);

        buttonParam2.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParam.addRule(RelativeLayout.RIGHT_OF,3);
        buttonParam3.setMargins(0,0,30,0);
        buttonParam3.addRule(RelativeLayout.LEFT_OF,3);
        paramsidz.setMargins(0,50,30,0);
        buttonParam.setMargins(30,0,0,0);

        simple1.addView(myButton);
        simple1.addView(next);
        simple1.addView(back);
        myButton.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        numer.setVisibility(View.VISIBLE);
        idz.setVisibility(View.VISIBLE);

        RelativeLayout.LayoutParams txt1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT  );

        final TextView txt = new TextView(this);
        numerek.setText("The question number is : "+ Integer.toString(liczba));
        txt1.setMargins(20,60,0,0);

        txt.setLayoutParams(txt1);
        txt1.addRule(RelativeLayout.RIGHT_OF,6);
        txt1.addRule(RelativeLayout.BELOW,11);
        editparams.addRule(RelativeLayout.CENTER_HORIZONTAL);


        simple1.addView(txt);
        simple1.addView(idz);
        simple1.addView(numer);
        txt.setVisibility(View.VISIBLE);


        //  wyniczek.setText("Numer pytania to : "+ Integer.toString(liczba));

        idz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!numer.getText().toString().isEmpty())
                {
                    liczba = Integer.parseInt(numer.getText().toString());
                    if (liczba > 367) {
                        Toast.makeText(getApplicationContext(), "Nie ma takiego pytania", Toast.LENGTH_LONG).show();
                    } else {


                        tmp2 = " ";
                        j = 0;
                        jedynka.setChecked(false);
                        dwojka.setChecked(false);
                        trojka.setChecked(false);
                        czwarty.setChecked(false);
                        piaty.setChecked(false);
                        szosty.setChecked(false);
                        siodmy.setChecked(false);
                        osmy.setChecked(false);
                        dziewiaty.setChecked(false);
                        myButton.setVisibility(View.INVISIBLE);
                        next.setVisibility(View.INVISIBLE);
                        back.setVisibility(View.INVISIBLE);
                        txt.setVisibility(View.INVISIBLE);
                        numer.setVisibility(View.INVISIBLE);
                        idz.setVisibility(View.INVISIBLE);
                        zmienkolor(checkBoxess);

                        try {
                            Play();
                        } catch (IOException e) {
                            Toast.makeText(getApplicationContext(), "Były problemy z plikiem", Toast.LENGTH_LONG).show();
                        }
                    }


                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Podaj numer pytania!", Toast.LENGTH_LONG).show();
                }
            }
        });



        myButton.setOnClickListener(new View.OnClickListener() {
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
                if(que.contains("a"))
                {
                    jedynka.setTextColor(Color.GREEN);
                }
                if(que.contains("b"))
                {
                    dwojka.setTextColor(Color.GREEN);
                }
                if(que.contains("c"))
                {
                    trojka.setTextColor(Color.GREEN);
                }
                if(que.contains("d"))
                {
                    czwarty.setTextColor(Color.GREEN);
                }
                if(que.contains("e"))
                {
                    piaty.setTextColor(Color.GREEN);
                }
                if(que.contains("f"))
                {
                    szosty.setTextColor(Color.GREEN);
                }
                if(que.contains("g"))
                {
                    siodmy.setTextColor(Color.GREEN);
                }
                if(que.contains("h"))
                {
                    osmy.setTextColor(Color.GREEN);
                }
                if(que.contains("i"))
                {
                    dziewiaty.setTextColor(Color.GREEN);
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
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
                myButton.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
                txt.setVisibility(View.INVISIBLE);
                idz.setVisibility(View.INVISIBLE);
                zmienkolor(checkBoxess);
                try {
                    Play();
                }catch (IOException e)
                {
                    Toast.makeText(getApplicationContext(),"Były problemy z plikiem",Toast.LENGTH_LONG).show();
                }
            }
        });






        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(liczba==367)
                {
                    liczba=367;
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
                myButton.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
                txt.setVisibility(View.INVISIBLE);
                idz.setVisibility(View.INVISIBLE);
                zmienkolor(checkBoxess);
                try {
                    Play();
                }catch (IOException e)
                {
                    Toast.makeText(getApplicationContext(),"Były problemy z plikiem",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void zmienkolor(CheckBox[] checkBoxes)
    {
        for(int i=0;i<checkBoxes.length;i++)
        {
            checkBoxes[i].setTextColor(Color.BLACK);
        }
    }
}
