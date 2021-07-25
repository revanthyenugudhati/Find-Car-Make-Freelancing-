package com.example.freelancer1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Identify_the_car extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button b1_itc;
    TextView tv1_itc;
    ImageView iv_itc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_the_car);

        b1_itc=(Button)findViewById(R.id.b1_itc);
        tv1_itc=(TextView)findViewById(R.id.tv1_itc);
        iv_itc=(ImageView)findViewById(R.id.iv_itc);

        int[] images = {R.drawable.ferrari,R.drawable.mahindra,R.drawable.maruti,R.drawable.mercedes,R.drawable.suzuki,
                R.drawable.tesla,R.drawable.tata,R.drawable.toyota};
        Random rand = new Random();
        int id=rand.nextInt(images.length);
        iv_itc.setImageResource(images[id]);
        iv_itc.setTag(id);
        //Toast.makeText(this, ""+iv_itc.getTag(), Toast.LENGTH_SHORT).show();


        Spinner spinner = (Spinner) findViewById(R.id.sp_itc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.car_make, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        b1_itc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = spinner.getSelectedItem().toString();
                if(text.equals("Select")){
                    tv1_itc.setText("Please select a car make");
                }
                else {
                    if(id==3 && text.equals("Mercedes")){
                        next(view);
                    }
                    else if(id==0 && text.equals("Ferrari")){
                        next(view);
                    }
                    else if(id==6 && text.equals("Tata")){
                        next(view);
                    }
                    else if(id==7 && text.equals("Toyota")){
                        next(view);
                    }
                    else if(id==1 && text.equals("Mahindra")){
                        next(view);
                    }
                    else if(id==4 && text.equals("Suzuki")){
                        next(view);
                    }
                    else if(id==2 && text.equals("Maruti")){
                        next(view);
                    }
                    else if(id==5 && text.equals("Tesla")){
                        next(view);
                    }
                    else {
                        tv1_itc.setText("WRONG ANSWER");
                        tv1_itc.setTextColor(getResources().getColor(R.color.red));
                    }

                }
                //Toast.makeText(Identify_the_car.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });
    }

   public void next(View view){
       tv1_itc.setText("CORRECT ANSWER!");
       tv1_itc.setTextColor(getResources().getColor(R.color.green));
       Button b= (Button)view;
       b.setText("Next");
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //Toast.makeText(Identify_the_car.this, "Getting New image", Toast.LENGTH_SHORT).show();
               Intent i = new Intent(Identify_the_car.this, Identify_the_car.class);
               finish();  //Kill the activity from which you will go to next activity
               startActivity(i);
           }
       });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}