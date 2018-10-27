package com.frankchang.gesturedetector_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements
                                                        GestureDetector.OnGestureListener,
                                                        GestureDetector.OnDoubleTapListener {

    private TextView show;
    private GestureDetector detector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.tvShow);

        detector = new GestureDetector(this, this);
        detector.setOnDoubleTapListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 初始化文字欄位
        show.setText("");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 將畫面點擊事件掛載給 GestureDetector 物件處理
        detector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }

    public void clearOnClick(View view) {
        // 清空文字欄位
        show.setText("");
    }

    /* ========== OnGestureListener（滑動） =========-= */

    @Override
    public boolean onDown(MotionEvent e) {
        // 按下去
        show.append("動作：按下去\n");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // 按下去時的事件通知，通常用於向用戶提供視覺反饋
        show.append("動作：按下去時的事件通知，通常用於向用戶提供視覺反饋\n");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // 點下去放開
        show.append("動作：按下去放開\n");

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        // 按住滑動
        show.append("動作：按住滑動\n");

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // 長按
        show.append("動作：長按\n");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // 拋
        show.append("動作：拋\n");

        return false;
    }


    /* ========== OnDoubleTapListener =========-= */

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        // 點一下
        show.append("動作：點一下\n");

        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        // 點二下
        show.append("動作：點二下\n");

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        // 點二下時的事件通知
        show.append("動作：點二下時的事件通知\n");

        return false;
    }

}
