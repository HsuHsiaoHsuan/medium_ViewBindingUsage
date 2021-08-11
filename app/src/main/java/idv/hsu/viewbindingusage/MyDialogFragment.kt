package idv.hsu.viewbindingusage

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import idv.hsu.viewbindingusage.databinding.FragmentMyDialogBinding

private const val ARG_TEXT = "text"

class MyDialogFragment : DialogFragment() {
    private var _binding: FragmentMyDialogBinding? = null
    private val binding get() = _binding!!

    private var text: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val text = arguments?.getString(ARG_TEXT) ?: "EMPTY"
        _binding = FragmentMyDialogBinding.inflate(LayoutInflater.from(context))
        binding.textMessage.text = text
        return activity?.let {
            AlertDialog.Builder(it).apply {
                setTitle("You choose ...")
                setView(binding.root)
                setPositiveButton("OK", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        dismiss()
                    }
                })
            }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ARG_TEXT)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(text: String) =
            MyDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT, text)
                }
            }
    }
}