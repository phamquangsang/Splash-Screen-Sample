package sample.pham.sang.memoryleaksample;

import android.app.Application;

public class HeavyApplicationInitialization extends Application {

    public HeavyApplicationInitialization() {
        super();
        try {
            //simulate working hard to initialize application
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
