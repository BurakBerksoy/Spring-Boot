package com.example.CmAgreementManagementApplication.model.relations.OneToMany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Home")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;

    @OneToMany
    private List<Room> rooms;
}
