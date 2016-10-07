package llm.com.liwushuo.fragment.top;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import llm.com.liwushuo.R;
import llm.com.liwushuo.adapter.TopRecommendAdapter;
import llm.com.liwushuo.bean.Bean;
import llm.com.liwushuo.utils.TopUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {
    private ListView listView;
    private List<Bean> list=null;
    private TopRecommendAdapter topRecommendAdapter=null;
    private String HeaderViewUtil="";
    private Callback.Cancelable cancelable=null;
    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_recommend, container, false);
        initView(inflate);
        getData();
        return inflate;
    }

    private void initView(View inflate) {
        listView= (ListView) inflate.findViewById(R.id.listView_toprecommend);
        list=new ArrayList<>();
        topRecommendAdapter=new TopRecommendAdapter(getActivity(),list);
        listView.setAdapter(topRecommendAdapter);
    }
    private void addHeader(){
        ImageView imageView=new ImageView(getActivity());
        x.image().bind(imageView,HeaderViewUtil);
        listView.addHeaderView(imageView);
    }
    private void getData(){
        RequestParams requestParams=new RequestParams(TopUtils.RECOMMEND);
        cancelable= x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("=====",result);
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    JSONObject jsonObject1=jsonObject.optJSONObject("data");
                    HeaderViewUtil=jsonObject1.optString("cover_image");
                    JSONArray jsonArray=jsonObject1.optJSONArray("items");
                    for (int i = 0; i <jsonArray.length() ; i++) {
                        Bean bean =new Bean();
                        JSONObject jsonTop100Bean=jsonArray.optJSONObject(i);
                        bean.setCover_image_url(jsonTop100Bean.optString("cover_image_url"));
                        bean.setName(jsonTop100Bean.optString("name"));
                        bean.setShort_description(jsonTop100Bean.optString("short_description"));
                        bean.setPrice(jsonTop100Bean.optString("price"));
                        list.add(bean);
                    }
                    addHeader();
                    Log.i("=====",list.size()+"");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.i("=====","错误");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.i("=====","取消");
            }

            @Override
            public void onFinished() {
                Log.i("=====","完成");
            }
        });
    }

}
