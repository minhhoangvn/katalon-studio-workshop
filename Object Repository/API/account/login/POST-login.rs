<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>POST-login</name>
   <tag></tag>
   <elementGuidId>bffc0888-9b41-4f71-8491-6e5a8c6d5c8b</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;application/x-www-form-urlencoded&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: [
    {
      &quot;name&quot;: &quot;username&quot;,
      &quot;value&quot;: &quot;${username}&quot;
    },
    {
      &quot;name&quot;: &quot;password&quot;,
      &quot;value&quot;: &quot;${password}&quot;
    },
    {
      &quot;name&quot;: &quot;csrfmiddlewaretoken&quot;,
      &quot;value&quot;: &quot;${csrfToken}&quot;
    }
  ]
}</httpBodyContent>
   <httpBodyType>x-www-form-urlencoded</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/x-www-form-urlencoded</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Cookie</name>
      <type>Main</type>
      <value>${cookie}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${protocol}${host}${port}/en/account/login/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'http://'</defaultValue>
      <description></description>
      <id>d5e4ffe1-af4f-4bed-91a4-d6fa531e0724</id>
      <masked>false</masked>
      <name>protocol</name>
   </variables>
   <variables>
      <defaultValue>'localhost'</defaultValue>
      <description></description>
      <id>3c20802b-46ec-433e-86bb-5df4a7b1343e</id>
      <masked>false</masked>
      <name>host</name>
   </variables>
   <variables>
      <defaultValue>':8000'</defaultValue>
      <description></description>
      <id>520d901b-c427-4ff1-b93d-df1eb8ea6993</id>
      <masked>false</masked>
      <name>port</name>
   </variables>
   <variables>
      <defaultValue>'cY7Q5aCq11CucNITmxVV1s5Em1KNSansGhrsM2xdUR4sPFubUrAtLEiw4DJ84bS2'</defaultValue>
      <description></description>
      <id>04cec362-5d85-4d8a-9852-76921032b4de</id>
      <masked>false</masked>
      <name>csrfToken</name>
   </variables>
   <variables>
      <defaultValue>'admin@example.com'</defaultValue>
      <description></description>
      <id>63d916ae-3dc0-4559-b319-a6f7605f9558</id>
      <masked>false</masked>
      <name>username</name>
   </variables>
   <variables>
      <defaultValue>'admin'</defaultValue>
      <description></description>
      <id>14111b5c-4b69-4fda-acd5-d5e0fcdc1787</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <variables>
      <defaultValue>'csrftoken=ZH1P9v7N8LJEoOGBX0M7KHcwvTeg7KW1t0lrQn2A1BbC1GsTvUrFuTpodvdBjLrB; '</defaultValue>
      <description></description>
      <id>dc5ea854-6cdf-495c-99fd-363b4af53a70</id>
      <masked>false</masked>
      <name>cookie</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
