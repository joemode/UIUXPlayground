package com.schoenherr.uiuxplayground.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.schoenherr.uiuxplayground.R
import com.schoenherr.uiuxplayground.databinding.FragmentLoginBinding
import com.schoenherr.uiuxplayground.ui.base.BaseFragment
import com.schoenherr.uiuxplayground.utils.AnimUtils
import com.schoenherr.uiuxplayground.utils.ViewModelFactory
import javax.inject.Inject

class LoginFragment: BaseFragment() {

    @Inject internal lateinit var viewModelFactory: ViewModelFactory<LoginViewModel>
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        getViewComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        val view: View = binding.root
        viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(LoginViewModel::class.java)
        binding.viewModel = viewModel

        return view
    }

    override fun onResume() {
        super.onResume()
        startAnimationLoop()
    }

    private fun startAnimationLoop() {
        var delay: Long = 0
        AnimUtils.slideInFromTop(context!!, binding.enterText, delay)
        delay = resources.getInteger(R.integer.slide_animation_duration).toLong()
        AnimUtils.slideOutToLeft(context!!, binding.bottomSlide, delay)
        AnimUtils.slideOutToRight(context!!, binding.topSlide, delay)
        delay += delay
    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
//    }

}