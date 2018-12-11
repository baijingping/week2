package soexample.umeng.com.baiyu20181210.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import soexample.umeng.com.baiyu20181210.R;
import soexample.umeng.com.baiyu20181210.adapter.ConnAdapter;
import soexample.umeng.com.baiyu20181210.adapter.JokenAdapter;
import soexample.umeng.com.baiyu20181210.bean.DaoMaster;
import soexample.umeng.com.baiyu20181210.bean.DaoSession;
import soexample.umeng.com.baiyu20181210.bean.JokesDao;
import soexample.umeng.com.baiyu20181210.bean.JokesDaoDao;
import soexample.umeng.com.baiyu20181210.bean.ShopBean;
import soexample.umeng.com.baiyu20181210.joken.presenter.JokenPresenter;
import soexample.umeng.com.baiyu20181210.joken.view.JokenView;
import soexample.umeng.com.baiyu20181210.utils.ConnUtils;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class JokesFragment extends Fragment implements JokenView{
    private static final String TAG = "JokesFragment";
    @BindView(R.id.xmain)
    XRecyclerView xmain;
    Unbinder unbinder;
    private JokenPresenter presenter;
    private List<ShopBean.DataBean> list;
    private JokenAdapter adapter;
    private boolean isFirst;
    private int count=1;
    private Handler handler=new Handler();
    private DaoSession daoSession;
    private JokesDaoDao jokesDaoDao;
    private boolean conn;
    private List<JokesDao> jokesDaoList;
    private ConnAdapter connAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jokes_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        daoSession = DaoMaster.newDevSession(getActivity(), "jokes.db");
        jokesDaoDao = daoSession.getJokesDaoDao();
        conn = ConnUtils.getConn(getActivity());
        presenter=new JokenPresenter();
        presenter.attach(this);
        initView();
        if (conn) {
            presenter.getData("android", "1", count);
        }else {
            List<JokesDao> list2 = jokesDaoDao.queryBuilder()
                    .build()
                    .list();
            jokesDaoList.clear();
            jokesDaoList.addAll(list2);
            connAdapter.notifyDataSetChanged();
        }
    }

    private void initView() {
        list=new ArrayList<>();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        xmain.setLayoutManager(layoutManager);
        if (conn) {
            adapter = new JokenAdapter(getActivity(), list);
            xmain.setAdapter(adapter);
        }else {
            connAdapter=new ConnAdapter(getActivity(),jokesDaoList);
            xmain.setAdapter(connAdapter);
        }
        xmain.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                count=1;
                presenter.getData("android","1",count);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xmain.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                count++;
                presenter.getData("android","1",count);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        xmain.loadMoreComplete();
                    }
                },2000);
            }
        });

    }


    @Override
    public void successful(ShopBean data) {
        if (conn){
        if (data!=null) {
            if (count == 1) {
                list.clear();
            }
            list.addAll(data.getData());
            adapter.notifyDataSetChanged();
            for (ShopBean.DataBean dataBean : data.getData()) {
                JokesDao jokesDao = new JokesDao(null, dataBean.getImgUrls(), dataBean.getCreateTime(), dataBean
                        .getUser().getNickname());
                jokesDaoDao.insert(jokesDao);
            }
        }
        }
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(getActivity(),""+e.getMessage(),Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
