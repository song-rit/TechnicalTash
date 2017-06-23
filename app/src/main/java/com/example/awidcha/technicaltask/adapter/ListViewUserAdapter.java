package com.example.awidcha.technicaltask.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.awidcha.technicaltask.R;
import com.example.awidcha.technicaltask.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awidcha on 23/6/2560.
 */

public class ListViewUserAdapter extends BaseAdapter {

    List<UserModel> mUserModels;
    private LayoutInflater mInflater;
    private ViewHolder mViewHolder;

    public ListViewUserAdapter(Activity activity, List<UserModel> userModels) {
        this.mUserModels = new ArrayList<>(userModels);
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mUserModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_view_user, parent, false);
            mViewHolder = new ViewHolder();
            mViewHolder.fullName = (TextView) convertView.findViewById(R.id.text_view_full_name);
            mViewHolder.nickName = (TextView) convertView.findViewById(R.id.text_view_name);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.fullName.setText(mUserModels.get(position).getFullName());
        mViewHolder.nickName.setText(mUserModels.get(position).getNickName());

        return convertView;
    }

    private static class ViewHolder {
        TextView fullName;
        TextView nickName;
    }
}
