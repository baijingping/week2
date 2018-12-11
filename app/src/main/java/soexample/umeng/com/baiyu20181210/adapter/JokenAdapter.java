package soexample.umeng.com.baiyu20181210.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import soexample.umeng.com.baiyu20181210.R;
import soexample.umeng.com.baiyu20181210.bean.ShopBean;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class JokenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_ONE=0;
    public static final int TYPE_TWO=1;
    private Context context;
    private List<ShopBean.DataBean> list;

    public JokenAdapter(Context context, List<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_ONE){
            View view = View.inflate(context, R.layout.list1_item, null);
            ViewHolder1 holder1=new ViewHolder1(view);
            return holder1;
        }else {
            View view = View.inflate(context, R.layout.list2_item, null);
            ViewHolder2 holder2=new ViewHolder2(view);
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShopBean.DataBean dataBean = list.get(position);
        if (holder instanceof ViewHolder1){
               ((ViewHolder1) holder).list1Img.setImageURI(dataBean.getUser().getIcon());
               ((ViewHolder1) holder).list1Name.setText(dataBean.getUser().getNickname());
               ((ViewHolder1) holder).list1Time.setText(dataBean.getCreateTime());
           }else if (holder instanceof ViewHolder2){
               ((ViewHolder2) holder).list2Img.setImageURI(dataBean.getUser().getIcon());
               ((ViewHolder2) holder).list2Name.setText(dataBean.getUser().getNickname());
               ((ViewHolder2) holder).list2Time.setText(dataBean.getCreateTime());
            String imgUrls = dataBean.getImgUrls();
            String[] split = imgUrls.split("\\,");
            ((ViewHolder2) holder).list2Tu.setImageURI(split[0]);
        }
    }

    @Override
    public int getItemViewType(int position) {
        ShopBean.DataBean dataBean = list.get(position);
        if (dataBean.getImgUrls()==null){
            return TYPE_ONE;
        }else {
            return TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        private SimpleDraweeView list1Img;
        private TextView list1Name;
        private TextView list1Time;
        public ViewHolder1(View itemView) {
            super(itemView);
            list1Img=itemView.findViewById(R.id.list1_img);
            list1Name=itemView.findViewById(R.id.list1_name);
            list1Time=itemView.findViewById(R.id.list1_time);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder {
        private SimpleDraweeView list2Img;
        private TextView list2Name;
        private TextView list2Time;
        private SimpleDraweeView list2Tu;
        public ViewHolder2(View itemView) {
            super(itemView);
            list2Img=itemView.findViewById(R.id.list2_img);
            list2Name=itemView.findViewById(R.id.list2_name);
            list2Time=itemView.findViewById(R.id.list2_time);
            list2Tu=itemView.findViewById(R.id.list2_tu);
        }
    }
}
