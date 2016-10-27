package com.ethanco.bindingimageviewsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ethanco.bindingimageviewsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private String[] urls = new String[]{
            "http://img3.duitang.com/uploads/item/201608/24/20160824090329_3sRNH.png",
            "http://img3.duitang.com/uploads/item/201602/23/20160223212037_ZMT2d.thumb.700_0.jpeg",
            "http://d.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=f521f5b83c87e9504242fb6825087f75/86d6277f9e2f07086b19d07bef24b899a901f2a9.jpg",
            "http://img5.duitang.com/uploads/item/201408/23/20140823133100_htiWj.thumb.224_0.gif",
            "http://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=http%3A%2F%2Fp3.gexing.com%2Ftouxiang%2F20120729%2F1627%2F5014f40e132cf_200x200_3.jpg%3Frecache%3D20131108&thumburl=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D712646431%2C1250154135%26fm%3D21%26gp%3D0.jpg"
    };

    private int currIndex = 0;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final TestBean testBean = new TestBean();
        testBean.imgUrl.set("http://img4.duitang.com/uploads/item/201601/16/20160116115247_cAvau.thumb.224_0.jpeg");
        binding.setTestbean(testBean);

        binding.btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currIndex >= urls.length) {
                    currIndex = 0;
                }
                testBean.imgUrl.set(urls[currIndex++]);
            }
        });
    }
}
