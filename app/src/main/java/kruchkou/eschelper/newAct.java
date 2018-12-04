package kruchkou.eschelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;


public class newAct extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    Button btnSaveAct, btnCancel;
    DBHelper dbHelper;

    EditText editModel, editNumber, editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        btnSaveAct = findViewById(R.id.btnSaveAct);
        btnCancel = findViewById(R.id.btnDelete);

        editModel = (EditText) findViewById(R.id.editModel);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editNote = (EditText) findViewById(R.id.editNote);

        dbHelper = new DBHelper(this);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.btnSaveAct: {

                        saveAct();

                        break;
                    }
                    case R.id.btnDelete: {

                        break;
                    }
                }
            }
        };

        btnSaveAct.setOnClickListener(ocl);
        btnCancel.setOnClickListener(ocl);
    }

    public void saveAct() {
        ContentValues cv = new ContentValues();

        String eModel = editModel.getText().toString();
        String eNote = editNote.getText().toString();
        int eNumber = (int) parseInt(editNumber.getText().toString());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        cv.put("act_id", eNumber);
        cv.put("model", eModel);
        cv.put("note", eNote);

        long rowID = db.insert("mytable", null, cv);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);

        this.finish();

        // в последсвии this.finish() заменить на

//        Intent intent = new Intent(ThisActivity.this, NewActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(ThisActivity.this, intent);

        // с переходом на list
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table acts ("
                    + "id integer primary key autoincrement,"
                    + "act_id integer,"
                    + "model text,"
                    + "note text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
