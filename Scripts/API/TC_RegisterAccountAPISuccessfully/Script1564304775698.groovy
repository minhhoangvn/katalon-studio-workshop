import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.jsoup.Jsoup as Jsoup
import org.jsoup.nodes.Document as Document
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable

ResponseObject response = WS.sendRequest(findTestObject('API/account/signup/GET-signup', [('protocol') : GlobalVariable.protocol
            , ('host') : GlobalVariable.host, ('port') : GlobalVariable.port]))

WS.verifyResponseStatusCode(response, 200)

Document htmlDOM = Jsoup.parse(response.getResponseText())

String csrfmiddlewaretoken = htmlDOM.select('input[name=csrfmiddlewaretoken]').first().val()

List<String> cookies = response.getHeaderFields()['Set-Cookie']

cookies = cookies.stream().filter({ def it ->
        String key = it.split('=')[0]

        return key == 'csrftoken'
    }).collect({ def it ->
        it
    })

List<String> cookiesProperties = cookies[0].split(';')

cookiesProperties = cookiesProperties.stream().filter({ def it ->
        String key = it.split('=')[0]

        return key == 'csrftoken'
    }).collect({ def it ->
        it
    })

response = WS.sendRequest(findTestObject('API/account/signup/POST-signup', [('protocol') : GlobalVariable.protocol, ('host') : GlobalVariable.host
            , ('port') : GlobalVariable.port, ('csrfToken') : csrfmiddlewaretoken, ('username') : 'admin1@example.com', ('password') : 'admin'
            , ('cookie') : cookiesProperties[0]]))

WS.verifyResponseStatusCode(response, 200)

