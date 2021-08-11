package idv.hsu.viewbindingusage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import idv.hsu.viewbindingusage.databinding.FragmentListBinding
import idv.hsu.viewbindingusage.placeholder.PlaceholderContent

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val data = PlaceholderContent.ITEMS
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        with(binding.list) {
            adapter = MyItemRecyclerViewAdapter(data).apply {
                listener = object : MyItemRecyclerViewAdapter.OnItemClickListener {
                    override fun onItemClick(position: Int) {
                        MyDialogFragment.newInstance(data[position].content).show(childFragmentManager, null)
                    }
                }
            }
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}