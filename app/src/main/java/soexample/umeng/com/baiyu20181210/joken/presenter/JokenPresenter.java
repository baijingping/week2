package soexample.umeng.com.baiyu20181210.joken.presenter;

import soexample.umeng.com.baiyu20181210.bean.ShopBean;
import soexample.umeng.com.baiyu20181210.joken.model.JokenModel;
import soexample.umeng.com.baiyu20181210.joken.view.JokenView;
import soexample.umeng.com.baiyu20181210.utils.ICallBack;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class JokenPresenter {
    private JokenView jv;
    private JokenModel model;
    public void attach(JokenView jv){
        this.jv=jv;
        model=new JokenModel();
    }

    public void getData(String source,String appVersion,int page){
        model.getData(source, appVersion, page, new ICallBack() {
            @Override
            public void successful(Object o) {
                ShopBean data= (ShopBean) o;
                if (data!=null){
                    jv.successful(data);
                }
            }

            @Override
            public void failed(Exception e) {
                    jv.failed(e);
            }
        });
    }

    public void detach(){
        if (jv!=null){
            jv=null;
        }
    }
}
