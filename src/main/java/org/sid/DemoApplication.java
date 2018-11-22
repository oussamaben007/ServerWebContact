package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
    @Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("oussama", "Ben Abdallah",df.parse("10/09/1991"),"oussamabenabdallah2016@gmail.com", 20634311, "photo"));
		contactRepository.save(new Contact("Ali", "Ben Abdallah",df.parse("10/09/1991"),"oussama2016@gmail.com", 2563412, "photo"));
		contactRepository.save(new Contact("Mohammed", "Ben Abdallah",df.parse("10/09/1991"),"benabdallah@gmail.com", 20634311, "photo"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
			
		});
	}
}
