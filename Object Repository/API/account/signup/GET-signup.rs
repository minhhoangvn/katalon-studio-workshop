<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GET-signup</name>
   <tag></tag>
   <elementGuidId>a4069f80-8f0d-4895-a22e-b016ab6afa66</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;username\u003dasdsa%40dasdas.dsadas\u0026password\u003ddasdsadsa&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>text/plain</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${protocol}${host}${port}/en/account/signup/</restUrl>
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
