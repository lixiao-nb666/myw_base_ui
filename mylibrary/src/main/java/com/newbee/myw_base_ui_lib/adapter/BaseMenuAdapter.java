package com.newbee.myw_base_ui_lib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.newbee.myw_base_ui_lib.R;
import com.newbee.myw_base_ui_lib.bean.MenuBean;


import java.util.List;



public class BaseMenuAdapter extends RecyclerView.Adapter {
    private final String tag = getClass().getName() + ">>>>";
    private LayoutInflater layoutInflater;
    private List<MenuBean> list;
    private ItemClick itemClick;
    private float btTextSize;
    private int btBwSize;//按钮间隔
    private int btW,btH;
    private RelativeLayout.LayoutParams layoutParams;

    public BaseMenuAdapter(Context context, ItemClick itemClick,List<MenuBean> list,float btTextSize) {
        layoutInflater=LayoutInflater.from(context);
        this.itemClick=itemClick;
        this.list=list;
        this.btTextSize=btTextSize;
        this.btBwSize= (int) (btTextSize/3);
        this.btW= (int) (btBwSize*62);
        this.btH= (int) (btBwSize*10);
        layoutParams=new RelativeLayout.LayoutParams(btW,btH);
        layoutParams.topMargin=btBwSize;
        layoutParams.bottomMargin=btBwSize;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=layoutInflater.inflate(R.layout.adapter_menu, parent, false);
        ViewHodler viewHodler = new ViewHodler(itemView);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MenuBean menuBean=list.get(position);
        ViewHodler viewHodler= (ViewHodler) holder;
        viewHodler.itemBT.setText(menuBean.getShowText());
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.nowSelect(menuBean.getType());
            }
        };
        viewHodler.itemBT.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        if(null==list){
            return 0;
        }
        return list.size();
    }


    private Button lastButton;

    class ViewHodler extends RecyclerView.ViewHolder {

        private Button itemBT;

        public ViewHodler(View itemView) {
            super(itemView);
            itemBT=itemView.findViewById(R.id.bt_menu_item);
            itemBT.setTextSize(btTextSize);
            View.OnFocusChangeListener onFocusChangeListener=new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(null!=lastButton){
                        lastButton.setTextColor(getTextColor(itemView.getContext(),false));
                    }
                    if(hasFocus){
                        itemBT.setTextColor(getTextColor(itemView.getContext(),true));
                        lastButton=itemBT;
                    }else {
                        lastButton=null;
                    }
                }
            };
            itemView.setOnFocusChangeListener(onFocusChangeListener);
            itemBT.setOnFocusChangeListener(onFocusChangeListener);

            itemBT.setLayoutParams(layoutParams);
        }
    }

    private int getTextColor(Context context,boolean isSelect) {
        return context.getResources().getColor(isSelect ? R.color.text_translation_over_color : com.newbee.bulid_lib.R.color.white);
    }

    public interface ItemClick {

        public void nowSelect(int type);

    }
}