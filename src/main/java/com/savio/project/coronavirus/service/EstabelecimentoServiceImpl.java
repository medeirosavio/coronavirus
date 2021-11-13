package com.savio.project.coronavirus.service;

import com.savio.project.coronavirus.DTO.HospitalDTO;
import com.savio.project.coronavirus.mapper.HospitalMapper;
import com.savio.project.coronavirus.model.Hospital;
import com.savio.project.coronavirus.repository.EstabelecimentoRepository;
import com.savio.project.coronavirus.util.HospitalAlreadyExistsExecpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    private final static HospitalMapper hospitalMapper = HospitalMapper.INSTANCE;

    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    public EstabelecimentoServiceImpl(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public HospitalDTO cadastrarHospital(HospitalDTO hospitalDTO) {
        estabelecimentoRepository.findByCnpj(hospitalDTO.getCnpj())
                .ifPresent(hospital -> {throw new HospitalAlreadyExistsExecpetion(hospital.getCnpj());});

        Hospital hospitalToCreate = hospitalMapper.toModel(hospitalDTO);
        Hospital createdHospital = estabelecimentoRepository.save(hospitalToCreate);
        return hospitalMapper.toDTO(createdHospital);
    }
}
