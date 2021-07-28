package test1.example.activitytouchtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.TextView;

import static test1.example.activitytouchtest.R.*;

public class MainActivity extends Activity {

    private TextView touchInfoText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        //タッチ情報表示テキスト
        this.touchInfoText = (TextView) findViewById(id.touch_info_text);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO 自動生成されたメソッド・スタブ

        float x = event.getX();                    //タッチしたＸ座標
        float y = event.getY();                //タッチしたＹ座標
        float size = event.getSize();            //押された画面領域サイズ
        float press = event.getPressure();    //画面が押された際の圧力
        int count = event.getPointerCount();    //画面タッチ数の取得
        long downTime = event.getDownTime();    //押されていた時間(ms単位)の取得
        int actionID = event.getAction();        //タッチイベントのアクション種別

        String actionKind = "";
        switch (actionID) {
            case MotionEvent.ACTION_DOWN:
                //タッチされた
                actionKind += "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_UP:
                //タッチが離れた
                actionKind += "ACTION_UP";
                break;
            case MotionEvent.ACTION_MOVE:
                //タッチしたまま動いた
                actionKind += "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_CANCEL:
                //タッチがキャンセルされた
                actionKind += "ACTION_CANCEL";
                break;
            default:
                //ほかの操作
                actionKind += "default";
                break;
        }

        String message = String.format(
                "x=%s y=%s size=%s press=%s count=%s downTime=%s action=%s"
                , String.valueOf(x)
                , String.valueOf(y)
                , String.valueOf(size)
                , String.valueOf(press)
                , String.valueOf(count)
                , String.valueOf(downTime)
                , actionKind);

        //画面に表示
        this.touchInfoText.setText(message);
        return super.onTouchEvent(event);
    }
}
