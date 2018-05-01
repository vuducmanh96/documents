package theptk.twopaneui;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_details, container, false);
        ImageView ivAvatar =(ImageView)view.findViewById(R.id.ivAvatar);
        TextView tvName =(TextView)view.findViewById(R.id.tvName);
        Bundle bundle=getArguments();
        switch(bundle.getInt("ID",0)){
            case 1:
                ivAvatar.setImageResource(R.mipmap.avatar2);
                tvName.setText("Đỗ Trúc Quỳnh");
                break;
            case 2:
                ivAvatar.setImageResource(R.mipmap.avatar3);
                tvName.setText("Phạm Quỳnh Hương");
                break;
            default:
                ivAvatar.setImageResource(R.mipmap.avatar);
                tvName.setText("Nguyễn Thị Hạnh");
                break;

        }
        return view;
    }
}
