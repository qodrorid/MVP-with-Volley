package id.kunya.mvpparsingvolley.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.kunya.mvpparsingvolley.R;
import id.kunya.mvpparsingvolley.adapter.ArrayAdapter;
import id.kunya.mvpparsingvolley.model.ObjectModel;
import id.kunya.mvpparsingvolley.view.ArrayView;

/**
 * Created by muhammad on 05/05/17.
 */

public class ArrayFragment extends Fragment
        implements ArrayView.View {

    private ArrayView.Presenter presenter;
    private ArrayAdapter adapter;
    private RecyclerView recyclerView;

    public ArrayFragment() {
    }

    public static ArrayFragment newInstance(int page) {
        return new ArrayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_array, container, false);

        initViews(view);

        presenter.loadData();

        return view;
    }

    @Override
    public void showResult(ArrayList<ObjectModel.Item> arrayList) {
        if (adapter == null) {
            adapter = new ArrayAdapter(getActivity(), arrayList);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
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
    public void setPresenter(ArrayView.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    @Override
    public void initViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }
}
