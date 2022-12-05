package com.example.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("Select * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("Select * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("Select * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("Select * FROM running_table ORDER BY averageSpeedInKMH DESC")
    fun getAllRunsSortedByAverageSpeed(): LiveData<List<Run>>

    @Query("Select * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    @Query("Select SUM(timeInMillis) FROM  running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("Select SUM(caloriesBurned) FROM  running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("Select SUM(distanceInMeters) FROM  running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("Select AVG(averageSpeedInKMH) FROM  running_table")
    fun getTotalAverageSpeed(): LiveData<Float>

}