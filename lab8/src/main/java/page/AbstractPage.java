package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public abstract class AbstractPage
{
	protected WebDriver driver;

	protected final int WAIT_TIMEOUT_SECONDS = 10;

	protected final Logger logger = LogManager.getRootLogger();

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;

	}


}
