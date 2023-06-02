package quran.com.base

import androidx.lifecycle.MutableLiveData

open class BaseViewModel<N> {

    var navigator: N? = null
    val showLoading = MutableLiveData<Boolean>()
    val messageLiveData = MutableLiveData<String>()
}
