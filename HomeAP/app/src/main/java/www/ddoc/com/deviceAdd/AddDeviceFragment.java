package www.ddoc.com.deviceAdd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ddoc.com.R;
import www.ddoc.com.application.ApplicationController;
import www.ddoc.com.network.NetworkService;

public class AddDeviceFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String  mParam1;
    private String  mParam2;

    NetworkService service;
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    MAdapter mAdapter;
    ArrayList<RegisterData> datas = null;
    DeviceAddDialog deviceAddDialog;
    FloatingActionButton fab;

    public AddDeviceFragment() {
    }

    public static AddDeviceFragment newInstance(String param1,String param2){
        AddDeviceFragment fragment = new AddDeviceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2,param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        service = ApplicationController.getInstance().getNetworkService();
        //context = this;

        datas = new ArrayList<RegisterData>();


        Call<DeviceResult> deviceResultCall = service.getDeviceData();
        deviceResultCall.enqueue(new Callback<DeviceResult>() {
            @Override
            public void onResponse(Call<DeviceResult> call, Response<DeviceResult> response) {
                if(response.isSuccessful()){
                    datas = response.body().result;

                    mLayoutManager = new LinearLayoutManager(getContext());
                    mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(mLayoutManager);

                    mAdapter = new MAdapter(datas);
                    recyclerView.setAdapter(mAdapter);
                }
                else{
                    Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeviceResult> call, Throwable t) {
                Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
            }
        });


        fab.setBackgroundColor(Color.parseColor("#fccc5e"));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DeviceAddActivityDialog.class));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        service = ApplicationController.getInstance().getNetworkService();
        //context = this;

        datas = new ArrayList<RegisterData>();


        Call<DeviceResult> deviceResultCall = service.getDeviceData();
        deviceResultCall.enqueue(new Callback<DeviceResult>() {
            @Override
            public void onResponse(Call<DeviceResult> call, Response<DeviceResult> response) {
                if(response.isSuccessful()){
                    datas = response.body().result;

                    mLayoutManager = new LinearLayoutManager(getContext());
                    mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(mLayoutManager);

                    mAdapter = new MAdapter(datas);
                    recyclerView.setAdapter(mAdapter);
                }
                else{
                    Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeviceResult> call, Throwable t) {
                Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
            }
        });


        fab.setBackgroundColor(Color.parseColor("#fccc5e"));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),DeviceAddActivityDialog.class));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.add_device_fragment, container, false);
        fab = (FloatingActionButton) (rootView).findViewById(R.id.fab);
        recyclerView = (RecyclerView)(rootView).findViewById(R.id.addDevice_recyclerView);

        return rootView;
    }

}
