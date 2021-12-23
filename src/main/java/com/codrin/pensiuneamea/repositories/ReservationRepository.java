package com.codrin.pensiuneamea.repositories;

import com.codrin.pensiuneamea.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
