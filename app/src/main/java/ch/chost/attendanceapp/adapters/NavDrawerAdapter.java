package ch.chost.attendanceapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ch.chost.attendanceapp.R;
import ch.chost.attendanceapp.models.DrawerItem;

/**
 * Created by mtoeltl on 07.02.17.
 */

public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private int mIcons[];
    private String name;
    private int profile;
    private String email;
    private Context mContext;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_drawer_row,parent,false);
            ViewHolder vhItem = new ViewHolder(v,viewType);
            return vhItem;
        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);
            ViewHolder vhHeader = new ViewHolder(v,viewType);
            return vhHeader;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (holder.Holderid == 1) {
            holder.textView.setText(mNavTitles[position = 1]);
            holder.imageView.setImageResource(mIcons[position -1]);
        } else {
            holder.profile.setImageResource(profile);
            holder.Name.setText(name);
            holder.email.setText(email);
        }

    }

    @Override
    public int getItemCount() {
        return mNavTitles.length +1;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        int Holderid;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView email;

        public ViewHolder(View itemView,int ViewType) {
            super(itemView);

            if (ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) imageView.findViewById(R.id.rowIcon);
                Holderid = 1;
            } else {
                Name = (TextView) itemView.findViewById(R.id.name);
                email = (TextView) itemView.findViewById(R.id.email);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                Holderid = 0;
            }
        }

    }

    public int getItemViewType (int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) { return position == 0; }

    public NavDrawerAdapter (List<DrawerItem> dataList, Context context, String Name, String Email, int Profile) {
        mNavTitles = new String[dataList.size()];
        mIcons = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            mNavTitles[i] = dataList.get(i).getItemName();
            mIcons[i] = dataList.get(i).getImgResId();
        }
        mContext = context;
        name = Name;
        email = Email;
        profile = Profile;
    }
}
