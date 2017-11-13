package www.ddoc.com.deviceAdd;

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

public class MAdapter extends RecyclerView.Adapter<MViewHolder>{
    ArrayList<RegisterData> datas;
    NetworkService service;

    public MAdapter(ArrayList<RegisterData> datas) {
        this.datas = datas;
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_add_list_item, parent,false);
        MViewHolder viewHolder = new MViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, final int position) {
        holder.macTextView.setText(datas.get(position).hw_addr);
        holder.typeTextView.setText(datas.get(position).type);
        holder.nameTextView.setText(datas.get(position).name);
        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service = ApplicationController.getInstance().getNetworkService();
                Call<RegisterResult> registerResultCall = service.getDelete(datas.get(position).num);
                registerResultCall.enqueue(new Callback<RegisterResult>() {
                    @Override
                    public void onResponse(Call<RegisterResult> call, Response<RegisterResult> response) {
                        if(response.isSuccessful()){
                            Log.d("delete","success");
                            datas.remove(position);
                            notifyDataSetChanged();
                        }else{
                            Log.d("delete",response.message());
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterResult> call, Throwable t) {
                        Log.d("delete","onFailure");
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return (datas != null) ? datas.size() : 0;
    }
}
