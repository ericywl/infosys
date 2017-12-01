package eric.quiz3_2017;


import android.os.AsyncTask;

import java.util.Random;

public class EstimatePi extends AsyncTask<Integer, Integer, Double> {
    public interface AsyncResponse {
        void processFinish(Double d);
    }

    private AsyncResponse delegate = null;

    public EstimatePi(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Double doInBackground(Integer... integers) {
        int count = 0;
        int numIters = integers[0];

        for (int i = 0; i < numIters; i++) {
            Random random = new Random();
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) count++;
        }

        return 4.0 * count / (double) numIters;
    }

    @Override
    protected void onPostExecute(Double d) {
        delegate.processFinish(d);
    }
}
