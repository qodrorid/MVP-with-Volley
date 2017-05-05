package id.kunya.mvpparsingvolley.presenter;

import android.content.Context;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import java.util.ArrayList;

import id.kunya.mvpparsingvolley.classes.OnStringListener;
import id.kunya.mvpparsingvolley.classes.StringModelImpl;
import id.kunya.mvpparsingvolley.model.ObjectModel;
import id.kunya.mvpparsingvolley.view.ArrayView;

/**
 * Created by muhammad on 05/05/17.
 */

public class ArrayPresenter implements ArrayView.Presenter, OnStringListener {

    private ArrayView.View view;
    private Context context;
    private ArrayList<ObjectModel.Item> list =new ArrayList<>();
    private StringModelImpl model;

    public ArrayPresenter(Context context, ArrayView.View view){
        this.view = view;
        this.context = context;
        this.view.setPresenter(this);
        model = new StringModelImpl(context);
    }

    @Override
    public void loadData() {
        view.startLoading();
        model.load("https://api.myjson.com/bins/vj17x", this);
    }

    @Override
    public void start() {

    }

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        ObjectModel q = gson.fromJson(result, ObjectModel.class);
        for (ObjectModel.Item item : q.getItems()) {
            list.add(item);
        }
        view.showResult(list);
        view.stopLoading();
    }

    @Override
    public void onError(VolleyError error) {
        view.showLoadError();
        view.stopLoading();
    }

}
