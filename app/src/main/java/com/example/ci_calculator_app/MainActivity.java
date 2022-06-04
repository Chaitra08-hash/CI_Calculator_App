package com.example.ci_calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;

import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    private Button one,two,three,four,five,six,seven,eight,nine,zero,equal,add,sub,mul,div,percentage,dot,btnc,bracket;
    private ImageButton backspace;
    boolean checkbracket =false;
    private TextView tvi,tvr;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one=(Button)findViewById(R.id.ONE);
        two=(Button)findViewById(R.id.TWO);
        three=(Button)findViewById(R.id.THREE);
        four=(Button)findViewById(R.id.FOUR);
        five=(Button)findViewById(R.id.FIVE);
        six=(Button)findViewById(R.id.SIX);
        seven=(Button)findViewById(R.id.SEV);
        eight=(Button)findViewById(R.id.EIG);
        nine=(Button)findViewById(R.id.NINE);
        zero=(Button)findViewById(R.id.ZERO);
        dot=(Button)findViewById(R.id.DOT);
        btnc=(Button)findViewById(R.id.CLEAR);
        add=(Button)findViewById(R.id.ADD);
        sub=(Button)findViewById(R.id.SUB);
        mul=(Button)findViewById(R.id.MUL);
        div=(Button)findViewById(R.id.DIV);
        equal=(Button)findViewById(R.id.EQUAL);
        percentage=(Button) findViewById(R.id.MOD);
        bracket=findViewById(R.id.BRACKET);
        tvi=findViewById(R.id.v1);
        tvr=findViewById(R.id.v2);
        backspace=findViewById(R.id.BACK);

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvi.setText("");
                tvr.setText("");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"+");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"-");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"/");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+".");
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process=tvi.getText().toString();
                tvi.setText(process+"%");
            }
        });

        bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkbracket==true) {
                    process = tvi.getText().toString();
                    tvi.setText(process + ")");
                    checkbracket = false;
                }
                else
                {
                    process = tvi.getText().toString();
                    tvi.setText(process + ")");
                    checkbracket = true;
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process =tvi.getText().toString();
                process =process.replaceAll("x","*");
                process =process.replaceAll("%","/100");
                process =process.replaceAll("÷","/");


                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalresult="";
                try {

                    Scriptable scriptable = rhino.initStandardObjects();
                    finalresult=rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }
                catch (Exception e)
                {
                    finalresult="0";
                }
                tvr.setText(finalresult);
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!process.equals("")){
                    process=tvi.getText().toString();
                    if(process.length()>0){
                       process=process.substring(0,process.length()-1);
                       tvi.setText(process);
                    }
                }
            }
        });
    }
}