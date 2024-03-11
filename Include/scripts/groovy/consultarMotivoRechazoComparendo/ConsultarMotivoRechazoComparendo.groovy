package consultarMotivoRechazoComparendo
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.java.es.Cuando
import cucumber.api.java.es.Dado
import cucumber.api.java.es.Entonces
import internal.GlobalVariable



class MotivoRechazo {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Dado("yo Estoy logueado (.*)")
	def yo_Estoy_logueado(String Multas) {
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.maximizeWindow()
		WebUI.delay(GlobalVariable.delay)
		WebUI.setText(findTestObject('cas-server-webapp/input_usuario'), GlobalVariable.username)
		WebUI.setEncryptedText(findTestObject('cas-server-webapp/input_contrasenna'), GlobalVariable.password)
		WebUI.click(findTestObject('cas-server-webapp/input_iniciarSesion'))
	}

	@Cuando("Se selecciona la opcion Reportes")
	def Se_selecciona_la_opcion_Reportes() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/btn_ModuloMultas'))
		WebUI.delay(GlobalVariable.delay)
		WebUI.click(findTestObject('qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/a_reportes'))
		WebUI.delay(3)
	}

	@Cuando("Se selecciona la opcion Consulta motivo de rechazo")
	def Se_selecciona_la_opcion_Consulta_motivo_de_rechazo() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/OpcionReportes'))
	}

	//@Cuando("Se selecciona criterio de busqueda (.*)")
	//def Se_selecciona_criterio_de_busqueda(String rangoFechas) {
	//WebUI.selectOptionByValue(findTestObject('qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/select_criterioBusqueda'), rangoFechas, true)
	//WebUI.delay(2)
	//}

	//@Cuando("Se ingresa la Fecha desde (.*)")
	//def Se_ingresa_la_Fecha_desde (String fechaDesde) {
	//WebUI.sendKeys(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/FechaDesde'), Keys.chord(fechaDesde, Keys.TAB))
	//WebUI.delay(1)
	//}

	//@Cuando("Se ingresa la Fecha hasta (.*)")
	//def Se_ingresa_la_Fecha_hasta (String fechaHasta) {
	//WebUI.sendKeys(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/FechaHasta'), Keys.chord(fechaHasta, Keys.TAB))
	//WebUI.delay(2)
	//}

	@Cuando("Se ingresa nro comparendo (.*)")
	def Se_ingresa_nro_comparendo (String nro_comparendo) {
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/Nro_Comparendo'), nro_comparendo)
		WebUI.delay(7)
	}

	@Cuando("Se selecciona Buscar")
	def Se_selecciona_Buscar () {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/consultarMotivoRechazoComparendo/btn_Buscar'))
		WebUI.delay(3)
	}

	@Entonces("Se verifica que no se presente el mensaje (.*)")
	def Se_verifica_que_no_se_presente_el_mensaje(String mensaje) {
		WebUI.verifyTextNotPresent(mensaje, false)
		WebUI.delay(1)
	}
}