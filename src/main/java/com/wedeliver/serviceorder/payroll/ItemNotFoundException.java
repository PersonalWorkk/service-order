package com.wedeliver.serviceorder.payroll;

import javax.persistence.EntityNotFoundException;

public class ItemNotFoundException extends EntityNotFoundException{
    public ItemNotFoundException(Long id){
        super("Could not find item " + id);
    }
}
