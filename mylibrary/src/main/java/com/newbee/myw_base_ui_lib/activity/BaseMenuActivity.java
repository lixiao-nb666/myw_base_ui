package com.newbee.myw_base_ui_lib.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.newbee.bulid_lib.mybase.activity.BaseCompatActivity;
import com.newbee.bulid_lib.util.SelectViewUtil;
import com.newbee.myw_base_ui_lib.R;
import com.newbee.myw_base_ui_lib.adapter.BaseMenuAdapter;
import com.newbee.myw_base_ui_lib.bean.MenuBean;
import com.newbee.myw_base_ui_lib.key.event.ActivityKeyDownListUtil;
import com.newbee.myw_base_ui_lib.key.event.KeyCodesEventType;
import com.newbee.system_key_lib.systemkey.SystemKeyEvent;
import com.newbee.system_key_lib.systemkey.SystemKeyEventListen;

import java.util.List;

public abstract class BaseMenuActivity extends BaseCompatActivity {

    public abstract String getTitleStr();
    public abstract List<MenuBean> getMenuList();
    public abstract void nowSeleceNeedDo(int type);
    public abstract int getScreenW();

    private TextView titleTV;
    private RecyclerView rv;
    private BaseMenuAdapter adapter;
    private BaseMenuAdapter.ItemClick itemClick=new BaseMenuAdapter.ItemClick() {
        @Override
        public void nowSelect(int type) {
            nowSeleceNeedDo(type);
        }
    };
    private SelectViewUtil selectViewUtil;

    @Override
    public int getViewLayoutRsId() {
        return R.layout.activity_menu;
    }

    @Override
    public void initView() {
        titleTV=findViewById(R.id.tv_title);
        rv=findViewById(R.id.rv);
    }

    public float getTitleTextSize(){
        return getScreenW()/15;
    }

    public float getButtomTextSize(){
        return getScreenW()/22;
    }

    @Override
    public void initData() {
        titleTV.setText(getTitleStr());
        titleTV.setTextSize(getTitleTextSize());
        titleTV.setVisibility(View.VISIBLE);
        adapter=new BaseMenuAdapter(getBaseContext(),itemClick,getMenuList(),getButtomTextSize());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getBaseContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

//        selectViewUtil = new SelectViewUtil(tag + ":set_share_index", addLangBT, delectBT, checkVersionBT);
//        selectViewUtil.recoveryView(0);
//        setTextColor();
//        keyEventUtil.setListen(keyEventListen);
//        keyEventUtil.setKeyCodesToDoEvent(KeyCodesEventType.BACK.ordinal(), ActivityKeyDownListUtil.back());
//        keyEventUtil.setKeyCodesToDoEvent(KeyCodesEventType.QUE.ordinal(), ActivityKeyDownListUtil.queOk1());
//        keyEventUtil.setKeyCodesToDoEvent(KeyCodesEventType.QUE.ordinal(), ActivityKeyDownListUtil.queOk2());
//        keyEventUtil.setKeyCodesToDoEvent(KeyCodesEventType.TOP.ordinal(), ActivityKeyDownListUtil.toTopList());
//        keyEventUtil.setKeyCodesToDoEvent(KeyCodesEventType.DOWN.ordinal(), ActivityKeyDownListUtil.toDownList());
//        keyEventUtil.setKeyCodesToDoEvent(KeyCodesEventType.LEFT.ordinal(), ActivityKeyDownListUtil.toLeftList());
//        keyEventUtil.setKeyCodesToDoEvent(KeyCodesEventType.RIGHT.ordinal(), ActivityKeyDownListUtil.toRightList());

    }

    @Override
    public void initControl() {

//        addLangBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectViewUtil.setSelectViewByIndex(SetToType.ADD_LANG.ordinal());
//                setTextColor();
//                queToDo(SetToType.ADD_LANG);
//            }
//        });
//        delectBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectViewUtil.setSelectViewByIndex(SetToType.DELECT_LANG.ordinal());
//                setTextColor();
//                queToDo(SetToType.DELECT_LANG);
//            }
//        });
//        checkVersionBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectViewUtil.setSelectViewByIndex(SetToType.CHECK_VERSION.ordinal());
//                setTextColor();
//                queToDo(SetToType.CHECK_VERSION);
//            }
//        });
    }


//    private void queToDo(SetToType setToType) {
//
//        switch (setToType) {
//            case ADD_LANG:
//
//                toActivity(AddLangActivity.class);
//                break;
//            case DELECT_LANG:
//                if (YdLangUtil.getInstance().getShowLangCountMap().size() < 5) {
//                    showToast("numb < 5");
//                } else {
//                    toActivity(DelectLangActivity.class);
//                }
//                break;
//            case CHECK_VERSION:
//                showToast("New Version  !");
//                break;
//        }
//    }

    @Override
    public void closeActivity() {
        keyEventUtil.close();
    }

    @Override
    public void viewIsShow() {
        keyEventUtil.start();
    }

    @Override
    public void viewIsPause() {
        keyEventUtil.pause();
    }

    @Override
    public void changeConfig() {

    }

    private void setTextColor() {
//        addLangBT.setTextColor(getTextColor(addLangBT.isSelected()));
//        delectBT.setTextColor(getTextColor(delectBT.isSelected()));
//        checkVersionBT.setTextColor(getTextColor(checkVersionBT.isSelected()));
    }

//    private int getTextColor(boolean isSelect) {
//        return getResources().getColor(isSelect ? R.color.text_translation_over_color : R.color.white1);
//    }


    private SystemKeyEvent keyEventUtil = new SystemKeyEvent();
    private SystemKeyEventListen keyEventListen = new SystemKeyEventListen() {
        @Override
        public void nowCanDoEvent(int eventTypeInt) {
//
//            KeyCodesEventType eventType = KeyCodesEventType.values()[eventTypeInt];
//            switch (eventType) {
//                case NONE:
//                    break;
//                case LEFT:
//                case TOP:
//                    selectViewUtil.toLast();
//                    setTextColor();
//                    break;
//                case RIGHT:
//                case DOWN:
//                    selectViewUtil.toNext();
//                    setTextColor();
//                    break;
//                case BACK:
//                    finish();
//                    toActivity(NrmywYdTranslationActivity.class);
//                    break;
//                case QUE:
//                    int needQueIndex = selectViewUtil.getIndex();
//                    if (needQueIndex >= 0 && needQueIndex < SetToType.values().length) {
//                        queToDo(SetToType.values()[needQueIndex]);
//                    }
//                    break;
//            }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyEventUtil.nowClickKeyCode(event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 截获按键事件.发给ScanGunKeyEventHelper
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (keyEventUtil.nowClickKeyCode(event)) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

}
