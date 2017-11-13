package www.ddoc.com.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import www.ddoc.com.deviceAdd.DeviceResult;
import www.ddoc.com.deviceAdd.RegisterData;
import www.ddoc.com.deviceAdd.RegisterResult;
import www.ddoc.com.home.BlockData;
import www.ddoc.com.home.BlockResult;
import www.ddoc.com.home.MainResult;
import www.ddoc.com.home.UrlAddData;
import www.ddoc.com.home.UrlAddResult;
import www.ddoc.com.home.UrlBlockChangeResult;
import www.ddoc.com.home.UrlBlockData;
import www.ddoc.com.setting.ChangeNameData;
import www.ddoc.com.setting.ChangeNameResult;
import www.ddoc.com.setting.ChangePWData;
import www.ddoc.com.setting.ChangePWResult;

/**
 * Created by ash on 2017-02-06.
 */

public interface NetworkService {

    @POST("blocklist")
    Call<RegisterResult> getDeviceReg(@Body RegisterData registerData);

    @GET("blocklist")
    Call<DeviceResult> getDeviceData();

    @DELETE("blocklist/{num}")
    Call<RegisterResult> getDelete(@Path("num")int num);

    @PUT("ipurl/blist/{num}")
    Call<BlockResult> getBlockResult(@Path("num")int num, @Body BlockData blockData );

    @GET("mainpage")
    Call<MainResult> getMainResult();

    @POST("ipurl/{num}")
    Call<UrlAddResult> getUrlAddResult(@Path("num")int num, @Body UrlAddData urlAddData);

    @PUT("ipurl/lock/{urlnum}")
    Call<UrlBlockChangeResult> getUrlBlockResult(@Path("urlnum")int num,@Body UrlBlockData urlBlockData);

    @PUT("ipurl/unlock/{urlnum}")
    Call<UrlBlockChangeResult> getUrlUnBlockResult(@Path("urlnum")int num,@Body UrlBlockData urlBlockData);
    @POST("pw")
    Call<ChangePWResult> getChangePW(@Body ChangePWData changePWData);
    @POST("name")
    Call<ChangeNameResult> getChangeName(@Body ChangeNameData changeNameData);

    //참고용
//    // 1-6 비밀번호 수정
//    @PUT("members/pwd/{phone}")
//    Call<ModifyPasswordResult> getModifyPasswordResult(@Path("pwd") String pwd);
//
//    // 2-1 팅 생성하기
//    @POST("ting")
//    Call<MakeTingResult> getMakeTingResult(@Body MakeTingResultData makeTingResultData);

}
