package com.example.client_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.client_example.databinding.ActivityUserLayerBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.geo.Projection
import com.yandex.mapkit.geometry.geo.Projections
import com.yandex.mapkit.layers.Layer
import com.yandex.mapkit.layers.LayerOptions
import com.yandex.mapkit.map.MapType
import com.yandex.mapkit.tiles.DefaultUrlProvider
import com.yandex.mapkit.tiles.UrlProvider

class UserLayerActivity : AppCompatActivity() {
    private lateinit var urlProvider: UrlProvider
    private lateinit var resourceUrlProvider: DefaultUrlProvider
    private lateinit var projection: Projection
    private lateinit var binding: ActivityUserLayerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        MapKitFactory.setApiKey(getString(R.string.YANDEX_API_KEY))
        MapKitFactory.initialize(this)
        super.onCreate(savedInstanceState)
        binding = ActivityUserLayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        urlProvider =
            UrlProvider { tileId, version -> "https://maps-ios-pods-public.s3.yandex.net/mapkit_logo.png" }
        resourceUrlProvider = DefaultUrlProvider()
        projection = Projections.getWgs84Mercator()
        binding.mapView.map.setMapStyle(MapType.NONE.toString())
        binding.apply {

        }

    }
}