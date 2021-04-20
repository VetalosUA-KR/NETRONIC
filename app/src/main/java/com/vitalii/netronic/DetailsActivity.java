package com.vitalii.netronic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vitalii.netronic.pojo.Result;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivity";

    ImageView imageViewPhoto;
    TextView textViewFirstName;
    TextView textViewLastName;
    TextView textViewTitle;
    TextView textViewGender;
    TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageViewPhoto = findViewById(R.id.person_photo);
        textViewFirstName = findViewById(R.id.person_first_name);
        textViewLastName = findViewById(R.id.person_last_name);
        textViewTitle = findViewById(R.id.person_title);
        textViewGender = findViewById(R.id.person_gender);
        textViewEmail = findViewById(R.id.person_email);


        Bundle arguments = getIntent().getExtras();
        Result person;
        if(arguments!=null){
            person = arguments.getParcelable(Result.class.getSimpleName());

            Picasso.get().load(person.getPicture().getLarge()).into(imageViewPhoto);
            textViewFirstName.setText(person.getName().getFirst());
            textViewLastName.setText(person.getName().getLast());
            textViewTitle.setText(person.getName().getTitle());
            textViewGender.setText(person.getGender());
            textViewEmail.setText(person.getEmail());
        }





    }
}