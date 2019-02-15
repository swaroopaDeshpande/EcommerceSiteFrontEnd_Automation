package com.amazon.qa.Util;

public class XpathGeneration {
	//Dynamic Xpath Generation 

	// input[@id="{0}"]
	public static String createXpath(String xpathExpression, Object... args) {
		for (int i = 0; i < args.length; i++)

		{
			xpathExpression = xpathExpression.replace("{" + "i}", (CharSequence) args[i]);
		}

		return xpathExpression;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String x1=createXpath("//input[@id='{0}']", "test");
		System.out.println(x1);

	}

}
