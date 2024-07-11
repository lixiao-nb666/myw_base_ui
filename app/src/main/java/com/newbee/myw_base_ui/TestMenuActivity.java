package com.newbee.myw_base_ui;

import com.newbee.myw_base_ui_lib.activity.BaseMenuActivity;
import com.newbee.myw_base_ui_lib.bean.MenuBean;

import java.util.ArrayList;
import java.util.List;

public class TestMenuActivity extends BaseMenuActivity {
    @Override
    public String getTitleStr() {
        return "142423424zheshititle";
    }

    @Override
    public List<MenuBean> getMenuList() {
        List<MenuBean> menuBeanList=new ArrayList<>();
        MenuBean bean1=new MenuBean();
        bean1.setType(1);
        bean1.setShowText("fsfds");
        MenuBean bean2=new MenuBean();
        bean2.setType(2);
        bean2.setShowText("fsdfjkls");
        menuBeanList.add(bean1);
        menuBeanList.add(bean2);
        return menuBeanList;
    }

    @Override
    public void nowSeleceNeedDo(int type) {
        showToast(type+"");
    }

    @Override
    public int getScreenW() {
        return 480;
    }
}
