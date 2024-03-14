package trustwallettechtest.bdd.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import trustwallettechtest.bdd.Driver;

public class HomePage extends Driver
{
	private WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	public void ClickGetStartedBtn()
	{
		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Get Started\"]"));
		element.click();
	}

	public void ClickCreateWalletBtn() 
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Create new wallet\"]")));
		element.click();
	}
	public void ClickSkipBackup() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"SKIP\"]")));
		element.click();
	}

	public void ClickBackupManually() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Back up manually\"]")));
		element.click();
	}

	public void SelectAllAcceptImportanceOfSecret()
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Trust Wallet does not keep a copy of your secret phrase.\"]")));
		element.click();

		element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Saving this digitally in plain text is NOT recommended. Examples include screenshots, text files, or emailing yourself\"]"));
		element.click();

		element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Write down your secret phrase, and store it in a secure offline location!\"]"));
		element.click();
	}

	public void ClickContinueBtn()
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Continue\"]")));
		element.click();
	}

	public void ClickConfirmBtn()
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Confirm\"]")));
		element.click();
	}


	public void SelectSecretPhaseKeys(boolean isValid)
	{
		WebElement viewElement = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]")));
		List<String> textList = new ArrayList<>();
		List<WebElement> elements = viewElement.findElements(AppiumBy.className("android.widget.TextView"));
		for(WebElement element : elements){
			textList.add(element.getText());
		}
		ClickContinueBtn();
		List<WebElement> secretPhaseTextSelectionElements = driver.findElements(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView"));
		if(isValid)
		{
			for(WebElement element : secretPhaseTextSelectionElements)
			{

				String wordText = element.getText();
				wordText.replace("Word #", "");

				for(String str  : textList)
				{
					if(str.startsWith(wordText.replace("Word #", "")))
					{
						String correctPhrase = str.replaceAll("[0-9]+\\.", "").trim();
						System.out.println("Selected word:"+correctPhrase);
						WebElement phraseElement = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\""+correctPhrase+"\"]")));
						phraseElement.click();
					}
				}
			}
		}
		else
		{
			WebElement phraseElement = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.Button"));
			phraseElement.click();
			phraseElement = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[6]/android.widget.Button"));
			phraseElement.click();
			phraseElement = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[9]/android.widget.Button"));
			phraseElement.click();
			phraseElement = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[12]/android.widget.Button"));
			phraseElement.click();
		}
		ClickConfirmBtn();
	}

	public void ClickNumber(String number)
	{
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\""+number+"\"]")));
		element.click();
	}

	public List<String> GetAllWidgetTextStrings(String elementText)
	{
		WebElement textElement = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\""+elementText+"\"]")));
		List<String> textList = new ArrayList<>();
		List<WebElement> elements = driver.findElements(AppiumBy.className("android.widget.TextView"));
		for(WebElement element : elements){
			textList.add(element.getText());
		}
		return textList;
	}
}
