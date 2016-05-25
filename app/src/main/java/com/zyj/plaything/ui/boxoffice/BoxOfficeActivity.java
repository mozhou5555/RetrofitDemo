package com.zyj.plaything.ui.boxoffice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zyj.plaything.Constant;
import com.zyj.plaything.R;
import com.zyj.plaything.http.BoxOfficeConnection;
import com.zyj.plaything.pojo.BoxOffice;
import com.zyj.plaything.pojo.Result;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 票房activity - retrofit2 + rxjava + okhttp3
 */
public class BoxOfficeActivity extends AppCompatActivity {
    private RecyclerView rcv;
    private BoxOfficeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_office);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("票房排行");
        toolBar.setTitleTextColor(getResources().getColor(R.color.white));
        toolBar.setNavigationIcon(R.mipmap.ic_arrow_left_white);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rcv = (RecyclerView) findViewById(R.id.box_office_rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new BoxOfficeAdapter(this);
        //获取数据
        BoxOfficeConnection.getBoxOfficeApi()
                .getBoxOfficeData(Constant.JUHE_KEY, "CN") //请求参数
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Result<List<BoxOffice>>>() {
                    @Override
                    public void onCompleted() {
                        //完成的时候会调用
                    }

                    @Override
                    public void onError(Throwable e) {
                        //网络错误的时候执行
                    }

                    @Override
                    public void onNext(Result<List<BoxOffice>> listResult) {
                        adapter.mList = listResult.getResult();
                        rcv.setAdapter(adapter);
                    }
                });
    }

}
