# BindingImageView #
一个适用于DataBinding的ImageView，解决在使用DataBinding时，Uri无法实时绑定ImageView的问题。

## 添加依赖 ##
### Step 1. Add the JitPack repository to your build file ###
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

### Step 2. Add the dependency ###

	dependencies {
	    compile 'com.github.EthanCo:BindingImageView:1.0.3'
	}

## 使用 ##

新建处理类  

	public class StringHandler implements IImageHandler {

	    //进行处理
	    @Override
	    public void handle(Object obj, ImageView imageview) {
	        String value = (String) obj;
	        Context context = imageview.getContext();
			//第三方图片加载框架进行处理
	        Glide.with(context).load(value).centerCrop().crossFade().into(imageview);
	    }
	
	    //本类是否可以处理
	    @Override
	    public boolean isThis(Object obj) {
	        return obj instanceof String;
	    }
	}

在Application#onCreate()中添加  

	BindingImageFacade.init();
    //注册处理者 (可以注册多次多个，会按顺序进行执行)
    BindingImageFacade.register(new StringHandler());

在XML中使用

	<?xml version="1.0" encoding="utf-8"?>
	<layout xmlns:app="http://schemas.android.com/apk/res-auto">
	
	    <data>
	
	        <variable
	            name="testbean"
	            type="com.ethanco.bindingimageviewsample.TestBean" />
	    </data>
	
	    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent">
	
	        <com.ethanco.bindingimageview.BindingImageView
	            android:id="@+id/bindingImageView"
	            android:layout_width="200dp"
	            android:layout_height="200dp"
	            android:layout_centerHorizontal="true"
	            app:bindingSrc="@{testbean.imgUrl}" />
	    </RelativeLayout>
	</layout>


在Activity中  

	binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
	TestBean testBean = new TestBean();
    testBean.imgUrl.set("http://img4.duitang.com/uploads/item/201601/16/20160116115247_cAvau.thumb.224_0.jpeg");
    binding.setTestbean(testBean);

之后，如需修改图片，只需

	testBean.imgUrl.set("imageUrl");

即可  

## 控件 ##

### BindingImageView ###

继承自ImageView的View，一般情况下使用这个即可

### BindingCircleImageView ###

继承自CircleImageView的View，如需使用圆形图，使用这个  

### 自定义Binding ImageView ###

可继承任何自定义的ImageView，需实现IBindingImageView接口，添加  BindingImageFacade.handle(obj, this); 即可

	public class BindingCustomImageView extends CustomImageView implements IBindingImageView {

	    public void setBindingSrc(Object obj) {
	        BindingImageFacade.handle(obj, this);
	    }
	}  

	

## Glide打包解决方案 ##

如果使用Glide图片加载库，可使用 **[BindingImageView-Handler-Glide](https://github.com/EthanCo/BindingImageView-Handler-Glide)** ，进行了Glide的一条龙实现，无需再自己添加处理项(Handler)