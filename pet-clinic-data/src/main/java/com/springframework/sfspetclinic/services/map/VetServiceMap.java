package com.springframework.sfspetclinic.services.map;

import com.springframework.sfspetclinic.model.Vet;
import com.springframework.sfspetclinic.services.SpecialtiesService;
import com.springframework.sfspetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    SpecialtiesService specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialties().size() > 0){

            object.getSpecialties().forEach(specialty -> {
                if(specialty != null){
                    if(specialty.getId() == null){
                        //Setting ID with the just saved specialty
                        specialty.setId(specialtiesService.save(specialty).getId());
                    }

                }else {
                    throw new RuntimeException("Specialty must be set");
                }
            });

        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.deleteByObject(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
