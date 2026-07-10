#include <jni.h>
/* Header for class model_MotorOrdenacao */

#ifndef _Included_model_MotorOrdenacao
#define _Included_model_MotorOrdenacao
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     model_MotorOrdenacao
 * Method:    init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_model_MotorOrdenacao_init
  (JNIEnv *, jobject);

/*
 * Class:     model_MotorOrdenacao
 * Method:    ordenar
 * Signature: ([ILjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_model_MotorOrdenacao_ordenar
  (JNIEnv *, jobject, jintArray, jstring);

/*
 * Class:     model_MotorOrdenacao
 * Method:    cleanup
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_model_MotorOrdenacao_cleanup
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif