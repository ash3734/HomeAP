package www.ddoc.com.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ddoc.com.R;
import www.ddoc.com.application.ApplicationController;
import www.ddoc.com.network.NetworkService;

/**
 * Created by ash on 2017-07-15.
 */

public class HomeFragment extends Fragment {

    ArrayList<MainDeviceData> mDatas;
    private int position;
    ImageView imageViewAddUserUrl;
    Switch switchGamble;
    Switch switchGame;
    Switch switchLearning;
    Switch switchAdult;
    NetworkService service;
    TextView textViewUser;
    TextView textViewDevice;
    RecyclerView recyclerView;
    LinearLayoutManager mLayoutManager;
    MAdapter mAdapter;


    public static HomeFragment create(ArrayList<MainDeviceData> datas, int position) {

        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putSerializable("homeDatas", datas);
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        mDatas = (ArrayList<MainDeviceData>) getArguments().getSerializable("homeDatas");
        position = getArguments().getInt("position");
        service = ApplicationController.getInstance().getNetworkService();
        switchAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 2017-08-28 num 받아서 집어 넣기
                int adult=(switchAdult.isChecked())?1:0;
                int gamble=(switchGamble.isChecked())?1:0;
                int game=(switchGame.isChecked())?1:0;
                int learning=(switchLearning.isChecked())?1:0;
                BlockData blockData = new BlockData(adult,gamble,game,learning);
                Call<BlockResult> blockResultCall = service.getBlockResult(mDatas.get(position).num,blockData);
                blockResultCall.enqueue(new Callback<BlockResult>() {
                    @Override
                    public void onResponse(Call<BlockResult> call, Response<BlockResult> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(), "완료 되었습니다.",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BlockResult> call, Throwable t) {
                        Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        switchLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adult=(switchAdult.isChecked())?1:0;
                int gamble=(switchGamble.isChecked())?1:0;
                int game=(switchGame.isChecked())?1:0;
                int learning=(switchLearning.isChecked())?1:0;
                BlockData blockData = new BlockData(adult,gamble,game,learning);
                Call<BlockResult> blockResultCall = service.getBlockResult(mDatas.get(position).num,blockData);
                blockResultCall.enqueue(new Callback<BlockResult>() {
                    @Override
                    public void onResponse(Call<BlockResult> call, Response<BlockResult> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(), "완료 되었습니다.",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BlockResult> call, Throwable t) {
                        Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        switchGamble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 2017-08-28 num 받아서 집어 넣기
                int adult=(switchAdult.isChecked())?1:0;
                int gamble=(switchGamble.isChecked())?1:0;
                int game=(switchGame.isChecked())?1:0;
                int learning=(switchLearning.isChecked())?1:0;
                BlockData blockData = new BlockData(adult,gamble,game,learning);
                Call<BlockResult> blockResultCall = service.getBlockResult(mDatas.get(position).num,blockData);
                blockResultCall.enqueue(new Callback<BlockResult>() {
                    @Override
                    public void onResponse(Call<BlockResult> call, Response<BlockResult> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(), "완료 되었습니다.",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BlockResult> call, Throwable t) {
                        Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        switchGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 2017-08-28 num 받아서 집어 넣기
                int adult=(switchAdult.isChecked())?1:0;
                int gamble=(switchGamble.isChecked())?1:0;
                int game=(switchGame.isChecked())?1:0;
                int learning=(switchLearning.isChecked())?1:0;
                BlockData blockData = new BlockData(adult,gamble,game,learning);
                Call<BlockResult> blockResultCall = service.getBlockResult(mDatas.get(position).num,blockData);
                blockResultCall.enqueue(new Callback<BlockResult>() {
                    @Override
                    public void onResponse(Call<BlockResult> call, Response<BlockResult> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getContext(), "완료 되었습니다.",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BlockResult> call, Throwable t) {
                        Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        //url 추가하기
        imageViewAddUserUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),UrlAddActivityDialog.class);
                intent.putExtra("num",String.valueOf(mDatas.get(position).num));
                startActivity(intent);
            }
        });
        textViewUser.setText(mDatas.get(position).name);
        textViewDevice.setText(mDatas.get(position).type);
        boolean flag;
        if(mDatas.get(position).gambling==1) flag=true;
        else flag =false;
        switchGamble.setChecked(flag);
        if(mDatas.get(position).game==1) flag=true;
        else flag =false;
        switchGame.setChecked(flag);
        if(mDatas.get(position).learning==1) flag=true;
        else flag =false;
        switchLearning.setChecked(flag);
        if(mDatas.get(position).adult==1) flag=true;
        else flag =false;
        switchAdult.setChecked(flag);
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MAdapter(mDatas.get(position).information);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);

        imageViewAddUserUrl = (ImageView)rootView.findViewById(R.id.home_user_define_btn);
        switchGamble = (Switch)rootView.findViewById(R.id.home_is_gamble_block);
        switchGame = (Switch)rootView.findViewById(R.id.home_is_game_block);
        switchLearning = (Switch)rootView.findViewById(R.id.home_is_learning_block);
        switchAdult = (Switch)rootView.findViewById(R.id.home_is_adult_block);
        textViewUser = (TextView)rootView.findViewById(R.id.main_textview_user);
        textViewDevice = (TextView)rootView.findViewById(R.id.main_textview_device);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.home_user_define_list);
        return rootView;
    }
}
