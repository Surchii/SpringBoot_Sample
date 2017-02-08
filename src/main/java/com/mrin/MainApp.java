package com.mrin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
public class MainApp{
	public static void main(String[] args) throws Exception {
		new SpringApplication(MainApp.class).run(args);
	}

	@RequestMapping(value={"/","/secured" })
	public String index() {
		return "I am Secured content";
	}
}