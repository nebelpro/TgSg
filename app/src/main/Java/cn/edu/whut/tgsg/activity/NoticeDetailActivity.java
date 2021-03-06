package cn.edu.whut.tgsg.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.Bind;
import cn.edu.whut.tgsg.R;
import cn.edu.whut.tgsg.base.BaseActivity;
import cn.edu.whut.tgsg.bean.Notice;
import cn.edu.whut.tgsg.common.Constant;

/**
 * 公告详情界面
 * <p/>
 * Created by xwh on 2015/12/16.
 */
public class NoticeDetailActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.web_notice)
    WebView mWebNotice;

    Notice mNotice;

    @Override
    protected String getTagName() {
        return "NoticeDetailActivity";
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_notice_detail;
    }

    @Override
    protected Context getContext() {
        return NoticeDetailActivity.this;
    }

    @Override
    protected void initData() {
        // 获取传来的Notice对象并设置toolbar
        Bundle bundle = getIntent().getExtras();
        mNotice = (Notice) bundle.getSerializable("notice");
        mToolbar.setTitle(mNotice.getTitle());
        setSupportActionBar(mToolbar);
        // 设置返回键<-
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        // 渲染公告展示界面
        initWeb();
    }

    @Override
    protected void initListener() {

    }

    /**
     * 渲染公告展示界面
     */
    private void initWeb() {
        String url = Constant.URL + "noticeInfo?id=" + mNotice.getId() + "&title=" + mNotice.getTitle();
        mWebNotice.loadUrl(url);

        WebSettings settings = mWebNotice.getSettings();
        settings.setJavaScriptEnabled(true);
    }
}
