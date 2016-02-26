package service;

import entity.Sensor;

import java.util.List;

/**
 * Created by Tneciv on 2-26-0026.
 */
public interface IndexService {
    List<Sensor> getSensorByName(String name);
}
