package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            coffeeListener = context
        } else {
            throw RuntimeException("$context must implement CoffeeListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.affogato).setOnClickListener {
            coffeeListener.onSelected(R.id.affogato)
        }
        view.findViewById<View>(R.id.americano).setOnClickListener {
            coffeeListener.onSelected(R.id.americano)
        }
        view.findViewById<View>(R.id.latte).setOnClickListener {
            coffeeListener.onSelected(R.id.latte)
        }
    }
}
