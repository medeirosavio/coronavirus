package com.savio.project.coronavirus.util;

import javax.persistence.EntityExistsException;

public class UPAAlreadyExistsException extends EntityExistsException {
    public UPAAlreadyExistsException(long cnpj) {
        super(String.format("Estabelecimento já existente no sistema",cnpj));
    }
}
