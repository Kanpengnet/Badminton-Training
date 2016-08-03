package kbu.sineepun.kanpengnet.badmintontraining;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckScore extends AppCompatActivity {


    //explicit
    private ImageView addScoreAImagerView, addScoreBImageView;
    private TextView playerATextView, playerBTextView,
            scoreAtextView,scoreBtextView;

    private  String playerAString, playerBString;
    private int scoreAnInt = 0, scoreBAnInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score);

        //Bind Widget
        playerATextView = (TextView) findViewById(R.id.textView20);
        playerBTextView = (TextView) findViewById(R.id.textView21);
        scoreAtextView = (TextView) findViewById(R.id.textView18);
        scoreBtextView = (TextView) findViewById(R.id.textView19);
        addScoreAImagerView = (ImageView) findViewById(R.id.imageView17);
        addScoreBImageView = (ImageView) findViewById(R.id.imageView18);

        //Show Player
        playerAString = getIntent().getStringExtra("A");
        playerBString = getIntent().getStringExtra("B");
        playerATextView.setText(playerAString);
        playerBTextView.setText(playerBString);
        //Click ADD scoreA
        addScoreAImagerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changScore(scoreAtextView,0);
                soundEffect();
            } //onClick
        });

        //Click Add scoreB
        addScoreBImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changScore(scoreBtextView, 1);
                soundEffect();

            }//onclick
        });

    }//main method

    private void soundEffect() {
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.phonton1);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });


    }
    private void changScore(TextView scoreShow,int index) {
        int intShowScore = 0;
        switch (index) {
            case 0:
            scoreAnInt += 1;
            intShowScore = scoreAnInt;
            break;
            case 1:
                scoreBAnInt += 1;
                intShowScore = scoreBAnInt;
        }
        scoreShow.setText(Integer.toString(intShowScore));

    }//checkScore


}//main class
