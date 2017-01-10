package callback.jdjz.com.baserecycleview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tchl on 2016-12-30.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] mDataSet;
    public CustomAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView().setText(mDataSet[position]);
    }

    @Override
    public int getItemCount() {

        return mDataSet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        private Button btn;

        /*
        *1.这里item中不同的控件设置点击事件。
        *2.如何对这里的点击事件进行封装详细请看https://github.com/whtchl/Liaomei.git
        * LiaomeiListAdapter.java
        * 接口 private OnLiaomeiTouchListener mOnLiaomeiTouchListener;
        */

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Log.d("TAG", "Element " + getPosition() + " clicked.");
                }
            });
            textView = (TextView) itemView.findViewById(R.id.textView);
            btn = (Button) itemView.findViewById(R.id.btn1);
            btn.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   Log.d("TAG", "this is button");
                                               }
                                           });
        }

        public TextView getTextView() {
            return textView;
        }
    }



}
