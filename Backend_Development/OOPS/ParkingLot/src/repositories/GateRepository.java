package repositories;

import models.Gate;
import models.GateType;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> gates = new HashMap();

    public Optional<Gate> findById(Long gateId) {
        if (gates.containsKey(gateId)) {
            return Optional.ofNullable(gates.get(gateId));
        }

        return Optional.empty();
    }
}
