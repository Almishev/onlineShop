package online.handsmade.shop;

import online.handsmade.shop.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {


		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}

}
