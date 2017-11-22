package www.ddoc.com.update;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
 * Created by ash on 2017-07-22.
 */

public class MAdapter extends RecyclerView.Adapter<MViewHolder>{
    ArrayList<UpdateData> datas;
    NetworkService service;
    Context context;

    public MAdapter(Context context,ArrayList<UpdateData> datas) {
        this.datas = datas;
        this.context = context;
        service = ApplicationController.getInstance().getNetworkService();
    }

    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.update_list_item, parent,false);
        MViewHolder viewHolder = new MViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, final int position) {
        holder.textViewName.setText(datas.get(position).name);
        holder.textViewType.setText(datas.get(position).type);
        holder.textViewURL.setText(datas.get(position).dns);
        holder.imageViewGoURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(datas.get(position).dns);

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }
        });
        holder.textViewBolck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        holder.textViewRealse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //// TODO: 2017-11-21 차단 요청 api
                Call<UpdatePostResult> updatePostResultCall = service.getUpdatePostReg(new UpdatePostData(datas.get(position).dns,datas.get(position).mac));
                updatePostResultCall.enqueue(new Callback<UpdatePostResult>() {
                    @Override
                    public void onResponse(Call<UpdatePostResult> call, Response<UpdatePostResult> response) {
                        Toast.makeText(context, "차단 해제 완료", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<UpdatePostResult> call, Throwable t) {
                        Toast.makeText(context, "네트워크 상태를 확인해주세요", Toast.LENGTH_LONG).show();
                    }
                });
                datas.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (datas != null) ? datas.size() : 0;
    }
}
