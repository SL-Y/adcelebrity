package com.yundian.celebrity.networkapi.socketapi;


import com.yundian.celebrity.app.SocketAPIConstant;
import com.yundian.celebrity.bean.AliPayReturnBean;
import com.yundian.celebrity.bean.AssetDetailsBean;
import com.yundian.celebrity.bean.BankCardBean;
import com.yundian.celebrity.bean.BankInfoBean;
import com.yundian.celebrity.bean.IdentityInfoBean;
import com.yundian.celebrity.bean.MoneyDetailListBean;
import com.yundian.celebrity.bean.RequestResultBean;
import com.yundian.celebrity.bean.ResultCodeBeen;
import com.yundian.celebrity.bean.WXPayReturnEntity;
import com.yundian.celebrity.bean.WithDrawCashHistoryBean;
import com.yundian.celebrity.bean.WithDrawCashReturnBean;
import com.yundian.celebrity.listener.OnAPIListener;
import com.yundian.celebrity.networkapi.DealAPI;
import com.yundian.celebrity.networkapi.socketapi.SocketReqeust.SocketDataPacket;
import com.yundian.celebrity.utils.LogUtils;
import com.yundian.celebrity.utils.SharePrefUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yaowang on 2017/2/20.
 */

public class SocketDealAPI extends SocketBaseAPI implements DealAPI {

    @Override
    public void weixinPay(String title, double price, OnAPIListener<WXPayReturnEntity> listener) {
        LogUtils.logd("请求微信支付");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("title", title);
        map.put("price", price);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.WXPay,
                SocketAPIConstant.ReqeutType.Pay, map);
        requestEntity(socketDataPacket, WXPayReturnEntity.class, listener);
    }

    @Override
    public void moneyList(String time, int status, int count, int startPos, OnAPIListener<List<MoneyDetailListBean>> listener) {
        LogUtils.logd("请求钱包明细");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken()); //临时写死
        map.put("status", 0); //(1:处理中,2:成功,3:失败),不传则查所有状态
        map.put("count", count);
        map.put("startPos", startPos);
        map.put("time", time);  //time  不传是获取所有  1 2 3
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.MoneyDetail,
                SocketAPIConstant.ReqeutType.History, map);
        requestEntitys(socketDataPacket, "depositsinfo", MoneyDetailListBean.class, listener);
    }

    @Override
    public void identityAuthentication(String realname, String id_card, OnAPIListener<RequestResultBean> listener) {
        LogUtils.logd("实名认证--");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("realname", realname);
        map.put("id_card", id_card);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.Identity,
                SocketAPIConstant.ReqeutType.User, map);
        requestEntity(socketDataPacket, RequestResultBean.class, listener);
    }

    @Override
    public void dealPwd(String phone, String vToken, String vCode, long timestamp, int type, String pwd, OnAPIListener<RequestResultBean> listener) {
        LogUtils.logd("交易密码--");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
//        map.put("vToken", SharePrefUtil.getInstance().getToken());
        map.put("phone", phone);
        map.put("vToken", vToken);
        map.put("vCode", vCode);
        map.put("timestamp", timestamp);  //时间戳
        map.put("type", type);
        map.put("pwd", pwd);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.DealPwd,
                SocketAPIConstant.ReqeutType.User, map);
        requestEntity(socketDataPacket, RequestResultBean.class, listener);
    }

    @Override
    public void test(String title, double price, OnAPIListener<Object> listener) {
        LogUtils.logd("测试端口");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.Products,
                SocketAPIConstant.ReqeutType.Deal, map);
        requestJsonObject(socketDataPacket, listener);
    }

    @Override
    public void balance(OnAPIListener<AssetDetailsBean> listener) {
        LogUtils.logd("请求资产明细---");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.Balance,
                SocketAPIConstant.ReqeutType.User, map);
        requestEntity(socketDataPacket, AssetDetailsBean.class, listener);
    }

    @Override
    public void identity(OnAPIListener<IdentityInfoBean> listener) {
        LogUtils.loge("身份信息");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.IdentityInfo,
                SocketAPIConstant.ReqeutType.User, map);
        requestEntity(socketDataPacket, IdentityInfoBean.class, listener);
    }

    @Override
    public void nikeName(String nickname, OnAPIListener<RequestResultBean> listener) {
        LogUtils.loge("设置昵称--------");
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        map.put("nickname", nickname);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.NikeName,
                SocketAPIConstant.ReqeutType.User, map);
        requestEntity(socketDataPacket, RequestResultBean.class, listener);
    }

    @Override
    public void starMeet(String starcode, long mid, String city_name, String appoint_time, int meet_type, String comment, OnAPIListener<RequestResultBean> listener) {
        LogUtils.loge("设置开始约见--------");
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", SharePrefUtil.getInstance().getUserId());
        map.put("mid", mid);
        map.put("starcode", starcode);
        map.put("city_name", city_name);
        map.put("appoint_time", appoint_time);
        map.put("meet_type", meet_type);
        map.put("comment", comment);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.StarMeet,
                SocketAPIConstant.ReqeutType.NewInfos, map);
        requestEntity(socketDataPacket, RequestResultBean.class, listener);
    }

    @Override
    public void alipay(String title, double price, OnAPIListener<AliPayReturnBean> listener) {
        LogUtils.loge("支付宝----------");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        map.put("title", title);
        map.put("price", price);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.ALiPay,
                SocketAPIConstant.ReqeutType.Pay, map);
        requestEntity(socketDataPacket, AliPayReturnBean.class, listener);
    }

    @Override
    public void cancelPay(String rid, int payResult, OnAPIListener<Object> listener) {
        LogUtils.loge("取消支付----------");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("rid", rid);
        map.put("payResult", payResult);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.CancelPay,
                SocketAPIConstant.ReqeutType.Pay, map);
