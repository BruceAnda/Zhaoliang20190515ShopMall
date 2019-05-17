package cn.zhaoliang5156.zhaoliang20190515shopmall.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.zhaoliang5156.zhaoliang20190515shopmall.R;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/16 9:31 PM
 * Description: 简单的自定义搜索
 */
public class MySearchView extends LinearLayout {

    private EditText etInput;   // 输入框
    private ImageView search;   // 搜索框

    public MySearchView(Context context) {
        super(context);
    }

    /**
     * 在布局文件中使用的时候调用这个构造方法
     * @param context
     * @param attrs
     */
    public MySearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 填充布局
        inflate(context, R.layout.shop_search, this);

        // 绑定控件
        etInput = findViewById(R.id.et_input);
        search = findViewById(R.id.search_icon);

        // 给搜索图片设置点击事件
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用回调方法
                callback.onSearch(etInput.getText().toString());
            }
        });
    }

    public MySearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 定义回调对象的引用
    private SearchCallback callback;

    // 给回调对象赋值
    public void setCallback(SearchCallback callback) {
        this.callback = callback;
    }

    /**
     * 定义回调接口
     */
    public interface SearchCallback {
        void onSearch(String context);
    }
}
