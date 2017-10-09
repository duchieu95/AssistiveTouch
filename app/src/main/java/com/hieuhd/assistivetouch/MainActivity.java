package com.hieuhd.assistivetouch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int getLayoutResID() {
        return R.layout.activity_main;
    }

    private Button mShowViewButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutResID());

        initEvent();
    }
    private void initEvent() {
        initViews();

        setViews();
    }

    private void initViews() {
        mShowViewButton = (Button) findViewById(R.id.activity_main_show_touchview_button);
    }

    private void setViews() {
        mShowViewButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startAuxiliaryService(null);
            }
        });
    }

    public void startAuxiliaryService(View v) {
        startService(new Intent(this, AuxiliaryService.class));

        // new TableShowView(this).fun(); Èç¹ûÖ»ÊÇÔÚactivityÖÐÆô¶¯
        // µ±activityÅÜÈ¥ºóÌ¨µÄÊ±ºò[ÔÝÍ£Ì¬£¬»òÕßÏú»ÙÌ¬] ÎÒÃÇÉèÖÃµÄÏÔÊ¾µ½×ÀÃæµÄviewÒ²»áÏûÊ§
        // ËùÒÔÕâÀï²ÉÓÃµÄÊÇÆô¶¯Ò»¸ö·þÎñ£¬·þÎñÖÐ´´½¨ÎÒÃÇÐèÒªÏÔÊ¾µ½tableÉÏµÄview£¬²¢½«Æä×¢²áµ½windowManagerÉÏ
        finish();
    }
}
