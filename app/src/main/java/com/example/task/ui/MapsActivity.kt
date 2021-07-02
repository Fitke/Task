package com.example.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task.R
import com.example.task.api.entities.Point
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.task.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var latLngList: MutableList<LatLng> = mutableListOf()
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val featurePointsList = this.intent.extras?.getParcelableArrayList<Point>("points")!!
        for (point in featurePointsList){
            val newPoint = LatLng(point.latitude, point.longitude)
            latLngList.add(newPoint)
            val markerOptions = MarkerOptions().position(newPoint).title(point.accuracy.toString())
            when {
                point.accuracy < 1.5 -> {
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                }
                point.accuracy < 2f -> {
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                }
                else -> {
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                }
            }
            mMap.addMarker(markerOptions)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(newPoint))
        }
        mMap.addPolygon(PolygonOptions().addAll(latLngList))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17f))
    }
}