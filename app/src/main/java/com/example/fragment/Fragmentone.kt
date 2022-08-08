package com.example.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color.red
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [first_fragmentt.newInstance] factory method to
 * create an instance of this fragment.
 */
class first_fragmentt : Fragment(), FragmentInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var fragmentActivity: MainActivity
    lateinit var initView: View
    lateinit var tv: TextView
    lateinit var linearlayout: LinearLayout
    lateinit var fragmentInterface: FragmentInterface


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentActivity=activity as MainActivity
        fragmentActivity.fragmentInterface= this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        initView= inflater.inflate(R.layout.fragmentone, container, false)
        tv=initView.findViewById(R.id.tv)
        linearlayout=initView.findViewById(R.id.linearlayout)
        return initView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment first_fragmentt.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            first_fragmentt().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun fragmentInterface(color:Int) {
        tv.setText("CHANGING COLOR ${fragmentActivity.i} times")
        when(color){
            0->{
                linearlayout.setBackgroundResource(R.color.blue)
            }
            1->{
                linearlayout.setBackgroundResource(R.color.purple_200)
            }
            2->{
                linearlayout.setBackgroundResource(R.color.brown)
            }
        }

    }
}


