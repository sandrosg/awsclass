package com.aws.classe3.controller;

import com.aws.classe3.infra.entity.Logs;
import com.aws.classe3.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class BuscarCep {

	private final LogService logService;

	public BuscarCep(LogService logService) {
		this.logService = logService;
	}

	public record CepRequest(String cep) {}

	@PostMapping("/ceppost")
	public String consultarCepPost(@RequestBody CepRequest request) {
		return validaCep(request.cep());
	}

	@GetMapping("/cep/{cep}")
	public String buscarPorCep(@PathVariable String cep) {
		return validaCep(cep);
	}

	private String validaCep(String cep) {
		try {

			String url =
					"https://viacep.com.br/ws/" +
							cep +
							"/json/";

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

			logService.saveLog(new Logs(cep));

			return response.toString();

		} catch (Exception e) {

			return "{\"erro\":\"" +
					e.getMessage() +
					"\"}";
		}
	}
	
}
