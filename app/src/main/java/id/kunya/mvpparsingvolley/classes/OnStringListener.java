package id.kunya.mvpparsingvolley.classes;

import com.android.volley.VolleyError;

/**
 * Created by muhammad on 05/05/17.
 */

public interface OnStringListener{

    void onSuccess(String result);

    void onError(VolleyError error);

}

