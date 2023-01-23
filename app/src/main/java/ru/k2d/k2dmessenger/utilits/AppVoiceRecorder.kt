package ru.k2d.k2dmessenger.utilits

import android.media.MediaRecorder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class AppVoiceRecorder {
    companion object {

        private val mMediaRecorder = MediaRecorder()
        private lateinit var mFile: File
        private lateinit var mMessageKey: String


        fun startRecord(messageKey: String) = CoroutineScope(Dispatchers.IO).launch{
            try {
                mMessageKey = messageKey
                createFileForRecord()
                prepareMediaRecorder()
                mMediaRecorder.start()
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
        }

        private fun prepareMediaRecorder() {
            mMediaRecorder.reset()
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT)
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT)
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT)
            mMediaRecorder.setOutputFile(mFile.absolutePath)
            mMediaRecorder.prepare()
        }

        private fun createFileForRecord() {
            mFile = File(APP_ACTIVITY.filesDir, mMessageKey)
            mFile.createNewFile()

        }

        fun stopRecord(onSuccess: (file:File, messageKey:String) -> Unit) {
            try {
                mMediaRecorder.stop()
                onSuccess(mFile, mMessageKey)
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
        }

        fun releaseRecorder() {
            try {
                mMediaRecorder.release()
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
        }
    }
}