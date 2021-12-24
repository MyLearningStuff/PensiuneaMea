package com.codrin.pensiuneamea.repositories;

import com.codrin.pensiuneamea.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
