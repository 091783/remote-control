package com.androidlearning.remotecontrol;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView ShowPower;
    private TextView ShowVolume;
    private TextView ShowChannel;
    private Switch PowerSwitch;
    private SeekBar VolumeSeekBar;
    private Button Button0;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button7;
    private Button Button8;
    private Button Button9;
    private Button ButtonAdd;
    private Button ButtonReduce;
    private Button ButtonLike;
    private Button ButtonLike2;
    private Button ButtonLike3;
    private Button ButtonReset;
    private boolean Power = false;
    private int Volume = 50;
    private int Channel = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildControls();
        setOnClickListenerAndOther();
    }
    public void buildControls() {
        ShowPower = (TextView) findViewById(R.id.ShowPower);
        ShowVolume = (TextView) findViewById(R.id.ShowVolume);
        ShowChannel = (TextView) findViewById(R.id.ShowChannel);
        PowerSwitch = (Switch) findViewById(R.id.PowerSwitch);
        VolumeSeekBar = (SeekBar) findViewById(R.id.VolumeSeekBar);
        Button0 = (Button) findViewById(R.id.Button0);
        Button1 = (Button) findViewById(R.id.Button1);
        Button2 = (Button) findViewById(R.id.Button2);
        Button3 = (Button) findViewById(R.id.Button3);
        Button4 = (Button) findViewById(R.id.Button4);
        Button5 = (Button) findViewById(R.id.Button5);
        Button6 = (Button) findViewById(R.id.Button6);
        Button7 = (Button) findViewById(R.id.Button7);
        Button8 = (Button) findViewById(R.id.Button8);
        Button9 = (Button) findViewById(R.id.Button9);
        ButtonAdd = (Button) findViewById(R.id.ButtonAdd);
        ButtonReduce = (Button) findViewById(R.id.ButtonReduce);
        ButtonLike = (Button) findViewById(R.id.ButtonLike);
        ButtonLike2 = (Button) findViewById(R.id.ButtonLike2);
        ButtonLike3 = (Button) findViewById(R.id.ButtonLike3);
        ButtonReset = (Button) findViewById(R.id.ButtonReset);
    }
    public void setOnClickListenerAndOther() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked(v);
            }
        };
        PowerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                PowerChange(buttonView,isChecked);
            }
        });
        Button0.setOnClickListener(listener);
        Button1.setOnClickListener(listener);
        Button2.setOnClickListener(listener);
        Button3.setOnClickListener(listener);
        Button4.setOnClickListener(listener);
        Button5.setOnClickListener(listener);
        Button6.setOnClickListener(listener);
        Button7.setOnClickListener(listener);
        Button8.setOnClickListener(listener);
        Button9.setOnClickListener(listener);
        ButtonAdd.setOnClickListener(listener);
        ButtonReduce.setOnClickListener(listener);
        ButtonLike.setOnClickListener(listener);
        ButtonLike2.setOnClickListener(listener);
        ButtonLike3.setOnClickListener(listener);
        ButtonReset.setOnClickListener(listener);
        VolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                VolumeChange(seekBar,i,b);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (Power == false) {
                    VolumeSeekBar.setProgress(Volume);
                    Toast.makeText(MainActivity.this, "电源未打开!", Toast.LENGTH_SHORT).show();
                }
                else {}
            }
        });
    }
    public void PowerChange(CompoundButton buttonView,boolean isChecked) {
        if (isChecked == true) {
            Power = true;
            ShowPower.setText("电源:开");
            setButtonsEnabled();
        }
        else {
            Power = false;
            ShowPower.setText("电源:关");
            setButtonsEnabled();
        }
    }
    public void setButtonsEnabled() {
            Button0.setEnabled(Power);
            Button1.setEnabled(Power);
            Button2.setEnabled(Power);
            Button3.setEnabled(Power);
            Button4.setEnabled(Power);
            Button5.setEnabled(Power);
            Button6.setEnabled(Power);
            Button7.setEnabled(Power);
            Button8.setEnabled(Power);
            Button9.setEnabled(Power);
            ButtonAdd.setEnabled(Power);
            ButtonReduce.setEnabled(Power);
            ButtonLike.setEnabled(Power);
            ButtonLike2.setEnabled(Power);
            ButtonLike3.setEnabled(Power);
            ButtonReset.setEnabled(Power);
    }
    public void VolumeChange(SeekBar seekBar, int i, boolean b) {
        if (Power == false) {}
        else {
            Volume=VolumeSeekBar.getProgress();
            ShowVolume.setText("音量:" + Volume);
        }
    }
    public void ButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.Button0:{
                setChannel(true,0,true);
                break;
            }
            case R.id.Button1:{
                setChannel(true,1,true);
                break;
            }
            case R.id.Button2:{
                setChannel(true,2,true);
                break;
            }
            case R.id.Button3:{
                setChannel(true,3,true);
                break;
            }
            case R.id.Button4:{
                setChannel(true,4,true);
                break;
            }
            case R.id.Button5:{
                setChannel(true,5,true);
                break;
            }
            case R.id.Button6:{
                setChannel(true,6,true);
                break;
            }
            case R.id.Button7:{
                setChannel(true,7,true);
                break;
            }
            case R.id.Button8:{
                setChannel(true,8,true);
                break;
            }
            case R.id.Button9:{
                setChannel(true,9,true);
                break;
            }
            case R.id.ButtonAdd:{
                if (Channel == 999) {
                    Channel = 0;
                }
                else {
                    Channel++;
                }
                ShowChannel.setText("当前频道:" + Channel);
                CheckLike();
                break;
            }
            case R.id.ButtonReduce:{
                if (Channel == 0) {
                    Channel = 999;
                }
                else {
                    Channel--;
                }
                ShowChannel.setText("当前频道:" + Channel);
                CheckLike();
                break;
            }
            case R.id.ButtonLike:{
                setChannel(false,5,false);
                break;
            }
            case R.id.ButtonLike2:{
                setChannel(false,50,false);
                break;
            }
            case R.id.ButtonLike3:{
                setChannel(false,9,false);
                break;
            }
            case R.id.ButtonReset:{
                setChannel(false,0,true);
                break;
            }
        }
    }
    public void setChannel(boolean save,int a,boolean CheckLike) {
        if (save == true) {
            if (Channel > 99) {
                Channel = a;
            }
            else {
                Channel = Channel * 10 + a;
            }
        }
        else {
            Channel = a;
        }
        if (CheckLike == true) {
            CheckLike();
        }
        else {}
        ShowChannel.setText("当前频道:" + Channel);
    }
    public void CheckLike() {
        switch (Channel) {
            case 5:{
                ButtonLike.setTextColor(Color.BLUE);
                break;
            }
            case 50:{
                ButtonLike2.setTextColor(Color.BLUE);
                break;
            }
            case 9:{
                ButtonLike3.setTextColor(Color.BLUE);
                break;
            }
        }
    }
}