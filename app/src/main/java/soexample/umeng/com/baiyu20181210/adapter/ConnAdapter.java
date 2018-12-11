package soexample.umeng.com.baiyu20181210.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import soexample.umeng.com.baiyu20181210.R;
import soexample.umeng.com.baiyu20181210.bean.JokesDao;

/**
 * Created by Shinelon on 2018/12/11.
 */

public class ConnAdapter extends RecyclerView.Adapter<ConnAdapter.ViewHolder> {
    private Context context;
    private List<JokesDao> list;

    public ConnAdapter(Context context, List<JokesDao> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.conn_item, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JokesDao jokesDao = list.get(position);
        String img = jokesDao.getImg();
        if (img!=null){
            holder.img.setImageURI(img);
        }
        holder.time.setText(jokesDao.getTime());
        holder.name.setText(jokesDao.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img;
        private TextView time;
        private TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.conn_img);
            time=itemView.findViewById(R.id.conn_time);
            name=itemView.findViewById(R.id.conn_name);
        }
    }
}
