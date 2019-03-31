package com.example.seqitebasicdem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MyCoreDB extends SQLiteOpenHelper {
    static final private  String DB_NAME="education";
    static final private String DB_TABLE="students";
    static final private int VERSION=1;
    static final private String COL1="stu_name";
    static final private String COL2="college";
    SQLiteDatabase myDB;
    Context ctx;
    public MyCoreDB( Context context) {
        super(context, DB_NAME,null,VERSION);
        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create table "+DB_TABLE + "( _id integer primary key autoincrement,stu_name text,college text );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DB_TABLE);
        onCreate(db);

    }
    public void InsertData(String s1,String s2){
        myDB=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL1,s1);
        cv.put(COL2,s2);
        myDB.insert(DB_TABLE,null,cv);
        Toast.makeText(ctx,"Inserted successfully ",Toast.LENGTH_SHORT).show();


    }
    public void getAll(){
        myDB=getReadableDatabase();
        Cursor cr= (Cursor) myDB.rawQuery("select * from "+DB_TABLE,null);
        StringBuilder str=new StringBuilder();
        while(cr.moveToNext()){
            String s1=cr.getString(1);
            String s2=cr.getString(2);
            str.append(s1+"          "+s2+"\n");
        }
        Toast.makeText( ctx,str.toString(),Toast.LENGTH_SHORT).show();

    }
}
