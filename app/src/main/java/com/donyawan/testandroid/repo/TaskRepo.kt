package com.donyawan.testandroid.repo

import androidx.lifecycle.LiveData
import com.donyawan.testandroid.db.TaskDao
import com.donyawan.testandroid.db.TaskEntry

class TaskRepository(val taskDao: TaskDao) {

    suspend fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun update(taskEntry: TaskEntry) = taskDao.update(taskEntry)

    suspend fun deleteItem(taskEntry: TaskEntry) = taskDao.delete(taskEntry)

    suspend fun deleteAll() {
        taskDao.deleteAll()
    }

    fun getAllTask() : LiveData<List<TaskEntry>> = taskDao.getAllTask()

    fun getAllPriorityTask(): LiveData<List<TaskEntry>> = taskDao.getAllStatusTask()

    fun searchDatabase(searchQuery: String): LiveData<List<TaskEntry>> {
        return taskDao.searchDatabase(searchQuery)
    }
}