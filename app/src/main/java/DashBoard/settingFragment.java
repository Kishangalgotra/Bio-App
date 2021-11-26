package DashBoard;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.account.bio.R;

public class settingFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public settingFragment() {
        // Required empty public constructor
    }
    ListView setting_list_view;

    public static settingFragment newInstance(String param1, String param2) {
        settingFragment fragment = new settingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        instantiate(v);
        return  v;
    }


    public void instantiate(View v){
        String[] array ={"Storage and Data","Log out","Update","Help",};
        setting_list_view = v.findViewById(R.id.setting_list_view);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.setting_item,array);
        Adaptor adaptor = new Adaptor(getActivity(),array);
        setting_list_view.setAdapter(adaptor);
        setting_list_view.setOnItemClickListener((parent, view, position, id) -> {

        });
    }

    class Adaptor extends ArrayAdapter<String>{

        Context context;
        String[] title;
        public Adaptor(@NonNull Context context, String[] resource) {
            super(context, R.layout.setting_item,resource);
            this.title = resource;
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.setting_item,parent,false);
            TextView textView = v.findViewById(R.id.switch3);
            textView.setText(title[position]);
            return v;
        }
    }
}