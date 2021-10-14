package idv.hsu.viewbindingusage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import idv.hsu.viewbindingusage.databinding.ActivityMainBinding
import idv.hsu.viewbindingusage.databinding.ItemTextBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingStub: ItemTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        bindingStub = ItemTextBinding.inflate(layoutInflater, binding.root, false)
        bindingStub.root.setOnClickListener {
            // FIXME: won't work
        }
        binding.stub.setOnInflateListener { _, inflated ->
            inflated.setOnClickListener {
                // TODO
            }
        }

        binding.stub.inflate() // after set click listener
        setContentView(binding.root)
    }
}