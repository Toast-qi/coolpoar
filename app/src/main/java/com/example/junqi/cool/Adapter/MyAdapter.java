package com.example.junqi.cool.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.junqi.cool.R;
import com.example.junqi.cool.Bean.ReadTwoBean;

/**
 * Created by user on 2016/8/13.
 */
public class MyAdapter extends BaseAdapter {

    ViewHolder holder;
    private Context context;

    private ReadTwoBean bean;
    private int currentposition;


    public MyAdapter(Context context, ReadTwoBean bean, int currentposition) {
//        this.list = list1;
        this.context = context;
        this.currentposition = currentposition;
        //把数据传递过来
        this.bean = bean;
//        this.list=list2;
//        this.list=list3;

    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {


        // 如果i == 0 从第一个集合种取
        // 取的第几个数据  取决于当前viewpager的currentposition是多少
        // 也就是currentposition == 3  list1.get(currentposition)

        if (view == null) {
            view = View.inflate(context, R.layout.item_readlayout, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.read_img);
            holder.titleView = (TextView) view.findViewById(R.id.read_title);
            holder.infoView = (TextView) view.findViewById(R.id.read_info);
            holder.neirongView = (TextView) view.findViewById(R.id.neirong);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
//        News news = (News) getItem(i);

        if(i == 0){
            holder.imageView.setImageResource(R.drawable.duanpian);
            holder.titleView.setText(bean.data.essay.get(currentposition).hp_title);
            holder.infoView.setText(bean.data.essay.get(currentposition).author.get(0).user_name);
            holder.neirongView.setText(bean.data.essay.get(currentposition).guide_word);
        }else if(i == 1){
            holder.imageView.setImageResource(R.drawable.lianzia);
            holder.titleView.setText(bean.data.serial.get(currentposition).title);
            holder.infoView.setText(bean.data.serial.get(currentposition).author.user_name);
            holder.neirongView.setText(bean.data.serial.get(currentposition).excerpt);

        }else{
            holder.imageView.setImageResource(R.drawable.wenda);
            holder.titleView.setText(bean.data.question.get(currentposition).question_title);
            holder.infoView.setText(bean.data.question.get(currentposition).answer_title);
            holder.neirongView.setText(bean.data.question.get(currentposition).answer_content);
        }
//        view.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Log.e("TAG", "onClick: =====item被点击了=======llll"+i);
//                Toast.makeText(context, "=====item被点击了", Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}
