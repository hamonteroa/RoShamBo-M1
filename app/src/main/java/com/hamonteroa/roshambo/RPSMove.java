package com.hamonteroa.roshambo;

import java.io.Serializable;
import java.util.Random;

import static com.hamonteroa.roshambo.RPSMove.RPS.Paper;
import static com.hamonteroa.roshambo.RPSMove.RPS.Rock;
import static com.hamonteroa.roshambo.RPSMove.RPS.Scissors;

/**
 * Created by hamonteroa on 12/26/16.
 */

public class RPSMove implements Serializable{

    public enum RPS {
        Rock,
        Paper,
        Scissors;
    }

    private RPS rps;

    public RPSMove() {
        switch ((new Random()).nextInt(3)) {
            case 0: {
                this.rps = Rock;
                break;
            }

            case 1: {
                this.rps = Paper;
                break;
            }

            default: {
                this.rps = Scissors;
                break;
            }
        }
    }

    public boolean defeats(RPSMove rivalMoves) {
        if (
                (this.rps == Rock && rivalMoves.rps == Scissors) ||
                (this.rps == Paper && rivalMoves.rps == Rock) ||
                (this.rps == Scissors && rivalMoves.rps == Rock)
                ) {

            return true;

        } else {
            return false;
        }
    }

    public RPS getRps() {
        return rps;
    }

    public void setRps(RPS rps) {
        this.rps = rps;
    }
}
