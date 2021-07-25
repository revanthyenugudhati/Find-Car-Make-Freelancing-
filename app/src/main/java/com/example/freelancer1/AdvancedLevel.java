package com.example.freelancer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import static android.os.SystemClock.sleep;

public class AdvancedLevel extends AppCompatActivity {

    EditText et1_ad,et2_ad,et3_ad;
    ImageView iv1_ad,iv2_ad,iv3_ad;
    Button b1_ad;
    int[] images = {R.drawable.ferrari, R.drawable.mahindra, R.drawable.maruti, R.drawable.mercedes, R.drawable.suzuki,
            R.drawable.tesla, R.drawable.tata, R.drawable.toyota};
    Random rand = new Random();
    public int id1 = rand.nextInt(images.length);
    public int id2 = rand.nextInt(images.length);
    public int id3 = rand.nextInt(images.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);
        b1_ad = (Button) findViewById(R.id.b1_ad);
        et1_ad=(EditText)findViewById(R.id.et1_ad);
        et2_ad=(EditText)findViewById(R.id.et2_ad);
        et3_ad=(EditText)findViewById(R.id.et3_ad);
        iv1_ad=(ImageView)findViewById(R.id.iv1_ad);
        iv2_ad=(ImageView)findViewById(R.id.iv2_ad);
        iv3_ad=(ImageView)findViewById(R.id.iv3_ad);

        iv1_ad.setImageResource(images[id1]);
        iv1_ad.setTag(id1);

        iv2_ad.setImageResource(images[id2]);
        iv2_ad.setTag(id2);

        iv3_ad.setImageResource(images[id3]);
        iv3_ad.setTag(id3);

        b1_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean c1= checked1();
                boolean c2= checked2();
                boolean c3= checked3();
                if(c1){
                    et1_ad.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                    et1_ad.setFocusable(false);
                }
                if(c2){
                    et2_ad.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                    et2_ad.setFocusable(false);
                }
                if(c3){
                    et3_ad.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                    et3_ad.setFocusable(false);
                }
                if(c1 && c2 && c3){
                    Button b= (Button)view;
                    b.setText("New Game");
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(Identify_the_car.this, "Getting New image", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(AdvancedLevel.this, AdvancedLevel.class);
                            finish();  //Kill the activity from which you will go to next activity
                            startActivity(i);
                        }
                    });
                }
                else {
                    Toast.makeText(AdvancedLevel.this, "Please Check the Answers", Toast.LENGTH_SHORT).show();
                    if(!c1){
                        et1_ad.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    }
                    if(!c2){
                        et2_ad.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    }

                    if(!c3){
                        et3_ad.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    }

                }
            }
        });


    }

    private boolean checked1() {
        String carMake=getCarMake(id1);
        String entry_et1_ad=et1_ad.getText().toString();
        if(carMake.equals(entry_et1_ad)){
            return true;
        }
        return false;
    }
    private boolean checked2() {
        String carMake=getCarMake(id2);
        String entry_et1_ad=et2_ad.getText().toString();
        if(carMake.equals(entry_et1_ad)){
            return true;
        }
        return false;
    }
    private boolean checked3() {
        String carMake=getCarMake(id3);
        String entry_et1_ad=et3_ad.getText().toString();
        if(carMake.equals(entry_et1_ad)){
            return true;
        }
        return false;
    }

    private String getCarMake(int id) {
        if (id == 0) {
            return "ferrari";
        } else if (id == 1) {
            return "mahindra";
        }
        else if (id == 2) {
            return "maruti";
        }
        else if (id == 3) {
            return "mercedes";
        }
        else if (id == 4) {
            return "suzuki";
        }
        else if (id == 5) {
            return "tesla";
        }
        else if (id == 6) {
            return "tata";
        }
        else if (id == 7) {
            return "toyota";
        }
        return null;
    }
}