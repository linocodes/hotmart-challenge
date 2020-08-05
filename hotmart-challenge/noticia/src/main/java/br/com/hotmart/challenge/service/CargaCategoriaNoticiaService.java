package br.com.hotmart.challenge.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.hotmart.challenge.exception.BaseException;
import br.com.hotmart.challenge.model.data.Article;
import br.com.hotmart.challenge.model.entity.Categoria;
import br.com.hotmart.challenge.model.response.ArticlesResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * Como forma de nao estressar a api de Noticias o schedule foi configurado para
 * rodar de duas em duas horas. A primeira vez que o projeto for ele será
 * executado apos 5 segundos que o service estiver no ar.
 *
 * @author Marcelo Lino
 *
 */
@Service
@Slf4j
public class CargaCategoriaNoticiaService {

	private static final Integer PAGE_SIZE = 100;
	private static final String URL_NEWS_API_TOP = "https://newsapi.org/v2/top-headlines?category=%s&apiKey=%s&page=1&pageSize=%s";
	private static final String APIKEY = "39ca15496a584f0191bb044d4741dd4a";

	@Autowired
	private CategoriaService service;

	@Scheduled(fixedRate = 7200000, initialDelay = 5000)
	public void scheduleNews() {
		schedule();
	}

	public void offScheduleNews() {
		schedule();
	}

	private void schedule() {
		log.info("Carregar notícias atualizado às {}",
				LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		List<Categoria> categoria = service.list();
		categoria.forEach(s -> chamadaApi(s));
	}

	private void chamadaApi(Categoria entity) {
		Date today = new Date();

		try {
			entity.setDataProcessamento(today);
			entity.setQuantidade(noticiasPorCategoria(entity.getCategoria()));
			service.update(entity, entity.getCategoria());
		} catch (Exception e) {
			log.info("Schedule falhou para a categoria %s.", entity.getCategoria());
		}

	}

    @HystrixCommand(fallbackMethod = "falhaCargaNoticia" )
	private int noticiasPorCategoria(String categoria) {
		try {
			String url = String.format(URL_NEWS_API_TOP, categoria, APIKEY, PAGE_SIZE);
			ArticlesResponse response = new RestTemplate().getForObject(url, ArticlesResponse.class);
			if ("ok".equalsIgnoreCase(response.getStatus())) {
				return validaData(response.getArticles());
			}

		} catch (Exception e) {
			throw new BaseException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Não foi possível carregar a quantidade de notícias por categoria");
		}
		return 0;
	}

	private int validaData(List<Article> articles) {

		int quantidade = 0;
		LocalDate today = LocalDate.now().minusDays(1);

		for (Article article : articles) {
			LocalDate publishedAt = LocalDate.parse(article.getPublishedAt(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
			if (today.isEqual(publishedAt)) {
				quantidade++;
			}
		}
		return quantidade;

	}

	@SuppressWarnings("unused")
	private int falhaCargaNoticia() {
		log.info("Falha ao chamar o serviço da API Noticias");
		return 0;
	}

}
