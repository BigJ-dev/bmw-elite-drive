package com.bmw.elitedrive.module.order.model;

import com.bmw.elitedrive.common.exception.EntityNotFoundException;
import com.bmw.elitedrive.common.util.TimeMachine;
import com.bmw.elitedrive.module.client.dao.ClientRepository;
import com.bmw.elitedrive.module.client.model.ClientJpa;
import com.bmw.elitedrive.module.extra.dao.ExtraRepository;
import com.bmw.elitedrive.module.extra.model.ExtraJpa;
import com.bmw.elitedrive.module.order.dao.OrderRepository;
import com.bmw.elitedrive.module.order.dao.OrderService;
import com.bmw.elitedrive.module.order.enums.OrderStatus;
import com.bmw.elitedrive.module.vehicle.dao.VehicleRepository;
import com.bmw.elitedrive.module.vehicle.model.VehicleJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ClientRepository clientRepo;
    private final VehicleRepository vehicleRepo;
    private final ExtraRepository extraRepo;
    private final OrderRepository orderRepo;

    @Override
    @Transactional
    public GetVehicleOrderResponse createVehicleOrder(CreateVehicleOrderRequest request) {
        ClientJpa client = getClient(request.getClientId());
        VehicleJpa vehicle = getVehicle(request.getVehicleId());
        List<ExtraJpa> extras = getExtras(request.getExtraIds());

        OrderJpa orderJpa = generateVehicleOrder(client, vehicle, extras, calculateTotalPrice(vehicle, extras));
        orderRepo.save(orderJpa);
        return null;
    }

    private ClientJpa getClient(Long clientId) {
        return clientRepo.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
    }

    private VehicleJpa getVehicle(Long vehicleId) {
        return vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("This vehicle not found in our records with id: " + vehicleId));
    }

    private List<ExtraJpa> getExtras(Set<Long> extraIds) {
        return extraRepo.findAllById(extraIds);
    }

    private Instant getEstimateDeliveryDate() {
        return TimeMachine.getNow().plus(30, ChronoUnit.DAYS);
    }

    private BigDecimal calculateTotalPrice(VehicleJpa vehicle, List<ExtraJpa> extras) {
        BigDecimal totalPrice = vehicle.getBasePrice();
        BigDecimal extrasTotalPrice = extras.stream()
                .map(extra -> extra.getPrice().add(extra.getAdditionalCost()).multiply(BigDecimal.valueOf(extra.getUnitQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPrice.add(extrasTotalPrice);
    }

    private OrderJpa generateVehicleOrder(ClientJpa client, VehicleJpa vehicle, List<ExtraJpa> extras, BigDecimal totalPrice) {
        OrderJpa orderJpa = OrderJpa.builder()
                .clientJpa(client)
                .vehicleJpa(vehicle)
                .extraJpaList(extras)
                .totalPrice(totalPrice)
                .estimatedDeliveryDate(getEstimateDeliveryDate())
                .orderDate(TimeMachine.getNow())
                .status(OrderStatus.PROCESSING.getValue())
                .build();

        log.info("Order created for client id: {}, Vehicle id: {}", client.getClientId(), vehicle.getVehicleId());
        return orderRepo.save(orderJpa);
    }
}
