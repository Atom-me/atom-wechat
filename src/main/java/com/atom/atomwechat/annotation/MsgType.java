package com.atom.atomwechat.annotation;

import com.atom.atomwechat.enums.ReqMsgTypeEnum;

import java.lang.annotation.*;

/**
 * @author Atom
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MsgType {
    /**
     * 消息类型
     *
     * @return
     */
    ReqMsgTypeEnum type();

    /**
     * 消息bean
     *
     * @return
     */
    Class msgClass();

    String desc() default "";
}
