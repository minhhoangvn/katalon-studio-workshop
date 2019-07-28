package com.kms.api

import org.jsoup.Jsoup
import org.jsoup.nodes.Document as Document

import com.kms.katalon.core.annotation.Keyword

public class ApiUtils {
	@Keyword
	String getHtmlElementValue(String htmlDOMString, String elementSelector){
		Document htmlDOM = Jsoup.parse(htmlDOMString)
		return htmlDOM.select(elementSelector).first().val()
	}

	@Keyword
	List<String> getCookiesPropertyValue( Map<String, List<String>> headers, String cookieKey, String propertyKey){
		List<String> cookies = headers[cookieKey]
		cookies = cookies.stream().filter({ def it ->
			String key = it.split('=')[0]

			return key == propertyKey
		}).collect({ def it -> it })
		List<String> cookiesProperties = cookies[0].split(';')
		cookiesProperties = cookiesProperties.stream().filter({ def it ->
			String key = it.split('=')[0]
			return key == propertyKey
		}).collect({ def it -> it })
	}
}
