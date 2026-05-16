package com.aws.classe3.health.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class BuscarCep {

	@GetMapping("/cep/{cep}")
	public String buscarPorCep(@PathVariable String cep) {

		try {

			System.out.println("CEP RECEBIDO: " + cep);

			String url =
					"https://viacep.com.br/ws/" +
							cep +
							"/json/";

			System.out.println("URL: " + url);

			HttpURLConnection connection =
					(HttpURLConnection)
							URI.create(url)
									.toURL()
									.openConnection();

			connection.setRequestMethod("GET");

			int status = connection.getResponseCode();

			System.out.println("STATUS: " + status);

			BufferedReader reader =
					new BufferedReader(
							new InputStreamReader(
									connection.getInputStream()));

			StringBuilder response =
					new StringBuilder();

			String line;

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}

			reader.close();

			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();

			return "{\"erro\":\"" +
					e.getMessage() +
					"\"}";
		}
	}

	public static void main(String[] args) {

		BuscarCep app = new BuscarCep();

		String response =
				app.buscarPorCep("11045002");

		System.out.println(response);
	}

}
