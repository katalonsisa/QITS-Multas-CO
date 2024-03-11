package co.com.quipux.wat
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.es.Cuando
import cucumber.api.java.es.Dado
import cucumber.api.java.es.Entonces
import internal.GlobalVariable


class commons {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Dado("La aplicacion esta disponible")
	def La_aplicacion_esta_disponible() {

		WebUI.openBrowser(GlobalVariable.url)

		WebUI.delay(3)

		def checkApp = WebUI.verifyTextPresent('QITS', false)

		assert checkApp
	}



	@Cuando("La base de datos esta disponible")
	def La_base_de_datos_esta_disponible() {

		def checkDB = checkDatabase.checkDB(GlobalVariable.host.toString(), GlobalVariable.nombreBD.toString(), GlobalVariable.puerto.toString(), GlobalVariable.usuarioBD.toString(), GlobalVariable.claveBD.toString())

		assert checkDB
	}

	@Entonces("Tenemos el sistema disponible")
	def Tenemos_el_sistema_disponible () {
		WebUI.comment("la aplicacion esta disponible")
	}
}