package com.poli.fda.repository;

import com.poli.fda.entity.Compuesto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CompuestoRepository extends MongoRepository<Compuesto,String> {

    Optional<List<Compuesto>> findCompuestosByRdaIsBetween(int min, int max);

}
