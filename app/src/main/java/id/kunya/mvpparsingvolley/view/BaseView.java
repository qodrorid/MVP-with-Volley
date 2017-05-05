package id.kunya.mvpparsingvolley.view;

import android.view.View;

/**
 * Created by muhammad on 05/05/17.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void initViews(View view);

}
