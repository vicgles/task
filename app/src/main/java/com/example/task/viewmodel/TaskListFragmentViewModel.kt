package com.example.task.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.entities.TaskEntity
import com.example.task.model.BaseModel
import com.example.task.repository.RegisterRepository

class TaskListFragmentViewModel():ViewModel(){

    private val service = RegisterRepository()
    val mTaskLists = MutableLiveData<BaseModel<MutableList<TaskEntity>>>()

    fun getListOfTasks(){
        mTaskLists.value = BaseModel(null,BaseModel.Companion.STATUS.LOADING,null)
        service.getUserTasksOnFirebase({
            mTaskLists.value = BaseModel(it,BaseModel.Companion.STATUS.SUCCESS,null)
            if(it.isEmpty()){
                mTaskLists.value = BaseModel(it,BaseModel.Companion.STATUS.SUCCESS,"EMPTY_TASKS")
            }
            val a = 1
        },{
            mTaskLists.value = BaseModel(null,BaseModel.Companion.STATUS.ERROR,it)
        })
    }
}