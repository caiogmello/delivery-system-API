package com.caiogmello.deliveryAPI.api.assembler;

import com.caiogmello.deliveryAPI.api.model.OccurrenceResponseDTO;
import com.caiogmello.deliveryAPI.domain.model.Occurrence;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {

    private ModelMapper modelMapper;

    public OccurrenceResponseDTO toModel(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceResponseDTO.class);
    }

    public List<OccurrenceResponseDTO> toCollectionModel(List<Occurrence> occurrences) {
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
