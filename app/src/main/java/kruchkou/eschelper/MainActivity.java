package kruchkou.eschelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNewAct, btnOpenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewAct = findViewById(R.id.btnNewAct);
        btnOpenList = findViewById(R.id.btnOpenList);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.btnNewAct: {
                        Intent intent = new Intent(MainActivity.this, newAct.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.btnOpenList: {
                        Intent intent = new Intent(MainActivity.this, list.class);
                        startActivity(intent);
                        break;
                    }
                }

            }
        };

        btnNewAct.setOnClickListener(ocl);
        btnOpenList.setOnClickListener(ocl);
    }
}
