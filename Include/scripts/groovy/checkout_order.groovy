import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class checkout_order {
	@Given("User login with valid (.*) and (.*)")
	def I_want_to_write_a_step_with_name(String username, String password) {
		WebUI.navigateToUrl('https://www.saucedemo.com/')
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input/input_user-name'), username)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Swag Labs/input/input_password'), password)
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button/button_Login'))
	}

	@When("add item to cart")
	def add_item_to_cart() {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button/button_Add to cart'))
		WebUI.verifyElementText(findTestObject('Page_Swag Labs/text/text_notif_total_item'), '1')
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/icon/icon_cart'))
	}

	@And ("Access cart details by click cart icon")
	def Access_cart_details_by_click_cart_icon() {
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/text/text_item-quantity'), '1')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/text/text_item_name'), 'Sauce Labs Backpack')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/text/text_item_detail'),
				'carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/text/text_price'), '$29.99')
		WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Swag Labs/button/button_Remove'))
	}

	@Then("Click checkout should successfully checkout item")
	def Click_checkout_should_successfully_checkout_item( ) {
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button/button_Checkout'))
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input/input_checkout _firstName'), 'irfan')
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input/input_checkout_lastName'), 'lazuardi')
		WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input/input_checkout_postalCode'), '912312')
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button/button_Cancel_continue'))
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/text/text_Checkout_Overview'), 'Checkout: Overview')
		WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button/button_Finish'))
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/text/text_Checkout_Complete'), 'Checkout: Complete!')
	}
}