package com.mikekc.remindme.server.service;

import com.mikekc.remindme.server.NoFoundException;
import com.mikekc.remindme.server.entity.Remind;
import com.mikekc.remindme.server.repository.RemindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private RemindRepository repository;

    public List<Remind> getAll() {
        return repository.findAll();
    }

    public Optional<Remind> getByID(Long id) {
        // repository.findById(id).orElseThrow(() -> new NoFoundException());
        return repository.findById(id);
    }

    public Remind save(Remind remind) {
        return repository.saveAndFlush(remind);
    }

    public void remove(Long id) {
        if (!getByID(id).isPresent()) {
            throw new NoFoundException();
        }
        repository.deleteById(id);
    }
}
