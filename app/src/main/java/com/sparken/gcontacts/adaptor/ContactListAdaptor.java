package com.sparken.gcontacts.adaptor;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sparken.gcontacts.Contact;
import com.sparken.gcontacts.R;

public class ContactListAdaptor extends BaseAdapter {
	private LayoutInflater inflater;
	private Context context;
	private List<?> listOfElements;

	public ContactListAdaptor(Context context, List<?> listOfElements) {
		this.listOfElements = listOfElements;
		this.context = context;
		inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return listOfElements.size();
	}

	@Override
	public Object getItem(int position) {
		return listOfElements.get(position);
	}

	@Override
	public int getItemViewType(int position) {
		return position;
	}

	@Override
	public int getViewTypeCount() {
		return getCount();
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		final Contact contact = (Contact) listOfElements.get(position);
		try {
			if (convertView != null) {
				viewHolder = (ViewHolder) convertView.getTag();
			} else {
				convertView = inflater.inflate(R.layout.contact_list, parent,
						false);
				viewHolder = new ViewHolder(convertView);
				convertView.setTag(viewHolder);
			}
			viewHolder.tvEmail.setText(contact.getEmail());
			viewHolder.tvName.setText(contact.getName());
			viewHolder.tvMobileNo.setText(contact.getMobileNo());
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return convertView;
	}

	private class ViewHolder {
		private TextView tvName;
		private TextView tvMobileNo;
		private TextView tvEmail;

		public ViewHolder(View item) {
			tvName = (TextView) item.findViewById(R.id.TVContactName);
			tvMobileNo = (TextView) item.findViewById(R.id.TVMobileNo);
			tvEmail = (TextView) item.findViewById(R.id.TVEmail);
		}

	}
}
