package com.drvcorp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.drvcorp.component.ContactConverter;
import com.drvcorp.entities.Contact;
import com.drvcorp.model.ContactModel;
import com.drvcorp.repository.ContactRepository;
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{
	public static final Log LOG = LogFactory.getLog(ContactServiceImpl.class);
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		// TODO Auto-generated method stub
		Contact c = contactRepository.save(contactConverter.contactModel2Contact(contactModel));
		return contactConverter.contact2ContactModel(c);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		
		List<Contact> lc= contactRepository.findAll();
		List<ContactModel> lcm= new ArrayList<ContactModel>();
		LOG.info("METHOD: listAllContacts -- Params : "+lc.size()+" ?");
		for(Contact c : lc){
			LOG.info("METHOD: listAllContacts -- Params : "+c.getId()+" ?"+c.getFirstName()+" ?"+c.getLastName()+" ?");
			lcm.add(contactConverter.contact2ContactModel(c));
		}
		return lcm;
	}

	@Override
	public Contact findContactById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

}
