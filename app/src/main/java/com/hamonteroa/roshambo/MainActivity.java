package com.hamonteroa.roshambo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockButton = (Button)findViewById(R.id.rock_button);
        paperButton = (Button)findViewById(R.id.paper_button);
        scissorsButton = (Button)findViewById(R.id.scissors_button);

        rockButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RPSMove rpsMove = new RPSMove();
                rpsMove.setRps(RPSMove.RPS.Rock);
                goToResultActivity(rpsMove);
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RPSMove rpsMove = new RPSMove();
                rpsMove.setRps(RPSMove.RPS.Paper);
                goToResultActivity(rpsMove);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RPSMove rpsMove = new RPSMove();
                rpsMove.setRps(RPSMove.RPS.Scissors);
                goToResultActivity(rpsMove);
            }
        });
    }

    private void goToResultActivity(RPSMove p1) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(Constants.CONST_MATCH, (new RPSMatch(p1, (new RPSMove()))));
        startActivity(intent);

    }
}
