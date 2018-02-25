package com.example.st1drawermenu.NavPackage.Notices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.st1drawermenu.R;

public class NoticeSubActivity extends AppCompatActivity {

    Notice mNotice = null;

    private android.widget.TextView noticeContentTxt;
    private android.widget.ImageView logoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_sub);
        this.logoImg = (ImageView) findViewById(R.id.logoImg);
        this.noticeContentTxt = (TextView) findViewById(R.id.noticeContentTxt);


        mNotice = (Notice) getIntent().getSerializableExtra("공지");


        noticeContentTxt.setText(mNotice.getNotice());


        if (mNotice.getId() == 2)
        Glide
                .with(NoticeSubActivity.this)
                .load(mNotice.getImagUrl())
                .into(logoImg);

    }
}











