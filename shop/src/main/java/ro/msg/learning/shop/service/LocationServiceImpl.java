package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.repository.LocationRepository;

import java.util.Collection;
import java.util.UUID;
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public void createLocation(Location location) {
        locationRepository.save(location);

    }

    @Override
    public void updateLocation(UUID id, Location location) {
        locationRepository.deleteById(id);
        location.setId(id);
        locationRepository.save(location);
    }

    @Override
    public void deleteLocation(UUID id) {
        locationRepository.deleteById(id);

    }

    @Override
    public Location getById(UUID id) {
        return locationRepository.getReferenceById(id);
    }

    @Override
    public Collection<Location> getLocations() {
        return locationRepository.findAll();
    }
}
