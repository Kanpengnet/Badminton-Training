package kbu.sineepun.kanpengnet.badmintontraining;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckScore2 extends AppCompatActivity {


    //explicit
    private ImageView addScoreCImagerView, addScoreDImageView;
    private TextView playerATextView,playerBTextView,playerCTextView,playerDTextView,
            scoreCtextView,scoreDtextView;

    private  String playerAString, playerBString,playerCString, playerDString;
    private int scoreCnInt = 0, scoreDAnInt = 0;
    private  boolean statusABoolean = true;//true สภาวะปกติ false สภาวะดิว

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_score2);

        //Bind Widget
        playerATextView = (TextView) findViewById(R.id.textView24);
        playerBTextView = (TextView) findViewById(R.id.textView25);
        playerCTextView = (TextView) findViewById(R.id.textView26);
        playerDTextView = (TextView) findViewById(R.id.textView27);
        scoreCtextView = (TextView) findViewById(R.id.textView22);
        scoreDtextView = (TextView) findViewById(R.id.textView23);
        addScoreCImagerView = (ImageView) findViewById(R.id.imageView26);
        addScoreDImageView = (ImageView) findViewById(R.id.imageView27);

        //Show Player
        playerAString = getIntent().getStringExtra("A");
        playerBString = getIntent().getStringExtra("B");
        playerCString = getIntent().getStringExtra("C");
        playerDString = getIntent().getStringExtra("D");
        playerATextView.setText(playerAString);
        playerBTextView.setText(playerBString);
        playerCTextView.setText(playerCString);
        playerDTextView.setText(playerDString);

        //Click ADD scoreA
        addScoreCImagerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changScore(scoreCtextView,0);
                soundEffect();
            } //onClick
        });

        //Click Add scoreB
        addScoreDImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changScore(scoreDtextView, 1);
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
                scoreCnInt += 1;
                intShowScore = scoreCnInt;
                break;
            case 1:
                scoreDAnInt += 1;
                intShowScore = scoreDAnInt;
        }
        scoreShow.setText(Integer.toString(intShowScore));

        //Check Status
        if ((scoreCnInt == 20)&&(scoreDAnInt == 20)) {
            statusABoolean = false;//มีการตดิวเกิดขึ้น
        }

        //check Score
        if (statusABoolean) {
            // ปกติ

            if (scoreCnInt == 21) {
                alertScore(playerAString, scoreCnInt, scoreDAnInt);

            } else if (scoreDAnInt == 21) {
                alertScore(playerBString,scoreDAnInt,scoreCnInt);
            }

        } else {
            //ดิว
            if ((scoreCnInt - scoreDAnInt) >= 2) {
                alertScore(playerAString, scoreCnInt, scoreDAnInt);
            } else if ((scoreDAnInt - scoreCnInt) >= 2) {
                alertScore(playerBString, scoreDAnInt, scoreDAnInt);
            } else if (scoreCnInt == 30) {
                alertScore(playerAString, scoreCnInt, scoreDAnInt);
            } else if (scoreDAnInt == 30) {
                alertScore(playerBString, scoreDAnInt, scoreDAnInt);
            }

        }//if

    }//checkScore

    private void alertScore(String strwin, int intScoreWin, int intScoreLost) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle("ยินดีในชัยชนะ คุณ " + strwin);
        builder.setMessage("คะแนนของคุณ " +
                Integer.toString(intScoreWin) +
                " : " +
                Integer.toString(intScoreLost));
        builder.setNegativeButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetAll();
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }// alertScore

    private void resetAll() {

        scoreCnInt = 0;
        scoreDAnInt = 0;
        scoreCtextView.setText("0");
        scoreDtextView.setText("0");
        statusABoolean = true;
    }


}//main class
