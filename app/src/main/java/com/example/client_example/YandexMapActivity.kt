package com.example.client_example

import android.R.attr
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.client_example.databinding.ActivityYandexMapBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.CameraUpdateReason
import com.yandex.mapkit.map.IconStyle
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.map.MapObject
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.map.MapType
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.runtime.image.AnimatedImageProvider
import com.yandex.runtime.ui_view.ViewProvider
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class YandexMapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityYandexMapBinding
    private lateinit var provider: AnimatedImageProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        MapKitFactory.setApiKey(getString(R.string.YANDEX_API_KEY))
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(this)

        binding = ActivityYandexMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            provider = AnimatedImageProvider.fromAsset(applicationContext, "animation.png")
            val iconStyle = IconStyle().setScale(4f)

            val map1 = mapview.map
            map1.mapType = MapType.VECTOR_MAP

            map1.move(
                CameraPosition(
                    Point(41.311081, 69.240562), 9f, 10.0f, 30.0f
                )
            )

//            drawMyLocationMark(Point(41.311081, 69.240562), binding.mapview)

            val camerListener = CameraListener { map, cameraPosition, p2, p3 ->

            }
            mapview.mapWindow.map.addCameraListener(camerListener)

            val view = View(this@YandexMapActivity).apply {
                background = getDrawable(R.drawable.marker2)
            }

            val placemark =
                map1.mapObjects.addPlacemark(
                    Point(41.243013, 69.161422),
                    ViewProvider(view),
                    iconStyle
                )
            placemark.addTapListener(tapListener)

            /* mapview.map.move(
                 CameraPosition(
                     Point(55.751225, 37.629540), 17.0f, 150.0f,30.0f
                )
            )
            val cameraListener = object : CameraListener {
                override fun onCameraPositionChanged(
                    map: Map,
                    cameraPosition: CameraPosition,
                    cameraUpdateReason: CameraUpdateReason,
                    boolean: Boolean
                ) {

                }
            }
            mapview.map.addCameraListener(cameraListener)


            val imageProvider =
                ImageProvider.fromResource(this@YandexMapActivity, R.drawable.marker)
            val placemarkMapObject = mapview.map.mapObjects.addPlacemark().apply {
                geometry = Point(59.935493, 30.327392)
                setIcon(imageProvider)
            }

            placemarkMapObject.addTapListener(placeMarkTapListener)*/
        }
    }

    private val tapListener = object : MapObjectTapListener {
        override fun onMapObjectTap(p0: MapObject, p1: Point): Boolean {
            Toast.makeText(
                this@YandexMapActivity,
                "${p1.longitude}  ${p1.latitude}",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
    }

    /*  private fun drawMyLocationMark(point: Point, mapView: MapView) {
          val view = View(this).apply {
              background = getDrawable(R.drawable.marker2)
          }
          binding.mapview.map.mapObjects.addPlacemark(point, ViewProvider(view))
      }*/

    /*
        private val placeMarkTapListener = object : MapObjectTapListener {
            override fun onMapObjectTap(p0: MapObject, p1: Point): Boolean {
                Toast.makeText(
                    this@YandexMapActivity,
                    "Tapped the point (${p1.longitude}, ${p1.latitude})",
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }
        }
    */

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()

    }

    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        binding.mapview.onStop()
        super.onStop()
    }
}