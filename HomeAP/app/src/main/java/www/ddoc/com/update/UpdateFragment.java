package www.ddoc.com.update;

import android.os.Bundle;
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

/**
 * Created by ash on 2017-11-20.
 */

public class UpdateFragment extends Fragment {

    ArrayList<UpdateData> mDatas;
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    MAdapter mAdapter;
    NetworkService service;

    @Override
    public void onStart() {
        super.onStart();
        service = ApplicationController.getInstance().getNetworkService();
        Call<UpdateResult> updateResultCall = service.getUpdateReg();
        updateResultCall.enqueue(new Callback<UpdateResult>() {
            @Override
            public void onResponse(Call<UpdateResult> call, Response<UpdateResult> response) {

                mDatas = response.body().list;
                mLayoutManager = new LinearLayoutManager(getContext());
                mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mLayoutManager);

                mAdapter = new MAdapter(getContext(),mDatas);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<UpdateResult> call, Throwable t) {
                Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.update_fragment, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.update_recyclerview);
        return rootView;
    }
}

