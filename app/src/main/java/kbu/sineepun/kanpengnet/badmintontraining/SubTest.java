package kbu.sineepun.kanpengnet.badmintontraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SubTest extends AppCompatActivity {
//expliccit
    private  int indexAnInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_test);
        indexAnInt = getIntent().getIntExtra("Index", 0);
        Log.d("5sepV3", "Index ==>" + indexAnInt);


    }//main method
}//mainclass
