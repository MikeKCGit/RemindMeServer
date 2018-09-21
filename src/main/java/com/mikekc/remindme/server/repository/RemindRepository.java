package com.mikekc.remindme.server.repository;

import com.mikekc.remindme.server.entity.Remind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemindRepository extends JpaRepository<Remind, Long> {

}
