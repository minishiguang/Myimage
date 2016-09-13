package com.shiguang.myimage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.shiguang.myimage.MyHorizontalScrollView.CurrentImageChangeListener;
import com.shiguang.myimage.*;
import com.shiguang.myimage.MyHorizontalScrollView.OnItemClickListener;

public class MainActivity extends Activity
{

	private MyHorizontalScrollView mHorizontalScrollView;
	private HorizontalScrollViewAdapter mAdapter;
	private ImageView mImg;
	private static Context context;
	private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.dadaquan1, R.drawable.dadaquan2, R.drawable.dadaquan3,
			R.drawable.dadaquan4, R.drawable.dadaquan5, R.drawable.dadaquan6, R.drawable.dadaquan7,
			R.drawable.dadaquan8, R.drawable.dadaquan9, R.drawable.dadaquan10,R.drawable.dadaquan11, R.drawable.dadaquan12, R.drawable.dadaquan13,
			R.drawable.dadaquan16, R.drawable.dadaquan17,
			R.drawable.dadaquan18, R.drawable.dadaquan19, R.drawable.dadaquan20,R.drawable.dadaquan21, R.drawable.dadaquan22,
			R.drawable.dadaquan24, R.drawable.dadaquan25, R.drawable.dadaquan26, R.drawable.dadaquan27,
			R.drawable.dadaquan28, R.drawable.dadaquan29, R.drawable.dadaquan30,R.drawable.dadaquan31, R.drawable.dadaquan32, R.drawable.dadaquan33,
			R.drawable.dadaquan34, R.drawable.dadaquan35, R.drawable.dadaquan36, R.drawable.dadaquan37,
			R.drawable.dadaquan38, R.drawable.dadaquan39, R.drawable.dadaquan40,R.drawable.dadaquan41, R.drawable.dadaquan42, R.drawable.dadaquan43,
			R.drawable.dadaquan44, R.drawable.dadaquan45, R.drawable.dadaquan46, R.drawable.dadaquan47,
			R.drawable.dadaquan48, R.drawable.dadaquan49, R.drawable.dadaquan50,R.drawable.dadaquan51, R.drawable.dadaquan52, R.drawable.dadaquan53,
			R.drawable.dadaquan54, R.drawable.dadaquan55, R.drawable.dadaquan56, R.drawable.dadaquan57,
			R.drawable.dadaquan58, R.drawable.dadaquan59, R.drawable.dadaquan60,R.drawable.dadaquan61, R.drawable.dadaquan62, R.drawable.dadaquan63,
			R.drawable.dadaquan64, R.drawable.dadaquan65, R.drawable.dadaquan66, R.drawable.dadaquan67,
			R.drawable.dadaquan70,R.drawable.dadaquan71, R.drawable.dadaquan72, R.drawable.dadaquan73,
			R.drawable.dadaquan74, R.drawable.dadaquan75, R.drawable.dadaquan76, R.drawable.dadaquan77,
			R.drawable.dadaquan78, R.drawable.dadaquan79, R.drawable.dadaquan80,R.drawable.dadaquan81, R.drawable.dadaquan82, R.drawable.dadaquan83));

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Intent intent = new Intent();
		ComponentName com = new ComponentName(MainActivity.this, MyService.class);
		intent.setComponent(com);
		startService(intent);
		context = getApplicationContext();





		mImg = (ImageView) findViewById(R.id.id_content);
		Glide.with(this).load(R.drawable.dadaquan66).into(mImg);
		mAdapter = new HorizontalScrollViewAdapter(this, mDatas);
		mHorizontalScrollView = (MyHorizontalScrollView) findViewById(R.id.id_horizontalScrollView);
		mHorizontalScrollView.initDatas(mAdapter);
		//添加滚动回调
		mHorizontalScrollView
				.setCurrentImageChangeListener(new CurrentImageChangeListener()
				{
					@Override
					public void onCurrentImgChanged(int position,
													View viewIndicator)
					{
						Glide.with(context).load(mDatas.get(position)).into(mImg);
						//mImg.setImageResource(mDatas.get(position));
						viewIndicator.setBackgroundColor(Color
								.parseColor("#AA024DA4"));
					}
				});
		//添加点击回调
		mHorizontalScrollView.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onClick(View view, int position)
			{
				Glide.with(context).load(mDatas.get(position)).into(mImg);
				//mImg.setImageResource(mDatas.get(position));
				view.setBackgroundColor(Color.parseColor("#AA024DA4"));
			}
		});
		//设置适配器

	}
	public static Context getContextObject(){
		return context;
	}
}
