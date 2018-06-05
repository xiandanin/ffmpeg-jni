/* DO NOT EDIT THIS FILE - it is machine generated */


#include "com_dyhdyh_ffmpeg_FFmpegJNI.h"
#include <jni.h>
#include "ffmpeg.h"
#include "ffmpeg_callback.h"


JNIEXPORT jint JNICALL Java_com_dyhdyh_ffmpeg_FFmpegJNI_nativeExec
        (JNIEnv *env, jclass jcls, jobjectArray commands, jobject progressListener,
         jobject loggerListener) {
    set_log_callback(env, loggerListener);

    int argc = (*env)->GetArrayLength(env, commands);
    char *argv[argc];

    int i;
    for (i = 0; i < argc; i++) {
        jstring js = (jstring) (*env)->GetObjectArrayElement(env, commands, i);
        argv[i] = (char *) (*env)->GetStringUTFChars(env, js, 0);
    }
    return run(argc, argv);
}