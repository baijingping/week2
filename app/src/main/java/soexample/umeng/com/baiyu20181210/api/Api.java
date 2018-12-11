package soexample.umeng.com.baiyu20181210.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import soexample.umeng.com.baiyu20181210.bean.ShopBean;
import soexample.umeng.com.baiyu20181210.bean.UserBean;

/**
 * Created by Shinelon on 2018/12/10.
 */

public interface Api {
    //段子接口
    @GET("quarter/getJokes")
    Observable<ShopBean> shop(@Query("source") String source,@Query("appVersion") String appVersion,@Query("page")int page);
    //用户接口
    @GET("user/getUserInfo")
    Observable<UserBean> user(@Query("uid") String uid);
}
