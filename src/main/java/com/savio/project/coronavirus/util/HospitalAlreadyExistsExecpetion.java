package com.savio.project.coronavirus.util;

import javax.persistence.EntityExistsException;

public class HospitalAlreadyExistsExecpetion extends EntityExistsException {
    public HospitalAlreadyExistsExecpetion(long cnpj) {
        super(String.format("Estabelecimento já existente no sistema",cnpj));
    }
}
