package llm.com.liwushuo.fragment.top;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import llm.com.liwushuo.R;
import llm.com.liwushuo.adapter.TopOtherAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewStarFragment extends Fragment {
    private ListView listView;
    private List<String> list=null;
    private TopOtherAdapter topOtherAdapter=null;

    public NewStarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_new_star, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        listView= (ListView) inflate.findViewById(R.id.listView_newstar);
        list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("第"+i+"条数据");
        }
        topOtherAdapter=new TopOtherAdapter(getActivity(),list);
        addHeader();
        listView.setAdapter(topOtherAdapter);
    }
    private void addHeader(){
        ImageView imageView=new ImageView(getActivity());
        imageView.setImageResource(R.mipmap.ic_launcher);
        listView.addHeaderView(imageView);
    }

}
