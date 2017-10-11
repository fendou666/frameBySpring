/**
 * Copyright www.hoomsun.com ���Ͻ�����Ϣ�����Ϻ������޹�˾
 */
package com.study.spring.aop;
import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;

/**
 * ���ߣ�Administrator <br>
 * ����ʱ�䣺2017��10��10�� <br>
 * ������
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD}) 
@Documented  
public @interface BussAnnotation {  
    //ģ����  
    String moduleName() default "";  
    //��������  
    String option() default "";  
}