package com.caiogmello.deliveryAPI.api.controller;

import com.caiogmello.deliveryAPI.api.assembler.OccurrenceAssembler;
import com.caiogmello.deliveryAPI.api.model.DeliveryResponseDTO;
import com.caiogmello.deliveryAPI.api.model.OccurrenceResponseDTO;
import com.caiogmello.deliveryAPI.api.model.input.DeliveryInput;
import com.caiogmello.deliveryAPI.api.model.input.OccurrenceInput;
import com.caiogmello.deliveryAPI.domain.model.Delivery;
import com.caiogmello.deliveryAPI.domain.model.Occurrence;
import com.caiogmello.deliveryAPI.domain.service.GetDeliveryService;
import com.caiogmello.deliveryAPI.domain.service.RecordOccurrenceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurreceController {

    private GetDeliveryService getDeliveryService;
    private RecordOccurrenceService recordOccurrenceService;
    private OccurrenceAssembler occurrenceAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceResponseDTO register(@PathVariable Long deliveryId,
                                          @Valid @RequestBody OccurrenceInput occurrenceInput) {
        Occurrence occurrence = recordOccurrenceService
                .register(deliveryId, occurrenceInput.getDescription());

        return occurrenceAssembler.toModel(occurrence);
    }

    @GetMapping
    public List<OccurrenceResponseDTO> list(@PathVariable Long deliveryId) {
        Delivery delivery = getDeliveryService.get(deliveryId);

        return occurrenceAssembler.toCollectionModel(delivery.getOccurrences());
    }
}
