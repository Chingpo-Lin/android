package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mydemo.broadcast.NetworkReceiverActivity;
import com.example.mydemo.frag.FragmentMainActivity;
import com.example.mydemo.intent.ExplicitIntentTestActivity;
import com.example.mydemo.service.FirstService;
import com.example.mydemo.service.MyService;
import com.example.mydemo.ui.xiaomi.XiaomiAccountCenterActivity;

//注意事项：
//资源回收:在 Activity 的生命周期结束时，确保释放资源、取消网络请求、注销监听器等操作，以防止 内存泄漏。
//内存泄漏:避免在 Activity 中引用长生命周期对象，以免导致内存泄漏。使用弱引用或者在适当的生命 周期方法中释放资源。
//Context 使用:谨慎使用 Context，避免持有 Activity 的引用，以免引发内存泄漏。尽量使用 Application 的 Context。
//生命周期管理:理解 Activity 的生命周期并正确地管理资源。确保在 onPause、onStop、onDestroy 等 生命周期方法中释放资源和取消注册监听器。
//横竖屏切换:当横竖屏切换时，Activity 会销毁并重新创建。确保在这个过程中保存和恢复必要的状态 信息，以防止用户体验的中断。
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public Intent intent; // option + command + f

    private final String tag = "main activity Life Cycle";

    private final String TAG = "bind service";
    private Button intentButton1;

    private Button intentButton2;
    private Button serviceButton1;

    private MyService myService;

    private Boolean mBound;

    private final ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.LocalBinder localBinder = (MyService.LocalBinder) iBinder;
            myService = localBinder.getService();
            mBound = true;
            Log.d(TAG, "service connect");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound = false;
            Log.d(TAG, "service disconnect");
        }
    };
    private Button getServiceDataButton;
    private Button unbindServiceButton;
    private Button bindServiceButton;
    private Button broadcastButton;
    private Button fragmentButton;
    private Button xiaomiAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentButton1 = findViewById(R.id.implicit_intent_btn);
        intentButton2 = findViewById(R.id.explicit_intent_btn);
        serviceButton1 = findViewById(R.id.intent_service_btn);
        bindServiceButton = findViewById(R.id.service_bind_btn);
        unbindServiceButton = findViewById(R.id.service_unbind_btn);
        getServiceDataButton = findViewById(R.id.service_data_btn);
        broadcastButton = findViewById(R.id.broadcast_btn);
        fragmentButton = findViewById(R.id.fragment_btn);
        xiaomiAccountButton = findViewById(R.id.xiaomi_account_btn);

        intentButton1.setOnClickListener(this);
        intentButton2.setOnClickListener(this);
        serviceButton1.setOnClickListener(this);
        bindServiceButton.setOnClickListener(this);
        unbindServiceButton.setOnClickListener(this);
        getServiceDataButton.setOnClickListener(this);
        broadcastButton.setOnClickListener(this);
        fragmentButton.setOnClickListener(this);
        xiaomiAccountButton.setOnClickListener(this);


        Log.i(tag, "main activity create");

//        intent = new Intent(this, IntentTestActivity.class);
//        intent.setAction(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_TEXT, "Hello world");
//        intent.setType("text/plain");
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);

    }

    @Override
    protected void onStart() {
        Log.i(tag, "main activity start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(tag, "main activity stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(tag, "main activity destroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(tag, "main activity pause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(tag, "main activity resume");
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        Log.d(tag, "click");

        if (viewId == R.id.implicit_intent_btn) {

            intent = new Intent();
            intent.setAction("com.example.ACTION_CUSTOM");
            intent.addCategory("android.intent.category.DEFAULT");

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "找不到匹配的 Activity", Toast.LENGTH_LONG).show();
            }
        } else if (viewId == R.id.explicit_intent_btn) {
            intent = new Intent(this, ExplicitIntentTestActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.intent_service_btn) {
            intent = new Intent(this, FirstService.class);
            startService(intent);
        } else if (viewId == R.id.service_bind_btn) {
            intent = new Intent(this, MyService.class);
            bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        } else if (viewId == R.id.service_unbind_btn) {
            unbindService(mConnection);
            mBound = false;
        } else if (viewId == R.id.service_data_btn) {
            if (mBound) {
                String text = myService.getBindText();
                Log.d(TAG, "get data" + text);
                Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            }
        } else if (viewId == R.id.broadcast_btn) {
            intent = new Intent(this, NetworkReceiverActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.fragment_btn) {
            intent = new Intent(this, FragmentMainActivity.class);
            startActivity(intent);
        } else if (viewId == R.id.xiaomi_account_btn) {
            intent = new Intent(this, XiaomiAccountCenterActivity.class);
            startActivity(intent);
        }
    }
}