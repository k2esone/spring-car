package pl.sda.springcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springcar.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
