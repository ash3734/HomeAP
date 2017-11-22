package www.ddoc.com.setting;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ddoc.com.R;
import www.ddoc.com.application.ApplicationController;
import www.ddoc.com.network.NetworkService;

public class SetttingActivity extends AppCompatActivity {
    NetworkService service;


    @Bind(R.id.setting_chageName_text)
    TextView textViewChangeName;

    @Bind(R.id.setting_chagepw_text)
    TextView textViewChangePW;

    ChangePWDialog changePWDialog;
    ChangeNameDialog changeNameDialog;
    Context context1;
    Context context2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settting);
        ButterKnife.bind(this);
        service = ApplicationController.getInstance().getNetworkService();

        context1 = this;
        context2 = this;
        textViewChangePW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePWDialog = new ChangePWDialog(context1, chagePWListener);
                changePWDialog.show();
            }
        });
        textViewChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ash","here??");
                changeNameDialog = new ChangeNameDialog(context2, chageNameListener);
                changeNameDialog.show();
            }
        });
    }


    private View.OnClickListener chagePWListener = new View.OnClickListener() {
        public void onClick(View v) {
            //클릭시 처리 과정
            Log.d("ash",changePWDialog.getEwditTextOldPW().getText().toString());
            Log.d("ash",changePWDialog.getEditTextPW().getText().toString());
            Call<ChangePWResult> changePWResultCall=service.getChangePW(new ChangePWData(changePWDialog.getEditTextPW().getText().toString()));
            changePWResultCall.enqueue(new Callback<ChangePWResult>() {
                @Override
                public void onResponse(Call<ChangePWResult> call, Response<ChangePWResult> response) {
                    if(response.isSuccessful()){

                            Toast.makeText(getApplicationContext(),"완료되었습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), response.body().message,Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<ChangePWResult> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                }
            });



            changePWDialog.dismiss();
        }
    };
    private View.OnClickListener chageNameListener = new View.OnClickListener() {
        public void onClick(View v) {
            //클릭시 처리 과정
            Log.d("ash",changeNameDialog.getEditTextName().getText().toString());
            Log.d("ash",changeNameDialog.getEwditTextOldName().getText().toString());
            Call<ChangeNameResult> changeNameResultCall=service.getChangeName(new ChangeNameData(changeNameDialog.getEditTextName().getText().toString()));
            changeNameResultCall.enqueue(new Callback<ChangeNameResult>() {
                @Override
                public void onResponse(Call<ChangeNameResult> call, Response<ChangeNameResult> response) {
                    if(response.isSuccessful()){

                        Toast.makeText(getApplicationContext(),"완료되었습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), response.body().message,Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ChangeNameResult> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                }
            });
            changeNameDialog.dismiss();
        }
    };

}
