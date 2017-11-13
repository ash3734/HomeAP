package www.ddoc.com.home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.ddoc.com.R;
import www.ddoc.com.application.ApplicationController;
import www.ddoc.com.network.NetworkService;

/**
 * Created by ash on 2017-07-22.
 */

public class MAdapter extends RecyclerView.Adapter<UrlViewHolder>{
    ArrayList<MainUrlData> datas;
    NetworkService service;

    public MAdapter(ArrayList<MainUrlData> datas) {
        this.datas = datas;
        service = ApplicationController.getInstance().getNetworkService();
    }

    @Override
    public UrlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.url_list_item, parent,false);
        UrlViewHolder viewHolder = new UrlViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final UrlViewHolder holder, final int position) {
       holder.textViewUrl.setText(datas.get(position).ip);
        if(datas.get(position).locker==1)
            holder.aSwitch.setChecked(true);
        else
            holder.aSwitch.setChecked(false);
            holder.aSwitch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(holder.aSwitch.isChecked()){
                        Call<UrlBlockChangeResult> urlBlockChangeResultCall = service.getUrlBlockResult(datas.get(position).urlnum,new UrlBlockData(1));
                        urlBlockChangeResultCall.enqueue(new Callback<UrlBlockChangeResult>() {
                            @Override
                            public void onResponse(Call<UrlBlockChangeResult> call, Response<UrlBlockChangeResult> response) {
                                if(response.isSuccessful()){
                                    Log.d("unblock","success");
                                }
                                else{
                                    Log.d("unblock","fail");
                                }
                            }

                            @Override
                            public void onFailure(Call<UrlBlockChangeResult> call, Throwable t) {
                                Log.d("unblock","fail");
                            }
                        });
                    }else{
                        Call<UrlBlockChangeResult> urlBlockChangeResultCall = service.getUrlUnBlockResult(datas.get(position).urlnum,new UrlBlockData(0));
                        urlBlockChangeResultCall.enqueue(new Callback<UrlBlockChangeResult>() {
                            @Override
                            public void onResponse(Call<UrlBlockChangeResult> call, Response<UrlBlockChangeResult> response) {
                                if(response.isSuccessful()){
                                    Log.d("block","success");
                                }
                                else{
                                    Log.d("block","fail");
                                }
                            }

                            @Override
                            public void onFailure(Call<UrlBlockChangeResult> call, Throwable t) {
                                Log.d("checked","fail");
                            }
                        });

                    }

                }
            });


    }

    @Override
    public int getItemCount() {
        return (datas != null) ? datas.size() : 0;
    }
}
