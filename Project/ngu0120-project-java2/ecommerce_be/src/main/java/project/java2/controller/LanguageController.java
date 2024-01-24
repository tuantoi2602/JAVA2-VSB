package project.java2.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:3000")
public class LanguageController {

	private static final Logger log = LogManager.getLogger(LanguageController.class);

	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public Map<String, String> getMessages(@RequestParam String language) {
	    Locale locale = Locale.forLanguageTag(language);
	    Map<String, String> messages = new HashMap<>();
	    
	    String[] messageKeys = {
	        "navbar_home",
	        "navbar_orders",
	        "navbar_products",
	        "navbar_language",
	        "product_listTitle",
	        "product_listAddToCart",
	        "product_detailsTitle",
	        "product_detailsQuantityLabel",
	        "product_detailsAddToCart",
	        "product_view",
	        "dropdown_en",
	        "dropdown_fr",
	        "dropdown_cs",
	        "order_name",
	        "order_date",
	        "order_amount",
	        "order_price",
	        "add_name",
	        "add_description",
	        "add_price",
	        "add_addproduct",
	        "add_product_name",
	        "add_product_description",
	        "add_product_price",
	        "edit_name",
	        "edit_description",
	        "edit_price",
	        "edit_addproduct",
	        "edit_product_name",
	        "edit_product_description",
	        "edit_product_price",
	        "edit_update",
	        "edit_cancel",
	        "product_buy",
	        "product_delete",
	        "product_edit",
	        "today"
	    };
	    log.info("Change language to: {}", language);
	    
	    for (String key : messageKeys) {
	        messages.put(key, messageSource.getMessage(key, null, locale));
	    }

	    
	    
	    return messages;
	}

}


