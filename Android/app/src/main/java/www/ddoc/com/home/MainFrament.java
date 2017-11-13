package www.ddoc.com.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dev.sacot41.scviewpager.DotsView;
import com.dev.sacot41.scviewpager.SCViewPager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ddoc.com.R;
import www.ddoc.com.application.ApplicationController;
import www.ddoc.com.network.NetworkService;

/**
 * Created by ash on 2017-08-27.
 */

public class MainFrament extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String  mParam1;
    private String  mParam2;
    private int NUM_PAGES = 3;

    NetworkService service;
    private SCViewPager mViewPager;
    private MPagerAdapter mPageAdapter;
    private DotsView mDotsView;
    private ArrayList<MainDeviceData> homeDatas;
    private int position;
    public MainFrament() {

    }

    public static MainFrament newInstance(String param1, String param2){
        MainFrament fragment = new MainFrament();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2,param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        homeDatas = new ArrayList<MainDeviceData>();
        mDotsView.setDotRessource(R.drawable.dot_selected, R.drawable.dot_unselected);
        service = ApplicationController.getInstance().getNetworkService();
        Call<MainResult> mainResultCall = service.getMainResult();
        mainResultCall.enqueue(new Callback<MainResult>() {
            @Override
            public void onResponse(Call<MainResult> call, Response<MainResult> response) {
                if(response.isSuccessful()){
                    homeDatas = response.body().result;
                    mDotsView.setNumberOfPage(homeDatas.size());
                    mPageAdapter = new MPagerAdapter(getChildFragmentManager(),homeDatas);
                    mPageAdapter.setNumberOfPage(homeDatas.size());
                    mPageAdapter.setFragmentBackgroundColor(R.color.theme_100);
                    mViewPager.setAdapter(mPageAdapter);

                    mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        }

                        @Override
                        public void onPageSelected(int position) {
                            mDotsView.selectDot(position);
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {
                        }
                    });
                }
                else{
                    Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResult> call, Throwable t) {
                Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        homeDatas = new ArrayList<MainDeviceData>();
        service = ApplicationController.getInstance().getNetworkService();
        Call<MainResult> mainResultCall = service.getMainResult();
        mainResultCall.enqueue(new Callback<MainResult>() {
            @Override
            public void onResponse(Call<MainResult> call, Response<MainResult> response) {
                if(response.isSuccessful()){
                    homeDatas = response.body().result;
                    mPageAdapter = new MPagerAdapter(getChildFragmentManager(),homeDatas);
                    mPageAdapter.setNumberOfPage(homeDatas.size());
                    mPageAdapter.setFragmentBackgroundColor(R.color.theme_100);
                    mViewPager.setAdapter(mPageAdapter);

                    mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        }

                        @Override
                        public void onPageSelected(int position) {
                            mDotsView.selectDot(position);
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {
                        }
                    });
                }
                else{
                    Toast.makeText(getContext(), response.body().message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResult> call, Throwable t) {
                Toast.makeText(getContext(), "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.main_fragment, container, false);
        mViewPager = (SCViewPager)rootView.findViewById(R.id.viewpager_main_activity);
        mDotsView = (DotsView)rootView.findViewById(R.id.dotsview_main);
        return rootView;
    }
}
