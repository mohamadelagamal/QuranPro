package quran.com.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel<*>> : AppCompatActivity() {
    lateinit var viewDataBinding: DB
    lateinit var viewModel: VM
    var progressDialog : ProgressDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutID())
        viewModel = makeViewModelProvider()
        subscribeToLiveData()
    }

    abstract fun makeViewModelProvider(): VM

    abstract fun getLayoutID(): Int

    lateinit var view: View
    private fun subscribeToLiveData() {
        viewModel.messageLiveData.observe(this, {
            showAlertDialog(it)
        })
        viewModel.showLoading.observe(this, {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        })
}

    private fun hideLoading() {
        progressDialog?.dismiss()
        progressDialog=null
    }

    private fun showLoading() {
        progressDialog= ProgressDialog(this)
        progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(false)
        progressDialog?.show()
    }

    private fun showAlertDialog(message: String) {
        MaterialAlertDialogBuilder(this).setMessage(message).setPositiveButton("yes")
        { dialog, which ->
            dialog.dismiss()
        }.show()
    }

    }
