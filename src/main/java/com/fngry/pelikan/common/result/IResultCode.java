package com.fngry.pelikan.common.result;

/**
 *
 * @author gaorongyu
 * @Date 2018/12/18
 */
public interface IResultCode {

    /**
     * 获取code
     * @return
     */
    String getCode();

    /**
     * 获取描述信息
     * @return
     */
    String getMessage();

    /**
     * 获取描述信息
     * @param args
     * @return
     */
    String getMessage(Object... args);

}
