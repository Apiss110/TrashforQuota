package com.trashforquota.ProjectPBO.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pulsa")
@PrimaryKeyJoinColumn(name = "id_reward")
@Data
@EqualsAndHashCode(callSuper = true)
public class Pulsa extends Reward {
    @Column(name = "nominal_pulsa")
    private int nominalPulsa;
}