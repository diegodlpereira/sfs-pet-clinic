package com.springframework.sfspetclinic.services.map;

import com.springframework.sfspetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){

        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Cannot save null object");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void deleteByObject(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId;

        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch (RuntimeException re){
            nextId = 1L;
        }
        return nextId;
    }
}
