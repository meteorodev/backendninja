package com.drvcorp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drvcorp.entities.Contact;
@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
