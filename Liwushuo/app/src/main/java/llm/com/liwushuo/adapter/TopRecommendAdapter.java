package llm.com.liwushuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import llm.com.liwushuo.R;

/**
 * Created by llm on 2016/10/4.
 */
public class TopRecommendAdapter extends BaseAdapter {
   private Context context=null;
    private List<String> list=null;
    public TopRecommendAdapter(Context context,List<String> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            viewHolder=new ViewHolder();
            view=LayoutInflater.from(context).inflate(R.layout.item_top,viewGroup,false);
            viewHolder.imageView1= (ImageView) view.findViewById(R.id.imageView1_topRecommendItem);
            viewHolder.imageView2= (ImageView) view.findViewById(R.id.imageView2_topRecommendItem);
            viewHolder.imageView1Title= (TextView) view.findViewById(R.id.textView1_topRecommendItem_ImageViewTitle);
            viewHolder.imageView2Title= (TextView) view.findViewById(R.id.textView2_topRecommendItem_ImageViewTitle);
            viewHolder.title1= (TextView) view.findViewById(R.id.textView1_topRecommendItem_Title);
            viewHolder.title2= (TextView) view.findViewById(R.id.textView2_topRecommendItem_Title);
            viewHolder.price1= (TextView) view.findViewById(R.id.textView1_topRecommendItem_Price);
            viewHolder.price2= (TextView) view.findViewById(R.id.textView2_topRecommendItem_Price);
            view.setTag(viewHolder);
        }else{
           viewHolder= (ViewHolder) view.getTag();
        }
        return view;
    }
    class ViewHolder {
        ImageView imageView1;
        ImageView imageView2;
        TextView imageView1Title;
        TextView imageView2Title;
        TextView title1;
        TextView title2;
        TextView price1;
        TextView price2;

    }
}
