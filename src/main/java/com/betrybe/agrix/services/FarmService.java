package com.betrybe.agrix.services;

import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;

  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Gets farm by id.
   *
   * @param farmId the farm id
   * @return the farm by id
   */
  public Farm getFarmById(Long farmId) {
    Optional<Farm> farmOptional = farmRepository.findById(farmId);
    if (farmOptional.isEmpty()) {
      throw new FarmNotFoundException();
    }
    return farmOptional.get();
  }
}
