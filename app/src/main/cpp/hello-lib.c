#include <jni.h>
#include <string.h>
#include <stdio.h>

JNIEXPORT jstring JNICALL
Java_fina_com_myapplication_MainActivity_stringFromJNI_1HelloWorld(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "HelloWorld");
}

JNIEXPORT void JNICALL
Java_fina_com_myapplication_MainActivity_Writefile(JNIEnv *env, jobject instance,
                                                   jstring Filename_) {
    //java传入的字符串，转化成char指针
    const char *filename = (*env)->GetStringUTFChars(env, Filename_, 0);
    //
    FILE *file = fopen(filename, "a+");
    char data[] = "I'm lcy.";
    fwrite(data, strlen(data), 1, file);
    if (file != NULL) {
        fclose(file);
    }

    //释放指针
    (*env)->ReleaseStringUTFChars(env, Filename_, filename);
}

JNIEXPORT void JNICALL
Java_fina_com_myapplication_MainActivity_operationArray(JNIEnv *env, jobject instance,
                                                        jintArray args_) {
    jint *args = (*env)->GetIntArrayElements(env, args_, NULL);

    // TODO
    jint len = (*env)->GetArrayLength(env, args_);
    for (int i = 0; i < len; ++i) {
        ++args[i];
    }

    (*env)->ReleaseIntArrayElements(env, args_, args, 0);
}