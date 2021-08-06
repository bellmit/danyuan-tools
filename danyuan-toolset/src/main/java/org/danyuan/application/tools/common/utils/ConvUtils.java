package org.danyuan.application.tools.common.utils;

import java.math.BigDecimal;

public class ConvUtils {

	/**
	 * 转换值为String型。
	 *
	 * 参 数 : obj
	 *            值
	 * 返 回 : String型
	 */
	public static String convToString(Object obj) {
		if (obj == null) {
			return "";
		}
		if (StringUtils.isEmpty(obj.toString())) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * 转换值为boolean型。
	 *
	 * 参 数 : obj
	 *            值
	 * 返 回 : boolean型
	 */
	public static boolean convToBool(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof byte[]) {
			return convBitToBool((byte[]) obj);
		}
		if ("1".equals(obj.toString())) {
			return true;
		} else if ("0".equals(obj.toString())) {
			return false;
		} else if ("true".equalsIgnoreCase(obj.toString())) {
			return true;
		} else if ("false".equalsIgnoreCase(obj.toString())) {
			return false;
		}
		return false;
	}

	/**
	 * 转换bit为boolean型。
	 *
	 * 参 数 : bytes
	 *            byte
	 * 返 回 : boolean型
	 */
	public static boolean convBitToBool(byte[] bytes) {
		if (bytes == null) {
			return false;
		}
		return bytes[0] == 0x01 ? true : false;
	}

	/**
	 * 转换值为int型。
	 *
	 * 参 数 : obj
	 *            值
	 * 返 回 : int型
	 */
	public static int convToInt(Object value) {
		int intValue = 0;
		if (value == null) {
			return intValue;
		} else {
			try {
				intValue = Integer.parseInt(value.toString().trim().replace(",", ""));
			} catch (NumberFormatException ex) {
				return intValue;
			}
		}
		return intValue;
	}

	/**
	 * 转换值为int型。
	 *
	 * 参 数 : obj
	 *            值
	 * 返 回 : int型
	 */
	public static long convToLong(Object value) {
		long longValue = 0L;
		if (value == null) {
			return longValue;
		} else {
			try {
				longValue = Long.parseLong(value.toString().trim().replace(",", ""));
			} catch (NumberFormatException ex) {
				return longValue;
			}
		}
		return longValue;
	}

	/**
	 * 转换值为double型。
	 *
	 * 参 数 : obj
	 *            值
	 * 返 回 : double型
	 */
	public static double convToDouble(Object pValue) {
		double dblValue = 0D;
		if (pValue == null) {
			return dblValue;
		}
		try {
			dblValue = Double.parseDouble(String.valueOf(pValue).trim().replace(",", ""));
		} catch (Exception ex) {
			return dblValue;
		}
		return dblValue;
	}

	/**
	 * 转换值为BigDecimal型。
	 *
	 * 参 数 : obj
	 *            值
	 * 返 回 : BigDecimal型
	 */
	public static BigDecimal convToDecimal(Object value) {
		BigDecimal dec = new BigDecimal("0");
		if (value == null) {
			return dec;
		} else if (value instanceof BigDecimal) {
			dec = (BigDecimal) value;
		} else {
			try {
				dec = new BigDecimal(String.valueOf(value).trim().replace(",", ""));
			} catch (Exception ex) {
				return dec;
			}
		}
		return dec;
	}

	public static String convToMoney(Object pValue) {
		return String.format("%1$,.2f", convToDecimal(pValue));
	}
}
