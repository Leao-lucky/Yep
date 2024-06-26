package com.yep.record.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.yep.record.databinding.FragmentRegisterBinding
import com.yep.record.helper.FragmentUtil
import com.yep.record.viewmodel.AccountViewModel


class RegisterFragment : Fragment() {

    private val vBinding: FragmentRegisterBinding by lazy {
        FragmentRegisterBinding.inflate(layoutInflater)
    }

    private val accountViewModel: AccountViewModel by lazy {
        ViewModelProvider(requireActivity()).get(AccountViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return vBinding.root
    }

    private fun initData() {
        vBinding.tvTips.visibility = View.GONE
        vBinding.tvSendVerify.text = resources.getString(com.yep.record.R.string.send_verify, "")
    }

    private fun initListener() {
        vBinding.tvLogin.setOnClickListener {
            accountViewModel.loginFragment.value = FragmentUtil.LOGINFRAGMENT
        }
    }

}