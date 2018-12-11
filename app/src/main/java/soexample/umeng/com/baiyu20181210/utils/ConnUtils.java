package soexample.umeng.com.baiyu20181210.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Shinelon on 2018/12/11.
 */

public class ConnUtils {
    public static boolean getConn(Context context) {
        //获取网络管理者
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取网路信息
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getType() == connectivityManager.TYPE_WIFI) {
            return true;
        } else {
            return false;
        }
    }

}
