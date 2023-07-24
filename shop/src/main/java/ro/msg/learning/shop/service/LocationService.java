package ro.msg.learning.shop.service;
import ro.msg.learning.shop.entity.Location;

import java.util.Collection;
import java.util.UUID;

public interface LocationService {

    public abstract void createLocation(Location location);
    public abstract void updateLocation(UUID id, Location location);
    public abstract void deleteLocation(UUID id);
    public abstract Location getById(UUID id);
    public abstract Collection<Location> getLocations();
}