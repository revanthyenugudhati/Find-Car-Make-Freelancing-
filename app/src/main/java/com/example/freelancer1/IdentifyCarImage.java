package com.example.freelancer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IdentifyCarImage extends AppCompatActivity {
    Button b1_ici;
    TextView tv1_ici, tv2_ici;
    ImageView iv_ici;
    EditText et_ici;
    int[] images = {R.drawable.ferrari, R.drawable.mahindra, R.drawable.maruti, R.drawable.mercedes, R.drawable.suzuki,
            R.drawable.tesla, R.drawable.tata, R.drawable.toyota};
    Random rand = new Random();
    public int id = rand.nextInt(images.length);
    public String tv_text="";
    public String carMake = getCarMake(id);
    public String entry="";
    public int wrong_count=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_car_image);
        b1_ici = (Button) findViewById(R.id.b1_ici);
        tv1_ici = (TextView) findViewById(R.id.tv1_ici);
        tv2_ici = (TextView) findViewById(R.id.tv2_ici);
        iv_ici = (ImageView) findViewById(R.id.iv_ici);
        et_ici = (EditText) findViewById(R.id.et1_ici);


        iv_ici.setImageResource(images[id]);
        iv_ici.setTag(id);
        //Toast.makeText(this, ""+iv_itc.getTag(), Toast.LENGTH_SHORT).show();

        int carMakeLength= getCarMakeLength(id);
        populateTextView(carMakeLength);

        b1_ici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entry = et_ici.getText().toString().toLowerCase();
                isCorrect(entry,view);
            }
        });
    }

    private void populateTextView(int carMakeLength) {

        for(int i=0;i<carMakeLength;i++){
            tv_text=tv_text+"*";
        }
        tv2_ici.setText(tv_text);
    }

    private int getCarMakeLength(int id) {
        if (id == 0) {
            return "Ferrari".length();
        } else if (id == 1) {
            return "Mahindra".length();
        }
        else if (id == 2) {
            return "Maruti".length();
        }
        else if (id == 3) {
            return "Mercedes".length();
        }
        else if (id == 4) {
            return "Suzuki".length();
        }
        else if (id == 5) {
            return "Tesla".length();
        }
        else if (id == 6) {
            return "Tata".length();
        }
        else if (id == 7) {
            return "Toyota".length();
        }
        return 0;
    }

    private void isCorrect(String entry, View view) {

        char [] carMakeAr=carMake.toCharArray();
        //char entrych = entry.charAt(0);
        if(carMake.contains(entry)){
            //Toast.makeText(this, "The letter is present", Toast.LENGTH_SHORT).show();
            tv1_ici.setText("Correct");
            populateLetterInTextView(view);
        }
        else{
            Toast.makeText(this, "The letter is not present", Toast.LENGTH_SHORT).show();
            wrong_count--;
            if(wrong_count>1)
                tv1_ici.setText("Wrong Answer "+wrong_count+" chances left");
            else if(wrong_count==1)
                tv1_ici.setText("Wrong Answer "+wrong_count+" chance left");
            else {
                tv1_ici.setText("Game Over");
                Button b= (Button)view;
                b.setText("Restart");
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(Identify_the_car.this, "Getting New image", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(IdentifyCarImage.this, IdentifyCarImage.class);
                        finish();  //Kill the activity from which you will go to next activity
                        startActivity(i);
                    }
                });
            }
        }
    }

    private void populateLetterInTextView(View view) {
        String carMake_temp = carMake;
        char [] carMake_temp_ar=tv_text.toCharArray();
        char entry_temp = entry.charAt(0);
        String entry_temp_string=""+entry_temp;
        int count = 0;

        for (int i = 0; i < carMake_temp.length(); i++) {
            if (carMake_temp.charAt(i)== entry_temp) {
                carMake_temp_ar[i]=entry_temp;
            }
        }
        tv_text=String.valueOf(carMake_temp_ar);
        Toast.makeText(this, tv_text, Toast.LENGTH_SHORT).show();
        tv2_ici.setText(tv_text);
        if(tv_text.equals(carMake)){
            Button b= (Button)view;
            b.setText("New Game");
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(Identify_the_car.this, "Getting New image", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(IdentifyCarImage.this, IdentifyCarImage.class);
                    finish();  //Kill the activity from which you will go to next activity
                    startActivity(i);
                }
            });
        }
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