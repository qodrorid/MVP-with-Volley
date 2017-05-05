package id.kunya.mvpparsingvolley.classes;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by muhammad on 05/05/17.
 */

public class VolleyConf {

    private static VolleyConf volleyConf;
    private RequestQueue requestQueue;

    private VolleyConf(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleyConf getVolleySingleton(Context context){
        if(volleyConf == null){
            volleyConf = new VolleyConf(context);
        }
        return volleyConf;
    }

    public RequestQueue getRequestQueue(){
        return this.requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }

}
