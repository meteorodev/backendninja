package com.drvcorp.service;

import java.util.List;

import com.drvcorp.entities.Contact;
import com.drvcorp.model.ContactModel;

public interface ContactService {
	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel> listAllContacts();
	public abstract Contact findContactById(int id);
	public ContactModel findContactModelById(int id);
	public abstract void removeContact(int id);
}
