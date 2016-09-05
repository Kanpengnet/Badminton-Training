package kbu.sineepun.kanpengnet.badmintontraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

public class SubTest extends AppCompatActivity {
//expliccit
    private  int indexAnInt;
    private MyConstance myConstance = new MyConstance();
    private String[] subVideo = myConstance.getVideoStrings();
    private String pathVideo = "android.resource://kbu.sineepun.kanpengnet.badmintontraining/raw/";
    private VideoView videoView;
    private String[] pointStrings = myConstance.getPointStrings();
    private Spinner spinner;
    private ArrayAdapter<String> stringArrayAdapter;
    private int spinnerAnInt = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_test);

        //bind widget
        videoView = (VideoView) findViewById(R.id.videoView);
        spinner = (Spinner) findViewById(R.id.spinner);

        indexAnInt = getIntent().getIntExtra("Index", 0);
        Log.d("5sepV3", "Index ==>" + indexAnInt);

        videoView.setVideoPath(pathVideo+subVideo[indexAnInt]);

        Log.d("5sepV3", "path Video ==> " + (pathVideo + subVideo[indexAnInt]));

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        stringArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,pointStrings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerAnInt = Integer.parseInt(pointStrings[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerAnInt = 20;

            }


        });




    }//main method
    public void clickSaveSubTest(View view) {

        Log.d("5SepV4", "index ==>" + indexAnInt);
        Log.d("5SepV4", "Spinner == >"+ spinnerAnInt);
        myConstance.setupPointInt(indexAnInt,spinnerAnInt);
        finish();
    }
}//mainclass
