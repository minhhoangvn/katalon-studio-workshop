import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.protocol+GlobalVariable.host+GlobalVariable.port)

WebUI.click(findTestObject('UI/Page_Saleor e-commerce/a_Log in'))

WebUI.setText(findTestObject('UI/Page_Log in  Saleor e-commerce/input_Email_username'), 'admin@example.com')

WebUI.setEncryptedText(findTestObject('UI/Page_Log in  Saleor e-commerce/input_Password_password'), 'RAIVpflpDOg=')

WebUI.click(findTestObject('UI/Page_Log in  Saleor e-commerce/button_Log in'))

WebUI.click(findTestObject('UI/Page_Saleor e-commerce/a_Your account'))

WebUI.click(findTestObject('UI/Page_Your profile  Saleor e-commerce/h3_Change password'))

WebUI.delay(5)

WebUI.setEncryptedText(findTestObject('UI/Page_Your profile  Saleor e-commerce/input_Old password_old_password'), 'RAIVpflpDOg=')

WebUI.setEncryptedText(findTestObject('UI/Page_Your profile  Saleor e-commerce/input_New password_new_password1'), 'RAIVpflpDOg=')

WebUI.click(findTestObject('UI/Page_Your profile  Saleor e-commerce/input_New password_btn btn-primary narrow'))

WebUI.click(findTestObject('UI/Page_Your profile  Saleor e-commerce/div_        Password successfully changed'))

WebUI.click(findTestObject('UI/Page_Your profile  Saleor e-commerce/div_        Account successfully updated'))

WebUI.closeBrowser()

