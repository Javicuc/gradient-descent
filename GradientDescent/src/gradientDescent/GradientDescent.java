package gradientDescent;

public class GradientDescent{
    private double theta0;
    private double theta1;

    // Algorithm settings
    double alpha = 0.01;  // learning rate
    int maxiter = 9000;   // maximum number of iterations in case convergence is not reached
    int iters = 0;

    DataSet dataSet;

    public GradientDescent(DataSet ds){
        //initial guesses
        this.theta0 = 0;
        this.theta1 = 0;
        this.dataSet = ds;
    }
    public double predict_y(double x){
        return this.theta1*x + theta0;
    }
    public double deriveTheta1(){
        double sum = 0;

        for (int j=0; j<dataSet.x.length; j++){
                sum += (dataSet.y[j] - predict_y(dataSet.x[j])) * dataSet.x[j];
        }
        return -2 * sum / dataSet.x.length;
    }

    public double deriveTheta0(){
        double sum = 0;

        for (int j=0; j<dataSet.x.length; j++) {
                sum += dataSet.y[j] - predict_y(dataSet.x[j]);
        }
        return -2 * sum / dataSet.x.length;

    }
    public void optimize(){
        do {
                this.theta1 -= alpha * deriveTheta1();
                this.theta0 -= alpha * deriveTheta0();
                iters++;
        } while (iters < maxiter);
        
        System.out.println("theta0 = " + this.theta0 + " and theta1 = " + this.theta1);
    }
}
