package com.fngry.pelikan.common.utils;


import java.util.ArrayList;
import java.util.List;

/**
 * @author gaorongyu
 * @Date 2018/12/31
 */
public class StringTool {

    public static final String SEPARATE_UNDERLINE = "_";

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str.trim());
    }

    /**
     * 根据订单编码追溯所有上级单号 包含自己
     *   比如 PO1909080001_1_2 返回[PO1909080001, PO1909080001_1, PO1909080001_1_2]
     * @param orderNo 单号
     * @return
     */
    public static List<String> traceOrderNo(String orderNo) {
        List<String> traceOrderNos = new ArrayList<>();
        String[] noParts = orderNo.split(SEPARATE_UNDERLINE);
        traceOrderNos.add(noParts[0]);
        for (int i = 1; i < noParts.length; i++) {
            traceOrderNos.add(String.join(SEPARATE_UNDERLINE, traceOrderNos.get(i - 1), noParts[i]));
        }
        return traceOrderNos;
    }

    /**
     * 清除所有符号,只留下字母 数字 汉字 共3类.--6个国家的语言不影响
     * @param str   传入参数
     * @return      处理后的结果
     */
    public static String removeSymbol(String str) {
        if (StringTool.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("[ \\pP\\p{Punct}]","");

    }


    public static String removePunctuation(String str) {
        if (StringTool.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("[ \\-_/]", "");
    }


}
