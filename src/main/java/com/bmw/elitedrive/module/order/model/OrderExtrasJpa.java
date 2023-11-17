package com.bmw.elitedrive.module.order.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order_extras", schema = "elite_drive")
public class OrderExtrasJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderExtraId;
    private Long orderId;
    private Long extraId;
}
