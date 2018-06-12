package com.example.asaf7.tabata3;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SeekBar seekBraWork;
    TextView tvWorkTimer;
    EditText etWorkInsert;
    CountDownTimer workTimer;
    int  workGetText;
    long lWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);

        seekBraWork = findViewById(R.id.seek_bar_work);
        seekBraWork.setMax(100);
        seekBraWork.setProgress(10);
        tvWorkTimer = findViewById(R.id.tv_work_timer);
        etWorkInsert = findViewById(R.id.et_work);

        seekBraWork.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                etWorkInsert.setText(progress  +"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                workGetText = Integer.parseInt(etWorkInsert.getText().toString());

                workTimer = new CountDownTimer(workGetText*1000+100,1000) {
                    @Override
                    public void onTick(long l) {

                        lWork = l;
                        tvWorkTimer.setText(lWork/1000+"");

                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();

            }
        });



    }
}
