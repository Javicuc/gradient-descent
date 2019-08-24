package gradientDescent;
public class TestGradDescent {
        public static void main(String[] args ){
                DataSet ds = new DataSet();
                GradientDescent gd = new GradientDescent(ds);
                gd.optimize();
        }
}
