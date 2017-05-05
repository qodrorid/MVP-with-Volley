package id.kunya.mvpparsingvolley.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import id.kunya.mvpparsingvolley.fragment.ArrayFragment;
import id.kunya.mvpparsingvolley.fragment.ObjectFragment;
import id.kunya.mvpparsingvolley.presenter.ArrayPresenter;
import id.kunya.mvpparsingvolley.presenter.ObjectPresenter;

/**
 * Created by muhammad on 05/05/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = {"Object", "Array"};
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1){
            ArrayFragment fragment = ArrayFragment.newInstance(position + 1);
            new ArrayPresenter(context, fragment);
            return fragment;
        }
        ObjectFragment fragment = ObjectFragment.newInstance(position + 1);
        new ObjectPresenter(context, fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
