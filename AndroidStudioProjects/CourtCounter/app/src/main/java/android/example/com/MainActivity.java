package android.example.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ScoreTeamA =0;
    int ScoreTeamB =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//For team A
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamA(View view){
        ScoreTeamA = ScoreTeamA +3;
        displayForTeamA(ScoreTeamA);
    }

    public void addTwoForTeamA(View view){
        ScoreTeamA = ScoreTeamA +2;
        displayForTeamA(ScoreTeamA);
    }

    public void addOneForTeamA(View view){
        ScoreTeamA = ScoreTeamA +1;
        displayForTeamA(ScoreTeamA);
    }


    //For Team B
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View view){
        ScoreTeamB = ScoreTeamB +3;
        displayForTeamB(ScoreTeamB);
    }

    public void addTwoForTeamB(View view){
        ScoreTeamB = ScoreTeamB +2;
        displayForTeamB(ScoreTeamB);
    }

    public void addOneForTeamB(View view){
        ScoreTeamB = ScoreTeamB +1;
        displayForTeamB(ScoreTeamB);
    }

    public void reset(View view){
        ScoreTeamA=0;
        ScoreTeamB=0;
        displayForTeamA(ScoreTeamA);
        displayForTeamB(ScoreTeamB);
    }

}
