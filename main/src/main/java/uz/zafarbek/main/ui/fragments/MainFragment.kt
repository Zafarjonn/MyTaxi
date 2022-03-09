package uz.zafarbek.main.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentMainBinding
import uz.zafarbek.main.ui.vm.MainViewModel

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.fragment_main), OnMapReadyCallback{

    override val viewModel: MainViewModel by viewModels()
    private val binding: FragmentMainBinding by viewBinding()
    private lateinit var mMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.layoutMain.mapLayout) {
            menu.setOnClickListener {
                binding.root.open()
            }
//            map.also {
//                it.onCreate(savedInstanceState)
//                it.onResume()
//                it.getMapAsync(this@MainFragment)
//            }
        }

//        with(binding.drawer) {
//            share.setOnClickListener {
//                requireContext().composeAll("")
//            }
//            settings.setOnClickListener {
//                navigate(MainFragmentDirections.actionMainFragmentToSettingsFragment())
//            }
//            logOut.setOnClickListener {
//                AlertDialog.Builder(requireContext()).setTitle(getString(R.string.log_out))
//                    .setMessage(getString(R.string.log_out_message))
//                    .setPositiveButton(getString(R.string.yes)) { d, w ->
////                    viewModel.logOut()
////                    val navOptions=NavOptions.Builder().setPopUpTo(R.id.bottom_profile,true).build()
////                    findNavController().navigate(R.id.loginFragment)
//                        d.dismiss()
//                    }.setNegativeButton(getString(R.string.cancel)) { d, w ->
//                        d.dismiss()
//                    }.show()
//            }
//
//            GoogleSignIn.getLastSignedInAccount(requireActivity())?.let {
//                Glide.with(requireContext()).load(it.photoUrl).into(image)
//                name.text = it.displayName
//                mail.text = it.email
//            }
//        }

    }


    override fun onMapReady(p0: GoogleMap?) {
        if (p0 != null) {
            mMap = p0
        }
        mMap.isBuildingsEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true
//        mMap.setOnMarkerClickListener(this@MainFragment)
        // Add a marker in Sydney and move the camera
        val tashkentCity = LatLng(41.310961779608746, 69.24929422660293)
//        mMap.addMarker(
//            MarkerOptions()
//                .position(tashkentCity)
//                .title("Marker in TashkentCity")
//        )
        val location = CameraUpdateFactory.newLatLngZoom(tashkentCity, 17.0f)
        mMap.animateCamera(location)
    }

}