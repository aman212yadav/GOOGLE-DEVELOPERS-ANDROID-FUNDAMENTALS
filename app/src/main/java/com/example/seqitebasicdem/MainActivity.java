package com.example.seqitebasicdem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button load,save;
    EditText edit1,edit2;
    MyCoreDB myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load=(Button)findViewById(R.id.load);
        save=(Button)findViewById(R.id.save);
        edit1=(EditText)findViewById(R.id.edit1);
        edit2=(EditText)findViewById(R.id.edit2);
        load.setOnClickListener(this);
        save.setOnClickListener(this);
        myDb=new MyCoreDB(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.load)
        {
          myDb.getAll();
        }else{
            String s1=edit1.getText().toString();
            String s2=edit2.getText().toString();
            myDb.InsertData(s1,s2);

        }
    }
}
