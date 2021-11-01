package com.vurtnewk.play.vm

import androidx.lifecycle.*
import com.orhanobut.logger.Logger
import com.vurtnewk.play.data.KnowledgeSystemItem
import com.vurtnewk.play.data.Repository
import com.vurtnewk.play.data.ViewStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author VurtneWk
 * 2021/10/23
 */

@HiltViewModel
class KnowledgeSystemViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    private val _knowledgeSystemListData = MutableLiveData<ViewStatus<MutableList<KnowledgeSystemItem>>>()
    val knowledgeSystemListData: LiveData<ViewStatus<MutableList<KnowledgeSystemItem>>> get() = _knowledgeSystemListData

    private val _parentSelectPosition = MutableLiveData(-1)
    val parentSelectPosition: LiveData<Int> get() = _parentSelectPosition

    private val _childSelectPosition = MutableLiveData(-1)
    val childSelectPosition: LiveData<Int> = _childSelectPosition

    val knowledgeSystemChildData: LiveData<List<KnowledgeSystemItem.Children>>
        get() = Transformations.switchMap(parentSelectPosition) { position ->
            Transformations.map(knowledgeSystemListData) {
                if (it is ViewStatus.Success) {
                    it.data[position].children
                } else {
                    null
                }
            }
        }

    /**
     * 获取所有数据
     */
    fun getKnowledgeSystemList() {
        _knowledgeSystemListData.value = ViewStatus.Loading
        _parentSelectPosition.value = -1
        _childSelectPosition.value = -1
        viewModelScope.launch {
            try {
                val knowledgeSystemList = repository.getKnowledgeSystemList()
                _knowledgeSystemListData.value = ViewStatus.Success(knowledgeSystemList.data.toMutableList())
                _parentSelectPosition.value = 0
                _childSelectPosition.value = 0
            } catch (e: Exception) {

            }
        }
    }

    fun setSelectParentPosition(position: Int) {
        if (_knowledgeSystemListData.value is ViewStatus.Success) {
            val data = (_knowledgeSystemListData.value as ViewStatus.Success<MutableList<KnowledgeSystemItem>>).data
            repeat(data.size) {
                if (it == position) {
                    val copy = data[it].copy()
                    copy.selected = true
                    data[it] = copy
                } else if(it == _parentSelectPosition.value){
                    val copy = data[it].copy()
                    copy.selected = false
                    data[it] = copy
                }
            }
            val mutableListOf = mutableListOf<KnowledgeSystemItem>()
            mutableListOf.addAll(data)
            _parentSelectPosition.value = position
            _knowledgeSystemListData.value = ViewStatus.Success(mutableListOf)
        }
    }
}