package com.navigationdrawerproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NavListItemAdapter extends BaseAdapter {
	
	private String item[];
	private Context context;
	private LayoutInflater inflater;
	
	public NavListItemAdapter(String item[], Context context){
		this.item = item;
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.length;
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return item[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View rowView = convertView;
		
		if(rowView == null){
			rowView = inflater.inflate(R.layout.nav_list_item_layout, null);
			ViewHolder holder = new ViewHolder();
			holder.tvListItem = (TextView) rowView.findViewById(R.id.tvListItem);
			rowView.setTag(holder);
		}
		ViewHolder newHolder = (ViewHolder) rowView.getTag();
		newHolder.tvListItem.setText(getItem(position));
		return rowView;
	}
	
	private class ViewHolder{
		TextView tvListItem;
	}

}
