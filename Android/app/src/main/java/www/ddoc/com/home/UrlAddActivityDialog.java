package www.ddoc.com.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ddoc.com.R;
import www.ddoc.com.application.ApplicationController;
import www.ddoc.com.network.NetworkService;

/**
 * Created by ash on 2017-08-27.
 */

public class UrlAddActivityDialog extends AppCompatActivity{

    EditText editTextUrl;
    EditText editTextCon;
    TextView textViewNO;
    TextView textViewOK;
    NetworkService service;
    String num;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        num = intent.getStringExtra("num");
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_url_add_dialog);
        service = ApplicationController.getInstance().getNetworkService();
        editTextUrl = (EditText)findViewById(R.id.url_add_name_edit);
        editTextCon = (EditText)findViewById(R.id.url_add_con_edit);
        textViewNO = (TextView)findViewById(R.id.url_add_not_btn);
        textViewOK = (TextView)findViewById(R.id.url_add_btn);

        textViewOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlAddData urlAddData = new UrlAddData(editTextUrl.getText().toString(),editTextCon.getText().toString());
                Call<UrlAddResult> urlAddResultCall = service.getUrlAddResult(Integer.parseInt(num),urlAddData);
                urlAddResultCall.enqueue(new Callback<UrlAddResult>() {
                    @Override
                    public void onResponse(Call<UrlAddResult> call, Response<UrlAddResult> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getApplication(),"완료되었습니다.",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), response.body().message,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UrlAddResult> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        textViewNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
