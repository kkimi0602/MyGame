package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Accelero accelero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelero = new Accelero(this);

        TextView textView = (TextView) findViewById(R.id.adat);
        ImageView imageView = (ImageView) findViewById(R.id.fly);

        accelero.setListener(new Accelero.Listener() {
            float flyx = imageView.getX();
            float flyy = imageView.getY();
            @Override
            public void onTranslation(float x, float y, float z) {
                if (flyx > -0.1 && flyx < 850.0 && flyy > -0.1 && flyy < 1500.0) {
                    if (x == 0.0f && z == 0.0f) {
                        imageView.setX(200);
                        imageView.setY(200);
                    }
                    if (z < -0.1f) {
                        for (int i = 0; i < 10; i++) {
                            textView.setText("le");
                            float j = flyy += 1;
                            imageView.setY(j);
                        }
                    }
                    if (z > 0.1f) {
                        for (int i = 0; i < 10; i++) {
                            textView.setText("fel");
                            float j2 = flyy -= 1;
                            imageView.setY(j2);
                        }
                    }
                    if (x < -0.1f) {
                        for (int j = 0; j < 10; j++) {
                            textView.setText("jobbra");
                            float i = flyx += 1;
                            imageView.setX(i);
                        }
                    }
                    if (x > 0.1f) {
                        for (int j = 0; j < 10; j++) {
                            textView.setText("balra");
                            float i2 = flyx -= 1;
                            imageView.setX(i2);
                        }
                    }
                }else{
                    textView.setText("Vesztettél!");
                }
            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();
        accelero.register();
    }
    @Override
    protected void onPause(){
        super.onPause();
        accelero.register();
    }
}