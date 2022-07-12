package com.qianhuan.common.core.text;

import com.qianhuan.common.utils.StringUtils;

public class StrFormatter {
    public static final String EMPTY_JSON = "{}";

    public static final char C_BACKSLASH = '\\';
    public static final char C_DELTM_START = '{';
    public static final char C_DELTM_END = '}';

    /**
     * 格式化字符串<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param strPattern 字符串模板
     * @param argArray 参数列表
     * @return 结果
     */
    public static String format(final String strPattern, final Object... argArray) {
        if (StringUtils.isEmpty(strPattern) || StringUtils.isEmpty(argArray))
        {
            return strPattern;
        }
        final int strPatternLength = strPattern.length();
        // 初始化定义好的长度以获得更好的性能
        StringBuilder sbuf = new StringBuilder(strPatternLength + 50);
        // 非占位符的起始位置
        int handledPosition = 0;
        // 占位符所在的位置
        int placeHolderIndex;

        for (int argIndex = 0; argIndex < argArray.length; argIndex ++) {
            // 返回此字符串中第一次出现指定子字符串的索引
            placeHolderIndex = strPattern.indexOf(EMPTY_JSON, handledPosition);
            if (-1 == placeHolderIndex) {
                if(0 == handledPosition) {
                    return strPattern;
                }
                else {
                    // 剩余部分不再包含占位符，重新加入结果
                    sbuf.append(strPattern, handledPosition, strPatternLength);
                    return sbuf.toString();
                }
            }
            else {
                // charAt() 返回指定索引处的字符
                if (placeHolderIndex > 0 && strPattern.charAt(placeHolderIndex - 1) == C_BACKSLASH) {
                    if (placeHolderIndex > 1 && strPattern.charAt(placeHolderIndex - 2) == C_BACKSLASH) {
                        // 转义符之前还有一个转义符，占位符依旧有效
                        sbuf.append(strPattern, handledPosition, placeHolderIndex - 1);
                        sbuf.append(Convert.utf8Str(argArray[argIndex]));
                        handledPosition = placeHolderIndex + 2;
                    }
                    else {
                        // 占位符被转义
                        argIndex --;
                        sbuf.append(strPattern, handledPosition, placeHolderIndex - 1);
                        sbuf.append(C_DELTM_START);
                        handledPosition = placeHolderIndex + 1;
                    }
                }
                else {
                    // 正常占位符
                    sbuf.append(strPattern, handledPosition, placeHolderIndex);
                    sbuf.append(Convert.utf8Str(argArray[argIndex]));
                    handledPosition = placeHolderIndex + 2;
                }
            }
        }
        // 加入最后一个占位符后所有的字符
        sbuf.append(strPattern, handledPosition, strPattern.length());
        return sbuf.toString();
    }
}
