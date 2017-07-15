package com.yundian.celebrity.ui.main.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.FrameLayout;


import com.yundian.celebrity.R;
import com.yundian.celebrity.base.BaseFragment;


/**
 *粉丝互动
 */

public class FansInteractionFragment extends BaseFragment {

//    private LRecyclerView lrv;
//    private FrameLayout parentView;
//    private static int mCurrentCounter = 1;
//    private static final int REQUEST_COUNT = 10;
//    private List<MeetStarInfoBean> list = new ArrayList<>();
//    private List<MeetStarInfoBean> loadList = new ArrayList<>();
//    private LRecyclerViewAdapter lRecyclerViewAdapter;
//    private BookStarListAdapter bookStarListAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_fans_interaction;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    protected void initView() {
//        initFindById();
//        initAdapter();
//        getData(false, 0);
    }

//    private void initFindById() {
//        lrv = (LRecyclerView) rootView.findViewById(R.id.lrv);
//        parentView = (FrameLayout) rootView.findViewById(R.id.parent_view);
//    }
//
//    private void getData(final boolean isLoadMore, int start) {
//        NetworkAPIFactoryImpl.getDealAPI().meetStatus(start, REQUEST_COUNT, new OnAPIListener<MeetStarStatusBean>() {
//            @Override
//            public void onError(Throwable ex) {
//                LogUtils.logd("预约明星列表错误----------");
//                if (lrv != null) {
//                    lrv.setNoMore(true);
//                    if (!isLoadMore) {
//                        list.clear();
//                        bookStarListAdapter.clear();
//                        lrv.refreshComplete(REQUEST_COUNT);
//                        showErrorView(parentView, R.drawable.error_view_comment, "当前没有相关数据");
//                    }
//                }
//            }
//
//            @Override
//            public void onSuccess(MeetStarStatusBean bookingStarList) {
//                LogUtils.logd("预约明星列表成功----------");
//
//                if (bookingStarList == null || bookingStarList.getResult() != 1) {
//                    lrv.setNoMore(false);
//                    return;
//                }
//
//                if (isLoadMore) {
//                    closeErrorView();
//                    loadList.clear();
//                    loadList = bookingStarList.getList();
//                    loadMoreData();
//                } else {
//                    list.clear();
//                    list = bookingStarList.getList();
//                    showData();
//                }
//            }
//        });
//    }
//
//    private void initAdapter() {
//        bookStarListAdapter = new BookStarListAdapter(getActivity());
//        lRecyclerViewAdapter = new LRecyclerViewAdapter(bookStarListAdapter);
//        lrv.setAdapter(lRecyclerViewAdapter);
//        lrv.setLayoutManager(new LinearLayoutManager(getActivity()));
//        lrv.setNoMore(false);
////        DividerDecoration divider = new DividerDecoration.Builder(getActivity())
////                .setHeight(R.dimen.dp_0_5)
////                .setPadding(R.dimen.dp_25)
////                .setColorResource(R.color.color_dcdcdc)
////                .build();
////        lrv.addItemDecoration(divider);
//        lrv.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
//        lrv.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore() {
//                getData(true, mCurrentCounter + 1);
//            }
//        });
//        lrv.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getData(false, 1);
//            }
//        });
//    }
//
//
//    public void showData() {
//        if (list.size() == 0) {
//            showErrorView(parentView, R.drawable.error_view_comment, "当前没有相关数据");
//            return;
//        } else {
//            closeErrorView();
//        }
//        bookStarListAdapter.clear();
//        mCurrentCounter = list.size();
//        lRecyclerViewAdapter.notifyDataSetChanged();
//        bookStarListAdapter.addAll(list);
//        LogUtils.loge("当前刷新list:" + list.toString());
//        lrv.refreshComplete(REQUEST_COUNT);
//    }
//
//    private void loadMoreData() {
//        if (loadList == null || list.size() == 0) {
//            lrv.setNoMore(true);
//        } else {
//            list.addAll(loadList);
//            bookStarListAdapter.addAll(loadList);
//            mCurrentCounter += loadList.size();
//            lrv.refreshComplete(REQUEST_COUNT);
//        }
//    }
}
