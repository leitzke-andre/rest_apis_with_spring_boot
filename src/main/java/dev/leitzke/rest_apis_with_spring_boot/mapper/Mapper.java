package dev.leitzke.rest_apis_with_spring_boot.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <O, D> D mapObject(O origin, Class<D> destination){
        return modelMapper.map(origin, destination);
    }

    public static <O, D> List<D> mapListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();
        for (O o: origin
        ) {
            destinationObjects.add(modelMapper.map(o, destination));
        }
        return destinationObjects;
    }
}
