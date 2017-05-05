package id.kunya.mvpparsingvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.kunya.mvpparsingvolley.fragment.MainFragment;

/**
 * Created by muhammad on 05/05/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
    }
}
