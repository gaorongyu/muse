package com.fngry.pelikan.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 异常处理工具类
 * @author gaorongyu
 */
public class ExceptionUtil {

    private static final int MAX_EXCEPTION_LEVEL = 10;

    /**
     * 获取异常堆栈信息
     * @param throwable 异常
     * @return
     */
    public static String getStackTrace(Throwable throwable) {
        List<String> errorList = new ArrayList<>();
        int level = 0;
        while (throwable != null && level < MAX_EXCEPTION_LEVEL) {
            errorList.add(throwable.getMessage());
            Arrays.asList(throwable.getStackTrace()).forEach(x -> errorList.add(x.toString()));

            throwable = throwable.getCause();
            level = level + 1;
        }
        return String.join("\n", errorList);
    }

}
