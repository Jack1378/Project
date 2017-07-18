package com.example.lenovo_pc.myproject.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo_pc.myproject.R;
import com.example.lenovo_pc.myproject.mvp.view.activity.UsersLoginActivity;

/**
 * 作者：李飞宇
 * 时间：2017/7/12 14:00
 * 功能：个人页面
 */

public class Fragment_User extends BaseFragment implements View.OnClickListener {
    private TextView Click_login;
    private TextView Shop;
    private TextView My_Tracks;
    private TextView non_payment;
    private TextView To_send_the_goods;
    private TextView wait_for_receiving;
    private TextView remain_to_be_evaluated;
    private TextView sales_return;
    private TextView prepaid_deposit;
    private TextView rechargeable_card;
    private TextView voucher;
    private TextView red_packet;
    private TextView integral;
    private TextView shipping_address;
    private TextView system_settings;
    private View view;
    private ImageView head_portrait;
    private TextView register;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setMyContentView(), container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    int setMyContentView() {
        return R.layout.frag_user;
    }

    @Override
    void initView(View view) {
        Click_login = (TextView) view.findViewById(R.id.Click_login);
        Click_login.setOnClickListener(this);
        //店铺
        Shop = (TextView) view.findViewById(R.id.Shop);
        Shop.setOnClickListener(this);
        //我的足迹
        My_Tracks = (TextView) view.findViewById(R.id.My_Tracks);
        My_Tracks.setOnClickListener(this);
        //未付款
        non_payment = (TextView) view.findViewById(R.id.non_payment);
        non_payment.setOnClickListener(this);
        //待发货
        To_send_the_goods = (TextView) view.findViewById(R.id.To_send_the_goods);
        To_send_the_goods.setOnClickListener(this);
        //待收货
        wait_for_receiving = (TextView) view.findViewById(R.id.wait_for_receiving);
        wait_for_receiving.setOnClickListener(this);
        //待评价
        remain_to_be_evaluated = (TextView) view.findViewById(R.id.remain_to_be_evaluated);
        remain_to_be_evaluated.setOnClickListener(this);
        //退货/款
        sales_return = (TextView) view.findViewById(R.id.sales_return);
        sales_return.setOnClickListener(this);
        //预存款
        prepaid_deposit = (TextView) view.findViewById(R.id.prepaid_deposit);
        prepaid_deposit.setOnClickListener(this);
        //充值卡
        rechargeable_card = (TextView) view.findViewById(R.id.rechargeable_card);
        rechargeable_card.setOnClickListener(this);
        //代金券
        voucher = (TextView) view.findViewById(R.id.voucher);
        voucher.setOnClickListener(this);
        //红包
        red_packet = (TextView) view.findViewById(R.id.red_packet);
        red_packet.setOnClickListener(this);
        //积分
        integral = (TextView) view.findViewById(R.id.integral);
        integral.setOnClickListener(this);
        //收货地址
        shipping_address = (TextView) view.findViewById(R.id.shipping_address);
        shipping_address.setOnClickListener(this);
        //系统设置
        system_settings = (TextView) view.findViewById(R.id.system_settings);
        system_settings.setOnClickListener(this);
        //头像
        head_portrait = (ImageView) view.findViewById(R.id.head_portrait);
        head_portrait.setOnClickListener(this);
        //点击登录
        register = (TextView) view.findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    void initData() {

    }


    @Override
    public void onClick(View view) {
        if (register.getText().equals("点击登录")) {
            switch (view.getId()) {
                case R.id.head_portrait:
                    onSkip();
                    break;
                case R.id.register:
                    onSkip();
                    break;
                case R.id.Click_login:
                    onSkip();
                    break;
                case R.id.Shop:
                    onSkip();
                    break;
                case R.id.My_Tracks:
                    onSkip();
                    break;
                case R.id.non_payment:
                    onSkip();
                    break;
                case R.id.To_send_the_goods:
                    onSkip();
                    break;
                case R.id.wait_for_receiving:
                    onSkip();
                    break;
                case R.id.remain_to_be_evaluated:
                    onSkip();
                    break;
                case R.id.sales_return:
                    onSkip();
                    break;
                case R.id.prepaid_deposit:
                    onSkip();
                    break;
                case R.id.rechargeable_card:
                    onSkip();
                    break;
                case R.id.voucher:
                    onSkip();
                    break;
                case R.id.red_packet:
                    onSkip();
                    break;
                case R.id.integral:
                    onSkip();
                    break;
                case R.id.shipping_address:
                    onSkip();
                    break;
                case R.id.system_settings:
                    onSkip();
                    break;
            }
        }
    }

    @Override
    void data_loading() {

    }

    /**
     * 跳转到登录页面
     */
    public void onSkip() {
        Intent intent = new Intent(getActivity(), UsersLoginActivity.class);
        startActivity(intent);
    }
}
