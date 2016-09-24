package com.kpt.tunglv.lovecalculator.API;

import android.content.Context;
import android.net.ConnectivityManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by HaHien on 9/21/2016.
 */
public class NetworkUtil {

    private static NetworkUtil sInstance;
    private static RequestQueue sRequestQueue;
    private static Context sContext;

    public NetworkUtil(Context context) {
        initNetworkConfig(context);
    }

    private void initNetworkConfig(Context mcontext) {
        sContext = mcontext;
        sRequestQueue = getRequestQueue();
    }

    private RequestQueue getRequestQueue() {
        if (sRequestQueue == null) {
            sRequestQueue = Volley.newRequestQueue(sContext);
        }
        return sRequestQueue;
    }

    public static synchronized NetworkUtil getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NetworkUtil(context);
        }

        return sInstance;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public boolean isNetworkConnected() {
        ConnectivityManager mConnect = (ConnectivityManager)sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (mConnect.getActiveNetworkInfo() != null
        && mConnect.getActiveNetworkInfo().isAvailable()
        && mConnect.getActiveNetworkInfo().isConnected());
    }
}
