package com.drvcorp.component;

import org.springframework.stereotype.Component;

import com.drvcorp.entities.Contact;
import com.drvcorp.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact contactModel2Contact(ContactModel contactModel){
		Contact c= new Contact();
		c.setFirstName(contactModel.getFirstName());
		c.setLastName(contactModel.getLastName());
		c.setTelephone(contactModel.getTelephone());
		c.setCity(contactModel.getCity());

		return c;
	}
	
	public ContactModel contact2ContactModel(Contact contact){
		ContactModel cm= new ContactModel();
		cm.setFirstName(contact.getFirstName());
		cm.setLastName(contact.getLastName());
		cm.setTelephone(contact.getTelephone());
		cm.setCity(contact.getCity());
		
		return cm;
	}
}
