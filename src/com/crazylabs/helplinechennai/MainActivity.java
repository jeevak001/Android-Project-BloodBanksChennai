package com.crazylabs.helplinechennai;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends ActionBarActivity {

	// Oncreate Method Created when MainActivity is called
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final GoogleMap mapView = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		mapView.setMyLocationEnabled(true);
		Button areaButton = (Button) findViewById(R.id.areasButton);

		Button plusZoom = (Button) findViewById(R.id.plusZoomButton);
		Button minusZoom = (Button) findViewById(R.id.minusZoomButton);
		String area = null;
		LatLng location;
		LatLng chennaiView = new LatLng(13.052076, 80.251534);

		setBloodBanks();
		setHospitals();

		// OnClick Listener for the Zoom Button
		plusZoom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				GoogleMap mapView = ((MapFragment) getFragmentManager()
						.findFragmentById(R.id.map)).getMap();
				mapView.animateCamera(CameraUpdateFactory.zoomIn());

			}
		});

		// Onclick Listener for the minus button
		minusZoom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				GoogleMap mapView = ((MapFragment) getFragmentManager()
						.findFragmentById(R.id.map)).getMap();
				mapView.animateCamera(CameraUpdateFactory.zoomOut());

			}
		});

		// Checking for the condition if this is the first time whether the
		// Activity is started
		if (LocationClass.firstTime == true) {
			mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(chennaiView,
					13));
			mapView.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			LocationClass.firstTime = false;
		}

		else {

			Bundle extras = getIntent().getExtras();
			if (extras != null) {

				area = extras.getString("extras");

			}

			// Getting value from List and animating camera to corresponding
			// locations
			for (int i = 0; i < LocationClass.location.length; i++) {

				if (LocationClass.location[i].equals(area) == true) {

					location = new LatLng(LocationClass.latitude[i],
							LocationClass.longitude[i]);
					mapView.setMapType(LocationClass.mapType);
					mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(
							location, 14));

				}
			}
		}

		// OnClickListener for the Areas Button
		areaButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent areaActivity = new Intent(MainActivity.this, Areas.class);
				areaActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(areaActivity);

			}
		});

		// Enabling or Disabling Zoom Controls and GPS BuiltIN
		mapView.getUiSettings().setZoomControlsEnabled(false);
		mapView.getUiSettings().setMyLocationButtonEnabled(true);

		// Location Manager and Listener for the GPS Assisted Rendering of map
		// based on user location
		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		LocationListener locationListener = new LocationListener() {

			@Override
			public void onLocationChanged(Location location) {

				final GoogleMap mapView = ((MapFragment) getFragmentManager()
						.findFragmentById(R.id.map)).getMap();
				mapView.setMyLocationEnabled(true);
				mapView.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(
						location.getLatitude(), location.getLongitude())));

			}

			// LocationListener Inteface methods definition
			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderDisabled(String provider) {

			}

		};

		// Calling tne GPS PROVIDER to get updates on GPS feed from Android
		// System
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, locationListener);

	}

	private void setHospitals() {
		// TODO Auto-generated method stub

		GoogleMap mapView = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.036416, 80.221608))
				.title("Public Health Center")
				.snippet(
						"Public Health CentreNew #174/Old #114,Lake View Rd, West Mambalam,Chennai")
						.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {

				String phoneCallUri = "tel:044-24893101";
				phoneCall(phoneCallUri);

			}
		});

	}

	// Action Bar Menu creation
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.action_bar, menu);

		return true;

	}

	// OnClick Lister for the items in the Action Bar
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		GoogleMap mapView = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.map)).getMap();
		mapView.setMyLocationEnabled(true);

		switch (item.getItemId()) {
		case R.id.hybrid:
			mapView.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			LocationClass.mapType = GoogleMap.MAP_TYPE_HYBRID;
			return true;
		case R.id.normal:
			mapView.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			LocationClass.mapType = GoogleMap.MAP_TYPE_NORMAL;
			return true;
		case R.id.satellite:
			mapView.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			LocationClass.mapType = GoogleMap.MAP_TYPE_SATELLITE;
			return true;
		case R.id.terrain:
			mapView.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			LocationClass.mapType = GoogleMap.MAP_TYPE_TERRAIN;
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}

	}

	// Phone calling mechanism (General Method)
	private void phoneCall(String phoneNumber) {

		Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
		phoneCallIntent.setData(Uri.parse(phoneNumber));
		startActivity(phoneCallIntent);
	}

	public void setBloodBanks() {

		GoogleMap mapView = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.002140, 80.248621))
				.title("VHS Blood Bank")
				.snippet("Rajiv Gandhi IT Expy, Tharamani,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast toast = Toast.makeText(MainActivity.this, "No Number",
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.000279, 80.248567))
				.title("Rotary Center Blood Bank").snippet("Tharamani,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-22542829";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.041889, 80.179582))
				.title("Rotary Center Blood Bank")
				.snippet("No450,Arcot Road,Porur,Alwartirunagar,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-32566209";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.051478, 80.277376))
				.title("Jeevan Blood Bank")
				.snippet("18, Besant Road, Off Lloyds Road,Gopalpuram,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-28351200";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.066639, 80.259101))
				.title("Indian Red Cross Society")
				.snippet("50,Red Cross Building,Montieth Road,Egmore,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-28554548";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.070999, 80.256518))
				.title("Lions Blood Bank")
				.snippet("130, Marshalls Road, Egmore,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-28414949";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.053930, 80.240004))
				.title("AA Labs")
				.snippet(
						"OldNo 12, NewNo 23,5th CrossStreet,Nungambakkam,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-28170930";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.053930, 80.240004))
				.title("Kanchi Kamakoti Blood Bank")
				.snippet("Nageswara Rd, Nungambakkam,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast toast = Toast.makeText(MainActivity.this, "No Number",
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.079455, 80.257295))
				.title("The Landsteiner Lakshmi Blood Bank")
				.snippet("962,Periyar EVR Salai, Egmore,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:08012999900";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.081475, 80.276917))
				.title("General Hospital Blood Bank")
				.snippet("General Hospital Rd, Park Town,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast toast = Toast.makeText(MainActivity.this, "No Number",
						Toast.LENGTH_SHORT);
				toast.show();
			}

		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.061251, 80.245743))
				.title("Jeevan NIIT")
				.snippet("General Hospital Rd, Park Town,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast toast = Toast.makeText(MainActivity.this, "No Number",
						Toast.LENGTH_SHORT);
				toast.show();
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.076121, 80.237109))
				.title("Llmrf Public Blood Bank")
				.snippet("160, Poonamallee High Road, Kilpauk,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-28283096";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.085920, 80.291760))
				.title("Chennai Port Trust Blood Bank")
				.snippet("George Town,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-25362201";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.096432, 80.291609))
				.title("National Blood Bank")
				.snippet("Javer St, George Town,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-25362201";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(12.978655, 80.240282))
				.title("Haemophilia Society Madras Chapter")
				.snippet("Vhs Hospital Ttti,Tharamani,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-22541652";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(12.981399, 80.195465))
				.title("Rotary Blood Bank")
				.snippet("Medavakkam Main Rd, Vanuvampet, Madipakkam,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-22425327";
				phoneCall(phoneCallUri);
			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.010257, 80.216053)).title("Blood bank")
				.snippet("Race View Colony,Guindy,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast toast = Toast.makeText(MainActivity.this, "No Number",
						Toast.LENGTH_SHORT);
				toast.show();

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.035967, 80.134893))
				.title("Sowmiya Clinical Lab")
				.snippet("No. 44,1st Rd, Ramachamdra Nagar, Iyyappanthangal"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:09710970901";
				phoneCall(phoneCallUri);

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.118070, 80.290623))
				.title("CSI Rainy Blood Bank")
				.snippet(
						"CSI Rainy Hospital,GollavarAgraharam Rd, PanRajarathnam Nagar, Royapuram"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-25951204";
				phoneCall(phoneCallUri);

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.035111, 80.239391))
				.title("Center For Blood Disorders")
				.snippet("73/24, Habibullah Road, Vidoyadaya School,T Nagar"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-28340668";
				phoneCall(phoneCallUri);

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.031140, 80.231580))
				.title("Dhanvandri Blood Bank")
				.snippet("F-1, 52A, T.Nagar,SW Boag Rd, CIT Nagar,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-24310660";
				phoneCall(phoneCallUri);

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.109460, 80.291653))
				.title("Sree Venkateshwara Blood Bank")
				.snippet("158,Mannarswamy KovilStreet,Royapuram,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:044-25960226";
				phoneCall(phoneCallUri);

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.109460, 80.291653))
				.title("Department of Transfusion Medicine")
				.snippet("Old Washermanpet,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast toast = Toast.makeText(MainActivity.this, "No Number",
						Toast.LENGTH_SHORT);
				toast.show();

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.051174, 80.224101))
				.title("Ambigai Blood Bank")
				.snippet("5th Cross St, Kodambakkam,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				Toast toast = Toast.makeText(MainActivity.this, "No Number",
						Toast.LENGTH_SHORT);
				toast.show();

			}
		});

		mapView.addMarker(new MarkerOptions()
				.position(new LatLng(13.051174, 80.224101))
				.title("Stemcyte India Therapeutics")
				.snippet(
						"12th Main Rd, L Block, Anna Nagar, Anna Nagar West,Chennai"));
		mapView.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

			// Define the ONClick Window to make a call

			@Override
			public void onInfoWindowClick(Marker marker) {
				String phoneCallUri = "tel:18604204206";
				phoneCall(phoneCallUri);

			}
		});

	}
}
