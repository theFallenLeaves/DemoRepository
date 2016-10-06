package llm.com.liwushuo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import llm.com.liwushuo.R;
import llm.com.liwushuo.bean.Bean;

/**
 * Created by llm on 2016/10/4.
 */
public class TopRecommendAdapter extends BaseAdapter {
   private Context context=null;
    private List<Bean> list=null;
    public TopRecommendAdapter(Context context,List<Bean> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return (list.size()-1)/2;
    }

    @Override
    public Bean getItem(int i) {
        return list.get(i);
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

        Bean bean1=getItem(i*2+1);
        Bean bean2=getItem(i*2+2);
        x.image().bind(viewHolder.imageView1,bean1.getCover_image_url());
        x.image().bind(viewHolder.imageView2,bean2.getCover_image_url());
        viewHolder.imageView1Title.setText(bean1.getShort_description());
        viewHolder.imageView2Title.setText(bean2.getShort_description());
        viewHolder.title1.setText(bean1.getName());
        viewHolder.title2.setText(bean2.getName());
        viewHolder.price1.setText("￥"+bean1.getPrice());
        viewHolder.price2.setText("￥"+bean2.getPrice());




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
