import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.google.gson.*
import groovy.json.JsonSlurper as JsonSlurper

response = WS.sendRequestAndVerify(findTestObject('Compass', [('url') : GlobalVariable.url, ('api_key') : GlobalVariable.api_key
            , ('firmid') : firmid, ('password') : '', ('variable_3') : '', ('variable_4') : '']))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, '[0].Name', 'COMPANY-CONTACT-ADDR-CHK')

WebUI.callTestCase(findTestCase('Companies/Validate Companies Addresses'), [('employee') : 'John', ('department') : 'Finance'], 
    FailureHandling.STOP_ON_FAILURE)

