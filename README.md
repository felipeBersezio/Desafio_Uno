
1 - Ubicarse en la carpeta del proyecto
2 - Ejecutar el siguiente comando mvn compile war:war
3 - Deployar desafio.war en un servidor tomcat, yo lo desarrolle en tomcat9
4 - Usar soapUI o POSTMAN para ejecutar un servio rest
		http://localhost:8080/desafio/rest/getFechas
5 - en el body entregar el siguiente formato json
	{
		"id": 6,
		"fechaCreacion": "1968-08-01",
		"fechaFin": "1971-06-01",
		"fechas": [
			"1969-03-01",
			"1969-05-01",
			"1969-09-01",
			"1971-05-01"]
	}
6 - Respuesta del servicio
	{
		"fechasFaltantes": ["1968-08-01", "1968-09-01", "1968-10-01", "1968-11-01", "1968-12-01", "1969-01-01", "1969-02-01", "1969-04-01", "1969-06-01", "1969-07-01", "1969-08-01", "1969-10-01", "1969-11-01", "1969-12-01", "1970-01-01", "1970-02-01", "1970-03-01", "1970-04-01", "1970-05-01", "1970-06-01", "1970-07-01", "1970-08-01", "1970-09-01", "1970-10-01", "1970-11-01", "1970-12-01", "1971-01-01", "1971-02-01", "1971-03-01", "1971-04-01", "1971-06-01"],
		"fechaCreacion": "1968-08-01",
		"fechas": ["1969-03-01", "1969-05-01", "1969-09-01", "1971-05-01"],
		"id": 6,
		"fechaFin": "1971-06-01"
	}


