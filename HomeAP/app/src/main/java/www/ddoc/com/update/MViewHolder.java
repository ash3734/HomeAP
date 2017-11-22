package www.ddoc.com.update;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.ddoc.com.R;

/**
 * Created by ash on 2017-07-22.
 */

public class MViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewType;
    TextView textViewURL;
    ImageView imageViewGoURL;
    TextView textViewTime;
    TextView textViewBolck;
    TextView textViewRealse;
    public MViewHolder(View itemView) {
        super(itemView);
        textViewName = (TextView)itemView.findViewById(R.id.update_name_textView);
        textViewType = (TextView)itemView.findViewById(R.id.update_type_textView);
        textViewURL = (TextView)itemView.findViewById(R.id.update_url_textView);
        imageViewGoURL = (ImageView)itemView.findViewById(R.id.update_gourl_btn);
        textViewTime = (TextView)itemView.findViewById(R.id.update_time_textView);
        textViewBolck = (TextView)itemView.findViewById(R.id.update_block_btn);
        textViewRealse = (TextView)itemView.findViewById(R.id.update_realse_btn);
    }
}
