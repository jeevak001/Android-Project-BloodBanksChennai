package com.crazylabs.helplinechennai;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Areas extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_areas);

		ListView myView = (ListView) findViewById(android.R.id.list);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getResources()

				.getStringArray(R.array.areas)));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		myView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent sendLocation = new Intent(Areas.this,
						MainActivity.class);
				sendLocation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

				if (position == 0) {
					sendLocation.putExtra("extras", LocationClass.location[0]);
					startActivity(sendLocation);
				}
				if (position == 1) {
					sendLocation.putExtra("extras", LocationClass.location[1]);
					startActivity(sendLocation);
				}
				if (position == 2) {
					sendLocation.putExtra("extras", LocationClass.location[2]);
					startActivity(sendLocation);
				}
				if (position == 3) {
					sendLocation.putExtra("extras", LocationClass.location[3]);
					startActivity(sendLocation);
				}
				if (position == 4) {
					sendLocation.putExtra("extras", LocationClass.location[4]);
					startActivity(sendLocation);
				}
				if (position == 5) {
					sendLocation.putExtra("extras", LocationClass.location[5]);
					startActivity(sendLocation);
				}
				if (position == 6) {
					sendLocation.putExtra("extras", LocationClass.location[6]);
					startActivity(sendLocation);
				}
				if (position == 7) {
					sendLocation.putExtra("extras", LocationClass.location[7]);
					startActivity(sendLocation);
				}
				if (position == 8) {
					sendLocation.putExtra("extras", LocationClass.location[8]);
					startActivity(sendLocation);
				}
				if (position == 9) {
					sendLocation.putExtra("extras", LocationClass.location[9]);
					startActivity(sendLocation);
				}
				if (position == 10) {
					sendLocation.putExtra("extras", LocationClass.location[10]);
					startActivity(sendLocation);
				}
				if (position == 11) {
					sendLocation.putExtra("extras", LocationClass.location[11]);
					startActivity(sendLocation);
				}
				if (position == 12) {
					sendLocation.putExtra("extras", LocationClass.location[12]);
					startActivity(sendLocation);
				}
				if (position == 13) {
					sendLocation.putExtra("extras", LocationClass.location[13]);
					startActivity(sendLocation);
				}
				if (position == 14) {
					sendLocation.putExtra("extras", LocationClass.location[14]);
					startActivity(sendLocation);
				}
				if (position == 15) {
					sendLocation.putExtra("extras", LocationClass.location[15]);
					startActivity(sendLocation);
				}
				if (position == 16) {
					sendLocation.putExtra("extras", LocationClass.location[16]);
					startActivity(sendLocation);
				}
				if (position == 17) {
					sendLocation.putExtra("extras", LocationClass.location[17]);
					startActivity(sendLocation);
				}
				if (position == 18) {
					sendLocation.putExtra("extras", LocationClass.location[18]);
					startActivity(sendLocation);
				}
				if (position == 19) {
					sendLocation.putExtra("extras", LocationClass.location[19]);
					startActivity(sendLocation);
				}
				if (position == 20) {
					sendLocation.putExtra("extras", LocationClass.location[20]);
					startActivity(sendLocation);
				}
				if (position == 21) {
					sendLocation.putExtra("extras", LocationClass.location[21]);
					startActivity(sendLocation);
				}
				if (position == 22) {
					sendLocation.putExtra("extras", LocationClass.location[22]);
					startActivity(sendLocation);
				}
				if (position == 23) {
					sendLocation.putExtra("extras", LocationClass.location[23]);
					startActivity(sendLocation);
				}
				if (position == 24) {
					sendLocation.putExtra("extras", LocationClass.location[24]);
					startActivity(sendLocation);
				}
				if (position == 25) {
					sendLocation.putExtra("extras", LocationClass.location[25]);
					startActivity(sendLocation);
				}
				if (position == 26) {
					sendLocation.putExtra("extras", LocationClass.location[26]);
					startActivity(sendLocation);
				}
				if (position == 27) {
					sendLocation.putExtra("extras", LocationClass.location[27]);
					startActivity(sendLocation);
				}
				if (position == 28) {
					sendLocation.putExtra("extras", LocationClass.location[28]);
					startActivity(sendLocation);
				}
				if (position == 29) {
					sendLocation.putExtra("extras", LocationClass.location[29]);
					startActivity(sendLocation);
				}
				if (position == 30) {
					sendLocation.putExtra("extras", LocationClass.location[30]);
					startActivity(sendLocation);
				}
				if (position == 31) {
					sendLocation.putExtra("extras", LocationClass.location[31]);
					startActivity(sendLocation);
				}
				if (position == 32) {
					sendLocation.putExtra("extras", LocationClass.location[32]);
					startActivity(sendLocation);
				}
				if (position == 33) {
					sendLocation.putExtra("extras", LocationClass.location[33]);
					startActivity(sendLocation);
				}
				if (position == 34) {
					sendLocation.putExtra("extras", LocationClass.location[34]);
					startActivity(sendLocation);
				}
				if (position == 35) {
					sendLocation.putExtra("extras", LocationClass.location[35]);
					startActivity(sendLocation);
				}
				if (position == 36) {
					sendLocation.putExtra("extras", LocationClass.location[36]);
					startActivity(sendLocation);
				}
				if (position == 37) {
					sendLocation.putExtra("extras", LocationClass.location[37]);
					startActivity(sendLocation);
				}
				if (position == 38) {
					sendLocation.putExtra("extras", LocationClass.location[38]);
					startActivity(sendLocation);
				}
				if (position == 39) {
					sendLocation.putExtra("extras", LocationClass.location[39]);
					startActivity(sendLocation);
				}
				if (position == 40) {
					sendLocation.putExtra("extras", LocationClass.location[40]);
					startActivity(sendLocation);
				}
				if (position == 41) {
					sendLocation.putExtra("extras", LocationClass.location[41]);
					startActivity(sendLocation);
				}
				if (position == 42) {
					sendLocation.putExtra("extras", LocationClass.location[42]);
					startActivity(sendLocation);
				}
				if (position == 43) {
					sendLocation.putExtra("extras", LocationClass.location[43]);
					startActivity(sendLocation);
				}
				if (position == 44) {
					sendLocation.putExtra("extras", LocationClass.location[44]);
					startActivity(sendLocation);
				}
				if (position == 45) {
					sendLocation.putExtra("extras", LocationClass.location[45]);
					startActivity(sendLocation);
				}
				if (position == 46) {
					sendLocation.putExtra("extras", LocationClass.location[46]);
					startActivity(sendLocation);
				}
				if (position == 47) {
					sendLocation.putExtra("extras", LocationClass.location[47]);
					startActivity(sendLocation);
				}
				if (position == 48) {
					sendLocation.putExtra("extras", LocationClass.location[48]);
					startActivity(sendLocation);
				}
				if (position == 49) {
					sendLocation.putExtra("extras", LocationClass.location[49]);
					startActivity(sendLocation);
				}
				if (position == 50) {
					sendLocation.putExtra("extras", LocationClass.location[50]);
					startActivity(sendLocation);
				}
				if (position == 51) {
					sendLocation.putExtra("extras", LocationClass.location[51]);
					startActivity(sendLocation);
				}
				if (position == 52) {
					sendLocation.putExtra("extras", LocationClass.location[52]);
					startActivity(sendLocation);
				}
				if (position == 53) {
					sendLocation.putExtra("extras", LocationClass.location[53]);
					startActivity(sendLocation);
				}
				if (position == 54) {
					sendLocation.putExtra("extras", LocationClass.location[54]);
					startActivity(sendLocation);
				}
				if (position == 55) {
					sendLocation.putExtra("extras", LocationClass.location[55]);
					startActivity(sendLocation);
				}
				if (position == 56) {
					sendLocation.putExtra("extras", LocationClass.location[56]);
					startActivity(sendLocation);
				}
				if (position == 57) {
					sendLocation.putExtra("extras", LocationClass.location[57]);
					startActivity(sendLocation);
				}
				if (position == 58) {
					sendLocation.putExtra("extras", LocationClass.location[58]);
					startActivity(sendLocation);
				}
				if (position == 59) {
					sendLocation.putExtra("extras", LocationClass.location[59]);
					startActivity(sendLocation);
				}
				if (position == 60) {
					sendLocation.putExtra("extras", LocationClass.location[60]);
					startActivity(sendLocation);
				}
				if (position == 61) {
					sendLocation.putExtra("extras", LocationClass.location[61]);
					startActivity(sendLocation);
				}
				if (position == 62) {
					sendLocation.putExtra("extras", LocationClass.location[62]);
					startActivity(sendLocation);
				}
				if (position == 63) {
					sendLocation.putExtra("extras", LocationClass.location[63]);
					startActivity(sendLocation);
				}
				if (position == 64) {
					sendLocation.putExtra("extras", LocationClass.location[64]);
					startActivity(sendLocation);
				}
				if (position == 65) {
					sendLocation.putExtra("extras", LocationClass.location[65]);
					startActivity(sendLocation);
				}
				if (position == 66) {
					sendLocation.putExtra("extras", LocationClass.location[66]);
					startActivity(sendLocation);
				}
				if (position == 67) {
					sendLocation.putExtra("extras", LocationClass.location[67]);
					startActivity(sendLocation);
				}
				if (position == 68) {
					sendLocation.putExtra("extras", LocationClass.location[68]);
					startActivity(sendLocation);
				}
				if (position == 69) {
					sendLocation.putExtra("extras", LocationClass.location[69]);
					startActivity(sendLocation);
				}
				if (position == 70) {
					sendLocation.putExtra("extras", LocationClass.location[70]);
					startActivity(sendLocation);
				}

			}
		});

	}
}
