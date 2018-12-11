package soexample.umeng.com.baiyu20181210;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import soexample.umeng.com.baiyu20181210.bean.UserBean;
import soexample.umeng.com.baiyu20181210.user.presenter.UserPresenter;
import soexample.umeng.com.baiyu20181210.user.view.UserView;
import soexample.umeng.com.baiyu20181210.utils.StringUtils;

public class UserActivity extends AppCompatActivity implements UserView {

    @BindView(R.id.user_img)
    SimpleDraweeView userImg;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_niche)
    TextView userNiche;
    @BindView(R.id.user_sex)
    TextView userSex;
    @BindView(R.id.user_date)
    TextView userDate;
    private UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        presenter=new UserPresenter();
        presenter.attach(this);
        presenter.getData("71");
    }

    @Override
    public void successful(UserBean data) {
         if (data!=null){
             UserBean.DataBean data1 = data.getData();
             userImg.setImageURI(StringUtils.http2Http(data1.getIcon()));
             userName.setText(data1.getUsername());
             userNiche.setText(data1.getNickname());
             userSex.setText(data1.getGender()+"");
             userDate.setText(data1.getCreatetime());
         }
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detach();
        }
    }
}
