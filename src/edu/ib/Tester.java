package edu.ib;

import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.sampling.FixedStepHandler;
import org.apache.commons.math3.ode.sampling.StepHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {


        FirstOrderDifferentialEquations freeFall= new FreeFall();

        FirstOrderIntegrator rkIntegrator= new ClassicalRungeKuttaIntegrator(0.01);
        BouncingBallTrajectory ballTrajectory= new BouncingBallTrajectory();
        rkIntegrator.addStepHandler(ballTrajectory);

        TurningPoint turningPoint= new TurningPoint();
        rkIntegrator.addEventHandler(turningPoint,0.1,0.001,2000);

        double [] x={1,0};
        rkIntegrator.integrate(freeFall,0,x,0.5,x);
        System.out.println(Arrays.toString(x));

        try {
            writeToFile(ballTrajectory.getTime(),ballTrajectory.getVelocity());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void writeToFile(ArrayList<Double> t, ArrayList<Double> x) throws IOException {

        BufferedWriter writer= new BufferedWriter(new FileWriter("test.txt"));
        for(int i=0; i<t.size(); i++)
            writer.write(t.get(i).toString() + '\t' + x.get(i).toString() +  '\t' + x.get(i).toString()+'\n');
        writer.flush();
        writer.close();

    }


}
