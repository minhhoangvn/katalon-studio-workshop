package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object protocol
     
    /**
     * <p></p>
     */
    public static Object host
     
    /**
     * <p></p>
     */
    public static Object port
     
    /**
     * <p></p>
     */
    public static Object RP_HOST
     
    /**
     * <p></p>
     */
    public static Object RP_TOKEN
     
    /**
     * <p></p>
     */
    public static Object RP_NAME
     
    /**
     * <p></p>
     */
    public static Object RP_SCREENSHOT_ON_FAILURE
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            protocol = selectedVariables['protocol']
            host = selectedVariables['host']
            port = selectedVariables['port']
            RP_HOST = selectedVariables['RP_HOST']
            RP_TOKEN = selectedVariables['RP_TOKEN']
            RP_NAME = selectedVariables['RP_NAME']
            RP_SCREENSHOT_ON_FAILURE = selectedVariables['RP_SCREENSHOT_ON_FAILURE']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
