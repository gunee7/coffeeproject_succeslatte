package com.example.st1drawermenu.board;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.st1drawermenu.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterComment extends ArrayAdapter<ModelComments>{

    private final LayoutInflater mInflater;
    private List<ModelComments> mList;

    public AdapterComment(@NonNull Context context, int resource, @NonNull List<ModelComments> objects) {
        super(context, resource, objects);

        this.mInflater = LayoutInflater.from(context);
        this.mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        // 뷰와 관련된 설정.
        ViewHolder holder = null;

        if( rowView == null ){ // inflation
            rowView = mInflater.inflate(R.layout.activity_comment_custom, parent, false );

            holder = new ViewHolder();
            holder.nickname   = rowView.findViewById( R.id.nickanme );
            holder.commentno = rowView.findViewById( R.id.commentno);
            holder.regdate   = rowView.findViewById( R.id.regdate  );
            holder.memo      = rowView.findViewById( R.id.memo     );

            rowView.setTag( holder );
        }
        else {
            holder = (ViewHolder) rowView.getTag();
        }

         // 화면에 표시될 데이터 관련 설정
        ModelComments item = getItem( position );

        holder.nickname.setText( item.getEmail() + "" );
        holder.commentno.setText( item.getCommentno() + "" );
        holder.memo     .setText( item.getMemo() );
        holder.regdate  .setText( new SimpleDateFormat("yyyy-MM-dd").format(item.getRegdate() ) );

        return rowView;
    }

    private class ViewHolder {
        TextView nickname;
        TextView commentno;
        TextView regdate;
        TextView memo;
    }
}