//        requestEntity(socketDataPacket,RequestResultBean.class,listener);
        requestJsonObject(socketDataPacket, listener);
    }

    @Override
    public void cashOut(double price, String withdrawPwd, OnAPIListener<WithDrawCashReturnBean> listener) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        map.put("price", price);
        map.put("withdrawPwd", withdrawPwd);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.CashOut,
                SocketAPIConstant.ReqeutType.Pay, map);
        requestEntity(socketDataPacket, WithDrawCashReturnBean.class, listener);
    }

    @Override
    public void cashList(int status, int startPos, int count, OnAPIListener<List<WithDrawCashHistoryBean>> listener) {
        LogUtils.loge("提现列表请求网络---------");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        map.put("startPos", startPos);
        map.put("count", count);
        map.put("status", status);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.CashList,
                SocketAPIConstant.ReqeutType.History, map);
        requestEntitys(socketDataPacket, "withdrawList", WithDrawCashHistoryBean.class, listener);
    }

    @Override
    public void bankCardList(OnAPIListener<BankCardBean> listener) {
        LogUtils.loge("银行卡信息");
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.BankCard,
                SocketAPIConstant.ReqeutType.Bank, map);
        requestEntity(socketDataPacket, BankCardBean.class, listener);
    }

    @Override
    public void bankCardInfo(String cardNo, OnAPIListener<BankInfoBean> listener) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        map.put("cardNo", cardNo);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.BankName,
                SocketAPIConstant.ReqeutType.Bank, map);
        requestEntity(socketDataPacket, BankInfoBean.class, listener);
    }

    @Override
    public void bindCard(String bankUsername, String account, OnAPIListener<BankInfoBean> listener) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        map.put("bankUsername", bankUsername);
        map.put("account", account);
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.BindCard,
                SocketAPIConstant.ReqeutType.Bank, map);
        requestEntity(socketDataPacket, BankInfoBean.class, listener);
    }

    @Override
    public void unBindCard(OnAPIListener<ResultCodeBeen> listener) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", SharePrefUtil.getInstance().getUserId());
        map.put("token", SharePrefUtil.getInstance().getToken());
        SocketDataPacket socketDataPacket = socketDataPacket(SocketAPIConstant.OperateCode.UnBindCard,
                SocketAPIConstant.ReqeutType.Bank, map);
        requestEntity(socketDataPacket, ResultCodeBeen.class, listener);
    }
}
