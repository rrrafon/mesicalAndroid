package com.quinzel.mesical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setUpNotes extends AppCompatActivity implements View.OnClickListener {

    private Button bNoteC = null;
    private Button bNoteCS = null;
    private Button bNoteD = null;
    private Button bNoteDS = null;
    private Button bNoteE = null;
    private Button bNoteF = null;
    private Button bNoteFS = null;
    private Button bNoteG = null;
    private Button bNoteGS = null;
    private Button bNoteA = null;
    private Button bNoteAS = null;
    private Button bNoteB = null;
    private Button bBack = null;

    @Override
    public void onClick(View v){
        Intent i = new Intent (setUpNotes.this, record.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_notes);


        bNoteC =  findViewById(R.id.button_C);
        bNoteCS =  findViewById(R.id.button_CS);
        bNoteD =  findViewById(R.id.button_D);
        bNoteDS =  findViewById(R.id.button_DS);
        bNoteE =  findViewById(R.id.button_E);
        bNoteF =  findViewById(R.id.button_F);
        bNoteFS =  findViewById(R.id.button_FS);
        bNoteG =  findViewById(R.id.button_G);
        bNoteGS =  findViewById(R.id.button_GS);
        bNoteA =  findViewById(R.id.button_A);
        bNoteAS =  findViewById(R.id.button_AS);
        bNoteB =  findViewById(R.id.button_B);
        bBack = findViewById(R.id.button_setUpHome);

        bNoteC.setOnClickListener(this);
        bNoteCS.setOnClickListener(this);
        bNoteD.setOnClickListener(this);
        bNoteDS.setOnClickListener(this);
        bNoteE.setOnClickListener(this);
        bNoteF.setOnClickListener(this);
        bNoteFS.setOnClickListener(this);
        bNoteG.setOnClickListener(this);
        bNoteGS.setOnClickListener(this);
        bNoteA.setOnClickListener(this);
        bNoteAS.setOnClickListener(this);
        bNoteB.setOnClickListener(this);


        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent B = new Intent(setUpNotes.this, MainActivity.class);
                startActivity(B);

            }
        });

    }
}
