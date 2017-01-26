package com.hamonteroa.roshambo;

import java.io.Serializable;

/**
 * Created by hamonteroa on 12/26/16.
 */

public class RPSMatch implements Serializable {

    private RPSMove p1;
    private RPSMove p2;

    public RPSMatch(RPSMove p1, RPSMove p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public RPSMove getWinner() {
        return p1.defeats(p2) ? p1 : p2;
    }

    public RPSMove getLoser() {
        return p1.defeats(p2) ? p2 : p1;
    }

    public RPSMove getP1() {
        return p1;
    }

    public RPSMove getP2() {
        return p2;
    }
}
