package com.mikekc.remindme.server.service;

import com.mikekc.remindme.server.entity.Remind;

import java.util.List;
import java.util.Optional;

public interface ReminderService {
    List<Remind> getAll();

    Optional <Remind> getByID(Long id);

    Remind save(Remind remind);

    void remove(Long id);
}
