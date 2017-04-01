package com.gumtree;

import com.gumtree.model.AddressBook;
import com.gumtree.parser.LocalParserPerson;
import com.gumtree.reader.LocalFileDataReader;
import com.gumtree.repository.LocalAddressBookRepo;
import com.gumtree.service.AddressBookComparingService;
import com.gumtree.service.AddressBookServiceBean;

public class Application {

    public static void main(String[] args) {

        LocalParserPerson lpp = new LocalParserPerson();
        LocalFileDataReader lfdr = new LocalFileDataReader("/address-book.txt", lpp);
        LocalAddressBookRepo labr = new LocalAddressBookRepo(lfdr.readData());

        AddressBook addressBook = labr.getAddressBook().get();

        AddressBookServiceBean addressBookServiceBean = new AddressBookServiceBean(addressBook);
        AddressBookComparingService abcs = new AddressBookComparingService(addressBookServiceBean);

        System.out.println("1. Number of males: " + addressBookServiceBean.getMale());
        System.out.println("2. Oldest person: " + addressBookServiceBean.getOldest().get().toString());
        System.out.println("3. Age difference in days between Bill and Paul: " + abcs.getAgeDifferenceInDays("Bill McKnight","Paul Robinson").get());
    }
}
