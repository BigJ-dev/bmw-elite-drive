package com.bmw.elitedrive.module.client.model;

import com.bmw.elitedrive.module.order.model.Order;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "client", schema = "elite_drive")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String surname;
    private String idNumber;
    private String contactInfo;
    private String address;
    private Instant registrationDate;

    @OneToMany(mappedBy = "client")
    private Set<Order> orders;
}
