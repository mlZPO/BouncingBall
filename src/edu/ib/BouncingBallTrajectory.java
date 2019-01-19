package edu.ib;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.FixedStepHandler;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.util.ArrayList;

public class BouncingBallTrajectory implements StepHandler {

    private ArrayList<Double> height;
    private ArrayList<Double> velocity;
    private ArrayList<Double> time;

    public BouncingBallTrajectory() {

        time= new ArrayList<>();
        height= new ArrayList<>();
        velocity= new ArrayList<>();
    }

    public ArrayList<Double> getHeight() {

        ArrayList<Double> data = new ArrayList<>(height);
        return data;
    }

    public ArrayList<Double> getVelocity() {
        ArrayList<Double> data = new ArrayList<>(velocity);
        return data;
    }

    public ArrayList<Double> getTime() {
        ArrayList<Double> data = new ArrayList<>(time);
        return data;
    }

    public void clearData(){
        time.clear();
        height.clear();
        velocity.clear();
    }

    @Override
    public void init(double t, double[] x, double dxdt) {

        time.add(t);
        height.add(x[0]);
        velocity.add(x[1]);

    }

    @Override
    public void handleStep(StepInterpolator stepInterpolator, boolean isLast) throws MaxCountExceededException {

        double   t = stepInterpolator.getCurrentTime();
        double[] x = stepInterpolator.getInterpolatedState();

        time.add(t);
        height.add(x[0]);
        velocity.add(x[1]);

    }


}
