package www.ddoc.com.setting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.ddoc.com.R;

/**
 * Created by ash on 2017-07-13.
 */

public class ChangePWDialog  extends Dialog
{
    @Bind(R.id.setting_ap_pw_edt)
    EditText ewditTextOldPW;
    @Bind(R.id.setting_ap_newpw_edt)
    EditText editTextPW;

    @Bind(R.id.setting_chagepw_btn)
    TextView textViewChagePW;

    private View.OnClickListener mRegisterClickListener;

    public ChangePWDialog(Context context, View.OnClickListener singleListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mRegisterClickListener = singleListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pw_dialog);
        ButterKnife.bind(this);
        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.3f;
        getWindow().setAttributes(lpWindow);


        // 클릭 이벤트 셋팅
        if (mRegisterClickListener != null) {
            textViewChagePW.setOnClickListener(mRegisterClickListener);
        }

    }

    public EditText getEwditTextOldPW() {
        return ewditTextOldPW;
    }

    public EditText getEditTextPW() {
        return editTextPW;
    }
}

