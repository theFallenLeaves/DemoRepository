package llm.com.liwushuo.fragment.top;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import llm.com.liwushuo.R;
import llm.com.liwushuo.adapter.TopRecommendAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {
    private ListView listView=null;
    private List<String> list=null;
    private TopRecommendAdapter topRecommendAdapter=null;
    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_recommend, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
       listView= (ListView) inflate.findViewById(R.id.listView_toprecommend);
        list=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("第"+i+"条数据");
        }
        topRecommendAdapter=new TopRecommendAdapter(getActivity(),list);
        addHeader();
        listView.setAdapter(topRecommendAdapter);
    }
    private void addHeader(){
        ImageView imageView=new ImageView(getActivity());
        imageView.setImageResource(R.mipmap.ic_launcher);
        listView.addHeaderView(imageView);
    }
}
