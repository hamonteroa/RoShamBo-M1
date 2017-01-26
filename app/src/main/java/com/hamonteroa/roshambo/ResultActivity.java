package com.hamonteroa.roshambo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;
    private ImageView resultImageView;
    private Button playAgainButton;

    private RPSMatch rpsMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SharedPreferences sp = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        this.rpsMatch = (RPSMatch) getIntent().getSerializableExtra(Constants.CONST_MATCH);

        this.resultTextView = (TextView) findViewById(R.id.result_textView);
        this.resultImageView = (ImageView) findViewById(R.id.result_imageView);
        this.playAgainButton = (Button) findViewById(R.id.play_again_button);

        this.playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        setImageResult();
        setTextResult();
    }

    public void setImageResult() {

        if (rpsMatch.getP1().getRps() == rpsMatch.getP2().getRps()) {
            resultImageView.setImageDrawable(getResources().getDrawable(R.drawable.its_a_tie));
            return;
        }

        switch (rpsMatch.getWinner().getRps()) {
            case Rock:
                resultImageView.setImageDrawable(getResources().getDrawable(R.drawable.rock_crushes_scissors));
                break;

            case Paper:
                resultImageView.setImageDrawable(getResources().getDrawable(R.drawable.paper_covers_rock));
                break;

            case Scissors:
                resultImageView.setImageDrawable(getResources().getDrawable(R.drawable.scissors_cut_paper));
                break;
        }

    }

    public void setTextResult() {
        String resultText;

        if (rpsMatch.getP1().getRps() == rpsMatch.getP2().getRps()) {
            resultText = "It's a tie";
        } else {

            resultText = rpsMatch.getWinner().getRps().toString();

            switch (rpsMatch.getWinner().getRps()) {
                case Rock:
                    resultText += " crushes ";
                    break;

                case Paper:
                    resultText += " covers ";
                    break;

                case Scissors:
                    resultText += " cut ";
                    break;
            }

            resultText += rpsMatch.getLoser().getRps().toString();

            if (rpsMatch.getWinner().getRps() == rpsMatch.getP1().getRps()) {
                resultText += ", you Win!!!";
            } else {
                resultText += ", you lose";
            }
        }

        resultTextView.setText(resultText);
    }
}
