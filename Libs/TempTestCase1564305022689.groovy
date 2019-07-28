import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('/var/folders/k4/93bf7_yn3g1_wzvtjdrp3_kw0000gp/T/Katalon/Test Cases/API/TC_RegisterAccountAPISuccessfullyWithCustomKeywords/20190728_161022/execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/API/TC_RegisterAccountAPISuccessfullyWithCustomKeywords', new TestCaseBinding('Test Cases/API/TC_RegisterAccountAPISuccessfullyWithCustomKeywords',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
