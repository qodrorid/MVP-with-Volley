package id.kunya.mvpparsingvolley.view;


import java.util.ArrayList;

import id.kunya.mvpparsingvolley.model.ObjectModel;

/**
 * Created by muhammad on 05/05/17.
 */

public interface ArrayView {

    interface View extends BaseView<Presenter> {

        void showResult(ArrayList<ObjectModel.Item> arrayList);

        void startLoading();

        void stopLoading();

        void showLoadError();
    }

    interface Presenter extends BasePresenter {

        void loadData();
    }

}
