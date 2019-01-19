package edu.ib;

import org.apache.commons.math3.ode.events.EventHandler;

public class TurningPoint implements EventHandler {

    private int sign;

    @Override
    public void init(double t, double[] x, double dxdt) {
        sign=1;
    }

    @Override
    public double g(double t, double[] x) {
        return sign * x[0];
    }

    @Override
    public Action eventOccurred(double t, double[] x, boolean b) {
        sign = -sign;
        return Action.RESET_STATE;
    }

    @Override
    public void resetState(double t, double[] x) {
        x[1] = -x[1];
    }
}
