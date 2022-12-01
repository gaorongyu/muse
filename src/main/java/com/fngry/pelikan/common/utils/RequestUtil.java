package com.fngry.pelikan.common.utils;

import com.fngry.pelikan.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * 请求数据工具类
 * @author gaorongyu
 */
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    private static final int MAX_RETRY_TIMES = 10;

    private static final long SLEEP_TIME = 500;

    /**
     * 重试获取数据
     *
     * @param supplier 获取数据方法
     * @param <T>
     * @return
     */
    public static <T> T retryGet(Supplier<Result<T>> supplier) {
        return retryGet(supplier, MAX_RETRY_TIMES, SLEEP_TIME);
    }


    /**
     * 重试获取数据
     *
     * @param supplier 获取数据方法
     * @param maxRetryTimes 最大重试次数
     * @param sleepTime 每次重试sleep时间
     * @param <T>
     * @return
     */
    public static <T> T retryGet(Supplier<Result<T>> supplier, int maxRetryTimes, long sleepTime) {
        T obj = null;
        for (int i = 0; i < maxRetryTimes; i++) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                logger.warn(" retry get data interrupted ");
            }

            Result<T> queryResult;
            try {
                queryResult = supplier.get();
            } catch (Exception e) {
                if (e instanceof IOException) {
                    // 网络异常等情况 需要重试
                    logger.warn(" retry get data IOException ", e);
                    continue;
                }
                throw e;
            }
            if (queryResult.isSuccess() && queryResult.getData() != null) {
                obj = queryResult.getData();
                break;
            }
        }
        return obj;
    }

    /**
     * 重试获取数据
     *
     * @param supplier 获取数据方法
     * @param <T>
     * @return
     */
    public static <T> T retryGetValue(Supplier<T> supplier) {
        return retryGetValue(supplier, MAX_RETRY_TIMES, SLEEP_TIME);
    }

    /**
     * 重试获取数据
     *
     * @param supplier 获取数据方法
     * @param maxRetryTimes 最大重试次数
     * @param sleepTime 每次重试sleep时间
     * @param <T>
     * @return
     */
    public static <T> T retryGetValue(Supplier<T> supplier, int maxRetryTimes, long sleepTime) {
        T obj = null;
        for (int i = 0; i < maxRetryTimes; i++) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                logger.warn(" retry get data interrupted ");
            }
            obj = supplier.get();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }

}
