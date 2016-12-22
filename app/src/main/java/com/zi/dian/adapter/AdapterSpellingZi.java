package com.zi.dian.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zi.dian.dao.model.HanZi;
import com.zi.dian.dao.model.SpellingZi;

import java.util.List;

import dian.zi.com.zidian.R;

/**
 * Created by wangliang on 6/28/16.
 */
public class AdapterSpellingZi extends BaseAdapter {
    private List<SpellingZi> list;
    private Context mContext;
    private IModelSpellingZi localModel;

    public AdapterSpellingZi(Context context, IModelSpellingZi model, List<SpellingZi> list) {
        mContext = context;
        localModel = model;
        this.list = list;
    }

    public void setData(List<SpellingZi> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    private int selectPosition;

    public void setPosition(int position) {
        selectPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HoldView localHoldView;
        if (convertView == null) {
            localHoldView = new HoldView();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_hanzi, null);
            localHoldView.tv_ = (TextView) convertView.findViewById(R.id.tv_hanzi);
            convertView.setTag(localHoldView);
        } else {
            localHoldView = (HoldView) convertView.getTag();
        }
        final SpellingZi hanZi = list.get(position);
        localHoldView.tv_.setText(hanZi.zi);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localModel.setOnclickListener(hanZi);
            }
        });
        if (selectPosition == position) {
            localHoldView.tv_.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
        } else {
            localHoldView.tv_.setTextColor(mContext.getResources().getColor(R.color.colorBlack));
        }
        return convertView;
    }

    class HoldView {
        TextView tv_;
    }

    public interface IModelSpellingZi {
        void setOnclickListener(SpellingZi spellingZi);
    }

}
