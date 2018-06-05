package com.dyhdyh.ffmpeg;

import android.util.Log;

import java.io.UnsupportedEncodingException;

/**
 * @author dengyuhan
 *         created 2018/6/1 14:36
 */
public class FFmpegJNI {
    static {
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeg-jni");
    }

    public static int exec(String... command) {
        return nativeExec(command, new OnFFmpegProgressListener() {

            @Override
            public void onProgress(float progress) {
                Log.d("onProgress-------->", progress + "--->");
            }
        }, new OnFFmpegLoggerListener() {
            @Override
            public void onPrint(int level, byte[] messageByteArray) {
                try {
                    Log.d("------------>", level+" "+new String(messageByteArray,"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    private native static int nativeExec(String[] command, OnFFmpegProgressListener progressListener, OnFFmpegLoggerListener loggerListener);
}
