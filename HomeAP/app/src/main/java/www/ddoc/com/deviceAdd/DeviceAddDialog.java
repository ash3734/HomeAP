package www.ddoc.com.deviceAdd;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.ddoc.com.R;

/**
 * Created by ash on 2017-07-13.
 */

public class DeviceAddDialog extends Dialog
{
    @Bind(R.id.device_add_name_edit)
    EditText editTextName;
    @Bind(R.id.device_add_mac_edit)
    EditText editTextMac;
    @Bind(R.id.device_add_btn)
    TextView textViewDeviceAdd;
    String deviceType;

    private View.OnClickListener mRegisterClickListener;

    public DeviceAddDialog(Context context, View.OnClickListener singleListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mRegisterClickListener = singleListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_add_dialog);
        ButterKnife.bind(this);
        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);


        // 클릭 이벤트 셋팅
        if (mRegisterClickListener != null) {
            textViewDeviceAdd.setOnClickListener(mRegisterClickListener);
        }

    }
    RadioButton.OnClickListener optionOnClickListener
            = new RadioButton.OnClickListener() {

        public void onClick(View v) {

        }
    };

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public EditText getEditTextName() {
        return editTextName;
    }

    public void setEditTextName(EditText editTextName) {
        this.editTextName = editTextName;
    }

    public EditText getEditTextMac() {
        return editTextMac;
    }

    public void setEditTextMac(EditText editTextMac) {
        this.editTextMac = editTextMac;
    }
}

