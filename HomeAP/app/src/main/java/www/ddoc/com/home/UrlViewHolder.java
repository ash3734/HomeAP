package www.ddoc.com.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import www.ddoc.com.R;

/**
 * Created by ash on 2017-08-29.
 */

public class UrlViewHolder extends RecyclerView.ViewHolder {
    TextView textViewUrl;
    Switch aSwitch;

    public UrlViewHolder(View itemView) {
        super(itemView);
        textViewUrl = (TextView)itemView.findViewById(R.id.url_list_name);
        aSwitch = (Switch)itemView.findViewById(R.id.url_list_block);
    }
}

