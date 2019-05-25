package com.springframework.sfspetclinic.services.map;

import com.springframework.sfspetclinic.model.Visit;
import com.springframework.sfspetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.deleteByObject(visit);
    }

    @Override
    public Visit save(Visit visit) {
        
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }
        
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
