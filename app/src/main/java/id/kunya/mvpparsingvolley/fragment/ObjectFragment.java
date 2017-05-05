package id.kunya.mvpparsingvolley.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.kunya.mvpparsingvolley.R;
import id.kunya.mvpparsingvolley.model.ObjectModel;
import id.kunya.mvpparsingvolley.view.ObjectView;

/**
 * Created by muhammad on 05/05/17.
 */

public class ObjectFragment extends Fragment implements ObjectView.View {

    private ObjectView.Presenter presenter;
    private TextView sapa;

    public ObjectFragment() {
    }

    public static ObjectFragment newInstance(int page) {
        return new ObjectFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_object, container, false);

        initViews(view);

        presenter.loadData();

        return view;
    }

    @Override
    public void showResult(ObjectModel objectModel) {
        sapa.setText("\nStatus : "+objectModel.getStatus()+"\n"+
                     "Total : "+objectModel.getTotal()+"\n"+
                     "Salam : "+objectModel.getSalam());
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showLoadError() {

    }

    @Override
    public void setPresenter(ObjectView.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    @Override
    public void initViews(View view) {
        sapa = (TextView) view.findViewById(R.id.status);
    }
}
