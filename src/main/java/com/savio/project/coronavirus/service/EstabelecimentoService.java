package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.DTO.UPADTO;

public interface EstabelecimentoService {

    HospitalDTO cadastrarHospital(HospitalDTO hospitalDTO);

    UPADTO cadastrarUPA(UPADTO upadto);

}
