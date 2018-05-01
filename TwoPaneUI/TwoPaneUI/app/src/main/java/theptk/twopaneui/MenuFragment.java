package theptk.twopaneui;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment implements View.OnClickListener {
    private boolean mDualPane;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        View detailsFrame = getActivity().findViewById(R.id.flDetail);
        mDualPane = detailsFrame != null;
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button bt1,bt2,bt3;
        View view=inflater.inflate(R.layout.fragment_menu, container, false);
        bt1 = (Button)view.findViewById(R.id.bt1);
        bt2 = (Button)view.findViewById(R.id.bt2);
        bt3 = (Button)view.findViewById(R.id.bt3);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        return view;
    }

    private void changeLayout(int id){
       if(mDualPane){
           DetailsFragment detailsFragment = new DetailsFragment();
           Bundle args = new Bundle();
           args.putInt("ID", id);
           detailsFragment.setArguments(args);
           getFragmentManager().beginTransaction()
                   .replace(R.id.flDetail, detailsFragment)
                   .commit();
       }else {
           Intent intent = new Intent();
           intent.setClass(getActivity(), DetailsActivity.class);
           intent.putExtra("ID", id);
           startActivity(intent);
       }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt1:
                changeLayout(0);
                break;
            case R.id.bt2:
                changeLayout(1);
                break;
            case R.id.bt3:
                changeLayout(2);
                break;

        }
    }
}
