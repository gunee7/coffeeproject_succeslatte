package com.example.st1drawermenu.NavPackage.Notices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.st1drawermenu.R;

import java.util.List;

/**
 * Created by Administrator on 2018-02-09.
 */

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private List<Notice> noticeList;
    private LayoutInflater inf;


    public NoticeListAdapter(Context context, List<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
        this.inf = LayoutInflater.from(context);
    }

    @Override

    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int i) {
        return noticeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            v = inf.inflate(R.layout.notice , null);
        }
        TextView noticeText = (TextView) v.findViewById(R.id.noticeText);
        TextView nameText   = (TextView) v.findViewById(R.id.nameText);
        TextView dateText   = (TextView) v.findViewById(R.id.dateText);

        noticeText.setText(noticeList.get(i).getNotice());
        nameText.setText(noticeList.get(i).getName());
        dateText.setText(noticeList.get(i).getDate());

        v.setTag(noticeList.get(i).getNotice());
        return v;
    }
}
