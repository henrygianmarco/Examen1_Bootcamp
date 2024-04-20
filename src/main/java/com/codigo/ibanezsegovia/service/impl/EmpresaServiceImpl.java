package com.codigo.ibanezsegovia.service.impl;

import com.codigo.ibanezsegovia.dao.EmpresaRepository;
import com.codigo.ibanezsegovia.entity.EmpresaEntity;
import com.codigo.ibanezsegovia.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {


    private final EmpresaRepository empresaRepository;

    //CREAR UNA NUEVA EMPRESA
    @Override
    public EmpresaEntity crear(EmpresaEntity empresaEntity) {
        return empresaRepository.save(empresaEntity);
    }

    // BUSCAR EMPRESA POR ID
    @Override
    public Optional<EmpresaEntity> buscarporId(Long id) {
        return empresaRepository.findById(id);
    }

    // BUSCAR TODAS LAS EMPRESAS
    @Override
    public List<EmpresaEntity> buscarTodos() {
        return empresaRepository.findAll();
    }

    //ACTUALIZACIÓN
    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            EmpresaEntity empresa = empresaRecuperada.get();
            empresa.setRazonSocial(empresaEntity.getRazonSocial());
            empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
            empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
            empresa.setCondicion(empresaEntity.getCondicion());
            empresa.setDireccion(empresaEntity.getDireccion());
            empresa.setProvincia(empresaEntity.getProvincia());
            empresa.setDepartamento(empresa.getDepartamento());
            empresa.setEsAgenteRetencion(empresa.getEsAgenteRetencion());
            return empresaRepository.save(empresa);
        }
        return null;
    }


    //ELIMINACIÓN LOGICA
    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
                empresaRecuperada.get().setEstado(0);
                return empresaRepository.save(empresaRecuperada.get());
            }
        return null;
    }

}
