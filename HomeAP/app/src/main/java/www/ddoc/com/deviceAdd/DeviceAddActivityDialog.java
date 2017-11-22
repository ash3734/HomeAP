package www.ddoc.com.deviceAdd;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
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

public class DeviceAddActivityDialog extends AppCompatActivity{

    EditText editTextName;
    EditText editTextMac;
    TextView textViewNO;
    TextView textViewOK;
    RelativeLayout relativeLayoutSmart;
    RelativeLayout relativeLayouttablet;
    RelativeLayout relativeLayoutnote;
    RelativeLayout relativeLayoutetc;
    TextView textViewSmart;
    TextView textViewtablet;
    TextView textViewnote;
    TextView textViewetc;
    String deviceType;
    NetworkService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.device_add_dialog);
        service = ApplicationController.getInstance().getNetworkService();
        editTextMac = (EditText)findViewById(R.id.device_add_mac_edit);
        editTextName = (EditText)findViewById(R.id.device_add_name_edit);
        textViewNO = (TextView)findViewById(R.id.device_add_not_btn);
        textViewOK = (TextView)findViewById(R.id.device_add_btn);
        relativeLayoutSmart = (RelativeLayout)findViewById(R.id.device_type_smart);
        relativeLayouttablet = (RelativeLayout)findViewById(R.id.device_type_tablet);
        relativeLayoutnote = (RelativeLayout)findViewById(R.id.device_type_notebook);
        relativeLayoutetc = (RelativeLayout)findViewById(R.id.device_type_etc);
        textViewSmart = (TextView)findViewById(R.id.device_type_smart_text);
        textViewtablet = (TextView)findViewById(R.id.device_type_tablet_text);
        textViewnote = (TextView)findViewById(R.id.device_type_notebook_text);
        textViewetc = (TextView)findViewById(R.id.device_type_etc_text);
        relativeLayoutSmart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayoutSmart.setBackgroundColor(Color.BLUE);
                textViewSmart.setTextColor(Color.WHITE);

                relativeLayoutnote.setBackgroundColor(Color.GRAY);
                textViewnote.setTextColor(Color.BLACK);

                relativeLayoutetc.setBackgroundColor(Color.GRAY);
                textViewetc.setTextColor(Color.BLACK);

                relativeLayouttablet.setBackgroundColor(Color.GRAY);
                textViewtablet.setTextColor(Color.BLACK);
                deviceType = "스마트폰";
            }
        });
        relativeLayoutnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayoutSmart.setBackgroundColor(Color.GRAY);
                textViewSmart.setTextColor(Color.BLACK);
                relativeLayoutnote.setBackgroundColor(Color.BLUE);
                textViewnote.setTextColor(Color.WHITE);
                relativeLayoutetc.setBackgroundColor(Color.GRAY);
                textViewetc.setTextColor(Color.BLACK);

                relativeLayouttablet.setBackgroundColor(Color.GRAY);
                textViewtablet.setTextColor(Color.BLACK);
                deviceType = "노트북";
            }
        });
        relativeLayoutetc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayoutSmart.setBackgroundColor(Color.GRAY);
                textViewSmart.setTextColor(Color.BLACK);
                relativeLayoutnote.setBackgroundColor(Color.GRAY);
                textViewnote.setTextColor(Color.BLACK);
                relativeLayoutetc.setBackgroundColor(Color.BLUE);
                textViewetc.setTextColor(Color.WHITE);

                relativeLayouttablet.setBackgroundColor(Color.GRAY);
                textViewtablet.setTextColor(Color.BLACK);
                deviceType = "기타";
            }
        });
        relativeLayouttablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayoutSmart.setBackgroundColor(Color.GRAY);
                textViewSmart.setTextColor(Color.BLACK);
                relativeLayoutnote.setBackgroundColor(Color.GRAY);
                textViewnote.setTextColor(Color.BLACK);
                relativeLayoutetc.setBackgroundColor(Color.GRAY);
                textViewetc.setTextColor(Color.BLACK);
                relativeLayouttablet.setBackgroundColor(Color.BLUE);
                textViewtablet.setTextColor(Color.WHITE);
                deviceType = "태블릿";
            }
        });
        textViewOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterData registerData = new RegisterData(editTextMac.getText().toString(),deviceType,editTextName.getText().toString(),1);
                Call<RegisterResult> registerResultCall = service.getDeviceReg(registerData);
                registerResultCall.enqueue(new Callback<RegisterResult>() {
                    @Override
                    public void onResponse(Call<RegisterResult> call, Response<RegisterResult> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getApplication(),"완료되었습니다.",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), response.body().message,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResult> call, Throwable t) {
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
