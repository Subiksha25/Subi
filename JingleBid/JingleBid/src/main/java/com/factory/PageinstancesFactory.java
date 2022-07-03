package com.factory;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.basepage.BasePage;
import com.context.WebDriverContext;

/**
 * A factory for creating Pageinstances objects.
 */
public class PageinstancesFactory {

	/**
	 * Gets the single instance of PageinstancesFactory.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @return single instance of PageinstancesFactory
	 */
	public static <T extends BasePage> T getInstance(Class<T> type) {
		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
