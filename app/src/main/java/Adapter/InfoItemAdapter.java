package Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samet.webserviceexample4.InfoItemActivity;
import com.samet.webserviceexample4.R;

import java.util.List;

import Model.InfoItem;

public class InfoItemAdapter extends BaseAdapter {

    List<InfoItem> list;
    Context context;
    Activity activity;

    public InfoItemAdapter(List<InfoItem> list, Context context,Activity activity) {
        this.list = list;
        this.context = context;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view= LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        TextView postIdTextView,idTextView,nameTextView,emailTextView,bodyTextView;
        LinearLayout layoutList=(LinearLayout) view.findViewById(R.id.layoutList);

        postIdTextView=(TextView) view.findViewById(R.id.postIdTextView);
        idTextView=(TextView) view.findViewById(R.id.idTextView);
        nameTextView=(TextView) view.findViewById(R.id.nameTextView);
        emailTextView=(TextView) view.findViewById(R.id.emailTextView);
        bodyTextView=(TextView) view.findViewById(R.id.bodyTextView);

        postIdTextView.setText(" "+list.get(i).getPostId());
        idTextView.setText(" "+list.get(i).getId());
        nameTextView.setText(" "+list.get(i).getName());
        emailTextView.setText(" "+list.get(i).getEmail());
        bodyTextView.setText(" "+list.get(i).getBody());

        String post=""+list.get(i).getPostId();
        String id=""+list.get(i).getId();

        layoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(activity, InfoItemActivity.class);
                intent.putExtra("postId",post);
                intent.putExtra("id",id);
                activity.startActivity(intent);
            }
        });


        return view;
    }
}
