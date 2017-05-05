package id.kunya.mvpparsingvolley.presenter;

import android.content.Context;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import id.kunya.mvpparsingvolley.classes.OnStringListener;
import id.kunya.mvpparsingvolley.classes.StringModelImpl;
import id.kunya.mvpparsingvolley.model.ObjectModel;
import id.kunya.mvpparsingvolley.view.ObjectView;

/**
 * Created by muhammad on 05/05/17.
 */

public class ObjectPresenter implements ObjectView.Presenter, OnStringListener {

    private ObjectView.View view;
    private Context context;
    private StringModelImpl model;

    public ObjectPresenter(Context context, ObjectView.View view){
        this.view = view;
        this.context = context;
        this.view.setPresenter(this);
        model = new StringModelImpl(context);
    }

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        ObjectModel q = gson.fromJson(result, ObjectModel.class);

        view.showResult(q);
        view.stopLoading();
    }

    @Override
    public void onError(VolleyError error) {
        view.showLoadError();
        view.stopLoading();
    }

    @Override
    public void loadData() {
        view.startLoading();
        model.load("https://api.myjson.com/bins/vj17x", this);
    }

    @Override
    public void start() {

    }
}
