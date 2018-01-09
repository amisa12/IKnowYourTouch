package com.example.amisa.iknowyourtouch;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.gesture.Gesture;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

import static android.view.GestureDetector.*;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnDoubleTapListener,GestureDetector.OnGestureListener{
    private static TextView textView;
    private TextToSpeech textSpeech;
    private static GestureDetectorCompat GestureDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        GestureDetect=new GestureDetectorCompat(this,this);
        GestureDetect.setOnDoubleTapListener(this);

        textSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                textSpeech.setLanguage(Locale.ENGLISH);
            }
        });

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        GestureDetect.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {

        textView.setText("onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {

        textView.setText("onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {

        textView.setText("You have Double tapped me");
        String toSpeak = textView.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        textSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {

        textView.setText("onDown" );
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {

        textView.setText("onSingleTapUp" );
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        textView.setText("onScroll" );
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

        textView.setText("You have long pressed me");
        String toSpeak = textView.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        textSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        textView.setText("onFling");
        return false;
    }
}
