package www.ddoc.com.deviceAdd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import www.ddoc.com.R;

/**
 * Created by ash on 2017-07-22.
 */

public class MViewHolder extends RecyclerView.ViewHolder {
    TextView nameTextView;
    TextView typeTextView;
    TextView macTextView;
    ImageView imageViewDelete;
    public MViewHolder(View itemView) {
        super(itemView);
        imageViewDelete = (ImageView)itemView.findViewById(R.id.device_delete_btn);
        nameTextView = (TextView)itemView.findViewById(R.id.add_decvice_user_textView);
        typeTextView = (TextView)itemView.findViewById(R.id.add_decvice_type_textView);
        macTextView = (TextView)itemView.findViewById(R.id.add_decvice_mac_textView);
    }
}
