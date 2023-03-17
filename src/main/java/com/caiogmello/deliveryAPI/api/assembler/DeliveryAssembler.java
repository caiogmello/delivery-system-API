package com.caiogmello.deliveryAPI.api.assembler;

import com.caiogmello.deliveryAPI.api.model.DeliveryResponseDTO;
import com.caiogmello.deliveryAPI.api.model.input.DeliveryInput;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;

import java.io.DataInput;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

    private ModelMapper modelMapper;

    public DeliveryResponseDTO toModel(Delivery delivery){
        return modelMapper.map(delivery, DeliveryResponseDTO.class);
    }

    public List<DeliveryResponseDTO> toCollectionModel(List<Delivery> deliveries) {
        return deliveries.stream().map(this::toModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInput deliveryInput) {
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
