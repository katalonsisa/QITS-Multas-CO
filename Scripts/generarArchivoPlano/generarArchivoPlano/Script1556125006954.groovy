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

WebUI.click(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/a_menuGenerarArchivoPlanoComparendo'))

WebUI.selectOptionByValue(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/select_secretaria'), 
    '3', true)

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/select_tipoComparendo'), 
    '16', true)

WebUI.delay(1)

WebUI.selectOptionByValue(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/select_criterioBusqueda'), 
    '5', true)

WebUI.sendKeys(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/input_fechaDesde'), Keys.chord('01/03/2019', 
        Keys.TAB))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/input_fechaHasta'), Keys.chord('20/03/2019', 
        Keys.TAB))

WebUI.delay(2)

WebUI.click(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/span_generar'))

WebUI.delay(7)

WebUI.verifyTextNotPresent('No se encuentra ningún registro relacionado con el criterio de búsqueda.', false)

WebUI.delay(1)

