package com.example.client_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.client_example.databinding.ActivitySpinnerBinding
import com.yandex.mapkit.MapKitFactory

class SpinnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("d71fbc0d-c603-4e89-96f1-53655361d3de")
        MapKitFactory.initialize(this)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val bottomSheetFragment = MySheetFragment()
            pulsatingLayout.startAnimation()


            /*
                        click.setOnClickListener {
                            bottomSheetFragment.show(supportFragmentManager, "DemoBottomSheetFragment")
                        }
            */


            /* spinner.lifecycleOwner = this@SpinnerActivity
             spinner.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
                 Toast.makeText(this@SpinnerActivity, "$newItem is Selected", Toast.LENGTH_SHORT)
                     .show()
             }
             check.setOnCheckedChangeListener { checkBox, isChecked ->
                 Toast.makeText(this@SpinnerActivity, "$isChecked", Toast.LENGTH_SHORT).show()
             }

             val text = "By signing up. you agree to the Terms of service and\n" +
                     "Privacy policy."

             SmartClickableSpan.Builder(this@SpinnerActivity)
                 .regularText("By signing up. you agree to the ")
                 .clickableText(
                     ClickableOption().setText("Terms of service")
                         .setOnClick(object : ClickableSpan() {
                             override fun onClick(p0: View) {
                                 Toast.makeText(
                                     this@SpinnerActivity,
                                     "Accepted terms",
                                     Toast.LENGTH_SHORT
                                 )
                                     .show()
                             }
                         })
                 ).regularText(" and\n").clickableText(
                     ClickableOption().setText("Privacy policy.")
                         .setOnClick(object : ClickableSpan() {
                             override fun onClick(p0: View) {
                                 Toast.makeText(
                                     this@SpinnerActivity,
                                     "Accepted policy",
                                     Toast.LENGTH_SHORT
                                 )
                                     .show()
                             }
                         })
                 )
                 .into(binding.text)


             *//*smsCodeView.onChangeListener =
                SmsConfirmationView.OnChangeListener { code, isComplete ->
                    if (isComplete) {

                    }
                }
            smsCodeView.startListeningForIncomingMessages()*//*

            splitEdittext.setOnTextInputListener(object : SplitEditText.OnTextInputListener {
                override fun onTextInputChanged(text: String, length: Int) {

                }

                override fun onTextInputCompleted(text: String) {

                }
            })*/
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapkit.onStart()
    }

    override fun onStop() {
        super.onStop()
        MapKitFactory.getInstance().onStop()
        binding.mapkit.onStop()
    }
}