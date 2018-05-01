package theptk.twopaneui;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createView();
    }

    private void createView() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MenuFragment menuFragment = new MenuFragment();
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            DetailsFragment detailsFragment = new DetailsFragment();
            Bundle args = new Bundle();
            args.putInt("ID", 0);
            detailsFragment.setArguments(args);
            ft.add(R.id.flDetail, detailsFragment, "DETAIL");
        }
        ft.add(R.id.flMenu, menuFragment, "MENU").disallowAddToBackStack();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }


}
