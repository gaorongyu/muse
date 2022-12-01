package com.fngry.pelikan.common.utils;

import java.math.BigDecimal;

/**
 * 数值计算工具
 *
 * @author gaorongyu
 */
public class NumberUtil {

    public static final BigDecimal HUNDRED = new BigDecimal("100");

    public static final int PERCENT_SCALE = 4;

    public static final int MIDDLE_RESULT_SCALE = 10;


    public static boolean isNotNullAndNotZero(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) != 0;
    }

    public static boolean isGreaterThanZero(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isLessThanZero(BigDecimal value) {
        return value != null && value.compareTo(BigDecimal.ZERO) < 0;
    }

    public static BigDecimal safeBigDecimal(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }

    public static BigDecimal safeBigDecimalAdd(BigDecimal value, BigDecimal... others) {
        BigDecimal result = safeBigDecimal(value);
        for (int i = 0; i < others.length; i++) {
            result = result.add(safeBigDecimal(others[i]));
        }
        return result;
    }

    public static BigDecimal safeBigDecimalSubtract(BigDecimal value, BigDecimal... others) {
        BigDecimal result = safeBigDecimal(value);
        for (int i = 0; i < others.length; i++) {
            result = result.subtract(safeBigDecimal(others[i]));
        }
        return result;
    }

    public static BigDecimal safeBigDecimalMultiply(BigDecimal value, BigDecimal multiplicand, int scale) {
        return safeBigDecimal(value).multiply(safeBigDecimal(multiplicand)).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal safeBigDecimalMultiply(BigDecimal value, BigDecimal multiplicand, int scale, int roundingMode) {
        return safeBigDecimal(value).multiply(safeBigDecimal(multiplicand)).setScale(scale, roundingMode);
    }

    public static BigDecimal safeBigDecimalDivide(BigDecimal value, BigDecimal divisor, int scale) {
        return safeBigDecimal(value).divide(safeBigDecimal(divisor), scale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal safeBigDecimalDivide(BigDecimal value, BigDecimal divisor, int scale, int roundingMode) {
        return safeBigDecimal(value).divide(safeBigDecimal(divisor), scale, roundingMode);
    }

    /**
     * 根据含税金额计算不含税金额
     *
     * @param amountWithVat
     * @param vatRate
     * @param scale
     * @return
     */
    public static BigDecimal withoutVatAmount(BigDecimal amountWithVat, BigDecimal vatRate, int scale) {
        return withoutVatAmount(amountWithVat, vatRate, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 根据含税金额计算不含税金额
     *
     * @param amountWithVat
     * @param vatRate
     * @param scale
     * @param roundingMode
     * @return
     */
    public static BigDecimal withoutVatAmount(BigDecimal amountWithVat, BigDecimal vatRate, int scale, int roundingMode) {
        if(BigDecimal.ZERO.equals(vatRate)) {
            return amountWithVat;
        }

        BigDecimal percentVatRate = safeBigDecimalDivide(vatRate, HUNDRED, PERCENT_SCALE);
        BigDecimal baseRate = safeBigDecimalAdd(BigDecimal.ONE, percentVatRate);
        return safeBigDecimalDivide(amountWithVat, baseRate, scale, roundingMode);
    }

    /**
     * 根据不含税金额计算含税金额
     *
     * @param amountWithoutVat
     * @param vatRate
     * @param scale
     * @return
     */
    public static BigDecimal withVatAmount(BigDecimal amountWithoutVat, BigDecimal vatRate, int scale) {
        return withVatAmount(amountWithoutVat, vatRate, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 根据不含税金额计算含税金额
     *
     * @param amountWithoutVat
     * @param vatRate
     * @param scale
     * @param roundingMode
     * @return
     */
    public static BigDecimal withVatAmount(BigDecimal amountWithoutVat, BigDecimal vatRate, int scale, int roundingMode) {
        BigDecimal percentVatRate = safeBigDecimalDivide(vatRate, HUNDRED, PERCENT_SCALE);
        BigDecimal baseRate = safeBigDecimalAdd(BigDecimal.ONE, percentVatRate);
        return safeBigDecimalMultiply(amountWithoutVat, baseRate, scale, roundingMode);
    }


    /**
     * 根据税后金额算税
     *
     * @param amountWithVat 税后金额
     * @param vatRate       没除以100之前的值
     * @param scale         精度
     * @return
     */
    public static BigDecimal vatFromAmountWithVat(BigDecimal amountWithVat, BigDecimal vatRate, int scale) {
        return vatFromAmountWithVat(amountWithVat, vatRate, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 根据税后金额算税
     *
     * @param amountWithVat 税后金额
     * @param vatRate       没除以100之前的值
     * @param scale         精度
     * @param roundingMode  舍入方式
     * @return
     */
    public static BigDecimal vatFromAmountWithVat(BigDecimal amountWithVat, BigDecimal vatRate, int scale, int roundingMode) {
        BigDecimal percentVatRate = safeBigDecimalDivide(vatRate, HUNDRED, PERCENT_SCALE);
        BigDecimal amountWithoutVat = withoutVatAmount(amountWithVat, vatRate, MIDDLE_RESULT_SCALE);
        return safeBigDecimalMultiply(amountWithoutVat, percentVatRate, scale, roundingMode);
    }

    /**
     * 根据税前金额算税
     *
     * @param amountWithoutVat 税前金额
     * @param vatRate          没除以100之前的值
     * @param scale            精度
     * @param roundingMode     舍入方式
     * @return
     */
    public static BigDecimal vatFromAmountWithoutVat(BigDecimal amountWithoutVat, BigDecimal vatRate, int scale, int roundingMode) {
        BigDecimal percentVatRate = safeBigDecimalDivide(vatRate, HUNDRED, PERCENT_SCALE);
        return safeBigDecimalMultiply(amountWithoutVat, percentVatRate, scale, roundingMode);
    }

    /**
     * 根据税前金额算税
     *
     * @param amountWithoutVat 税前金额
     * @param vatRate          没除以100之前的值
     * @param scale            精度
     * @return
     */
    public static BigDecimal vatFromAmountWithoutVat(BigDecimal amountWithoutVat, BigDecimal vatRate, int scale) {
        BigDecimal percentVatRate = safeBigDecimalDivide(vatRate, HUNDRED, PERCENT_SCALE);
        return safeBigDecimalMultiply(amountWithoutVat, percentVatRate, scale, BigDecimal.ROUND_HALF_UP);

    }

    /**
     * 数值比较
     * @param a
     * @param b
     * @return
     */
    public static boolean bigDecimalEquals(BigDecimal a, BigDecimal b) {
        return safeBigDecimal(a).compareTo(safeBigDecimal(b)) == 0;
    }

    public static BigDecimal max(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static BigDecimal min(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > 0 ? b : a;
    }
}
