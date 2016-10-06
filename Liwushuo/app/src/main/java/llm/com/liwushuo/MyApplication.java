package llm.com.liwushuo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by llm on 2016/10/5.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
