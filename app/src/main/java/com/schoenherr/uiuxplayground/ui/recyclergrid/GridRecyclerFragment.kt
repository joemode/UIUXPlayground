package com.schoenherr.uiuxplayground.ui.recyclergrid

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.schoenherr.uiuxplayground.R
import com.schoenherr.uiuxplayground.data.Word
import com.schoenherr.uiuxplayground.databinding.FragmentGridRecyclerBinding
import com.schoenherr.uiuxplayground.ui.base.BaseFragment
import com.schoenherr.uiuxplayground.ui.recyclergrid.adapter.GridRecyclerAdapter
import javax.inject.Inject

class GridRecyclerFragment : BaseFragment(), GridRecyclerAdapter.AdapterActionCallback {

    @Inject lateinit var viewModel: GridRecyclerViewModel
    private lateinit var binding: FragmentGridRecyclerBinding

//    private val name = GridRecyclerFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewComponent().inject(this)
//        viewModel = ViewModelProviders.of(this).get(GridRecyclerViewModel::class.java)
//        viewModel = GridRecyclerViewModel(this.activity!!.application)
    }

    override
    fun onCreateView(inflater: LayoutInflater,
                     container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_grid_recycler, container, false)
        val view: View = binding.root

        binding.viewModel = viewModel

        val layoutManager = GridLayoutManager(activity, 2)
        val list: List<Word> = listOf()
        val gridAdapter = GridRecyclerAdapter(list, this)
        binding.recycler.adapter = gridAdapter
        binding.recycler.layoutManager = layoutManager

        viewModel.allWords.observe(this, Observer { newList ->
            gridAdapter.setItems(newList)
        })

        viewModel.openNewWordDialog.observe(this, Observer {
            openNewWordDialog()
        })


        viewModel.neverNull.observe(this, Observer {new ->
            Log.d(name, "neverNull has been updated to $new")
        })

        viewModel.updateLocation.observe(this, Observer { location ->
            Log.d(name, "updateLocation: ${location.location} ${location.radius} ${location.hasMarker}")
        })
        return view
    }

    override fun onAdapterClick(word: Word) {
        Toast.makeText(this.context, "Clicked ${word.word}!", Toast.LENGTH_SHORT).show()
    }

    override fun onAdapterDelete(word: Word) {
        viewModel.delete(word)
    }

    private fun openNewWordDialog() {
        val builder = AlertDialog.Builder(this.context)
//        builder.setTitle("New Item")

        val view = layoutInflater.inflate(R.layout.dialog_new_word, @Suppress null)
        val editText = view.findViewById(R.id.categoryEditText) as EditText

        builder.setTitle("New Word")
            .setView(view)
            .setPositiveButton(android.R.string.ok) {dialog, _ ->
                val newWord = editText.text
                if (newWord.isBlank()) {
                    editText.error = getString(R.string.error)
                } else {
                    viewModel.setNeverNull(newWord.toString())
                    viewModel.insert(Word(newWord.toString()))
                    dialog.dismiss()
                }
            }
            .setNegativeButton(android.R.string.cancel) {dialog, _ ->
                dialog.cancel()
            }
            .show()


    }
}