import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

ResponseObject response = WS.sendRequest(findTestObject('API/account/signup/GET-signup', [('protocol') : GlobalVariable.protocol
            , ('host') : GlobalVariable.host, ('port') : GlobalVariable.port]))

WS.verifyResponseStatusCode(response, 200)

response = WS.sendRequest(findTestObject('API/account/signup/POST-signup', [('protocol') : GlobalVariable.protocol, ('host') : GlobalVariable.host
            , ('port') : GlobalVariable.port, ('csrfToken') : CustomKeywords.'com.kms.api.ApiUtils.getHtmlElementValue'(response.getResponseText(), 
                'input[name=csrfmiddlewaretoken]'), ('username') : 'admin@example.com', ('password') : 'admin', ('cookie') : CustomKeywords.'com.kms.api.ApiUtils.getCookiesPropertyValue'(
                response.getHeaderFields(), 'Set-Cookie', 'csrftoken')[0]]))

WS.verifyResponseStatusCode(response, 200)


