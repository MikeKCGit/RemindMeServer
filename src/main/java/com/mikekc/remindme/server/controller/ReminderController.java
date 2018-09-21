package com.mikekc.remindme.server.controller;

import com.mikekc.remindme.server.NoFoundException;
import com.mikekc.remindme.server.entity.Remind;
import com.mikekc.remindme.server.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reminders")
@RequiredArgsConstructor
public class ReminderController {

    private final ReminderService service;

    @GetMapping
    public List<Remind> getAllReminders() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public Remind getRemainder(@PathVariable("id") long remindID) {
        if (!service.getByID(remindID).isPresent()) {
            throw new NoFoundException();
        }
        return service.getByID(remindID).get();
    }

    @PostMapping
    public Remind saveReminder(@RequestBody Remind remind) {
        return service.save(remind);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        service.remove(id);
    }

}
