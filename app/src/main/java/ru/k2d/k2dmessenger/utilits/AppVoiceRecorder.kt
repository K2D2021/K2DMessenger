package ru.k2d.k2dmessenger.utilits

import android.media.MediaRecorder
import java.io.File

class AppVoiceRecorder {
    companion object{

        private val mMediaRecorder = MediaRecorder()
        private lateinit var mFile: File



        fun startRecord(){
            createFileForRecord()
        }

        private fun createFileForRecord() {

        }

        fun stopRecord(onSuccess:() -> Unit){

        }

        fun releaseRecorder(){

        }
    }
}