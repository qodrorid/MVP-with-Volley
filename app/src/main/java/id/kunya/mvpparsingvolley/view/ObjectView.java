package id.kunya.mvpparsingvolley.view;

import id.kunya.mvpparsingvolley.model.ObjectModel;

/**
 * Created by muhammad on 05/05/17.
 */

public interface ObjectView {

    interface View extends BaseView<Presenter> {

        void showResult(ObjectModel objectModel);

        void startLoading();

        void stopLoading();

        void showLoadError();
    }

    interface Presenter extends BasePresenter {

        void loadData();
    }

}
